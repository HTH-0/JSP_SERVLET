package C09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import C04.UserDto;

public class DBUtils {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";
			
			
	// 싱글톤
	private static DBUtils instance;
	private DBUtils() throws Exception{		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	}

	public static DBUtils getInstance() throws Exception {
		if (instance == null) {
			instance = new DBUtils();
		}
		return instance;
	}
	
	public int insertUser(UserDto userDto) throws Exception{
		pstmt = conn.prepareStatement("INSERT INTO tbl_user VALUES (?, ?, ?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRole());
		int result = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		return result;
	}
	public List<UserDto> selectAlluser() throws Exception{
		List<UserDto> list = new ArrayList<>();
		pstmt = conn.prepareStatement("SELECT * FROM tbl_user");
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			list.add(new UserDto(rs.getString("userid"), rs.getString("password"), rs.getString("role")));
		}
		rs.close();
		pstmt.close();
		return list;
	}
	public int updateUser(UserDto userDto) throws Exception{
		pstmt = conn.prepareStatement("UPDATE tbl_user SET (?, ?) WHERE userid = ?");
		pstmt.setString(1, userDto.getPassword());
		pstmt.setString(2, userDto.getRole());
		pstmt.setString(3, userDto.getUserid());
		
		int result = pstmt.executeUpdate();
		return result;
	}

}
