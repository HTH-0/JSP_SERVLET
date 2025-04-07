package C09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import C04.UserDto;

public class DBUtils {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	//싱글톤 
	private static DBUtils instance;
	private DBUtils() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	}
	public static DBUtils getInstance() throws Exception {
		if(instance==null)
			instance = new DBUtils();
		return instance;
	}
	
	//3-4
	public int insertUser(UserDto userDto) throws Exception {
		
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRole());
		int result = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		return result; 
	}
	public int updateUser(UserDto userDto) throws Exception {
		
		pstmt = conn.prepareStatement("update TBL_USER set password=?,role=? where userid=?");
		pstmt.setString(1, userDto.getPassword());
		pstmt.setString(2, userDto.getRole());
		pstmt.setString(3, userDto.getUserid());
		int result = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		return result; 
	}
	public List<UserDto> selectAllUser() throws Exception{
		
		pstmt = conn.prepareStatement("select * from TBL_USER");
		rs =  pstmt.executeQuery();
		List<UserDto> list = new ArrayList();
		UserDto userDto = null;
		if(rs != null) {
			while(rs.next()) {
				userDto = new UserDto();
				userDto.setUserid(rs.getString("userid"));
				userDto.setPassword(rs.getString("password"));
				userDto.setRole(rs.getString("role"));
				list.add(userDto);
			}	
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public UserDto selectOneUser(String userid) throws Exception {
		pstmt = conn.prepareStatement("select * from TBL_USER where userid=?");
		pstmt.setString(1, userid);
		rs =  pstmt.executeQuery();
		
		UserDto userDto = null;
		if(rs != null) {
			rs.next();
			userDto = new UserDto();
			userDto.setUserid(rs.getString("userid"));
			userDto.setPassword(rs.getString("password"));
			userDto.setRole(rs.getString("role"));
		}
		rs.close();
		pstmt.close();
		return userDto;
	}
	public int deleteUser(String userid) throws Exception {
		
		pstmt = conn.prepareStatement("delete from tbl_user where userid=?");
		pstmt.setString(1, userid);
		
		int result = pstmt.executeUpdate();
		
		conn.commit();
		
		pstmt.close();
		return result; 
	}
	//selectAllOrder
	public List<OrderDto> selectAllOrder1() throws Exception{
		//SQL
//		select CATEGORY,sum(price*quantity) from tbl_order
//		group by CATEGORY
//		having sum(price*quantity) >=50000
//		order by sum(price*quantity) desc;
		
		String sql = "select CATEGORY,sum(price*quantity) from tbl_order"
				+ " group by CATEGORY"
				+ " having sum(price*quantity) >=50000"
				+ " order by sum(price*quantity) desc" ;
				
		
		
		pstmt = conn.prepareStatement(sql);
		rs =  pstmt.executeQuery();
		List<OrderDto> list = new ArrayList<>();
		OrderDto orderDto = null;
		if(rs != null) {
			while(rs.next()) {
				orderDto = new OrderDto();
				orderDto.setCATEGORY(rs.getString(1));
				orderDto.setSUM(rs.getInt(2));
				list.add(orderDto);
			}	
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public List<OrderDto> selectAllOrder2() throws Exception{
		//SQL
//		SELECT order_date, round(avg(price * quantity),2)
//		FROM tbl_order
//		GROUP BY order_date
		
		String sql = "SELECT order_date, round(avg(price * quantity),2)"
				+ " FROM tbl_order"
				+ " GROUP BY order_date";
				
		
		
		pstmt = conn.prepareStatement(sql);
		rs =  pstmt.executeQuery();
		List<OrderDto> list = new ArrayList<>();
		OrderDto orderDto = null;
		if(rs != null) {
			while(rs.next()) {
				orderDto = new OrderDto();
				orderDto.setORDER_DATE(rs.getDate(1).toLocalDate());
				orderDto.setAVG(rs.getInt(2));
				list.add(orderDto);
			}	
		}
		rs.close();
		pstmt.close();
		return list;
	}
	public List<OrderDto> selectAllOrder3() throws Exception{
//	SELECT u.addr, o.order_date, sum(o.price * o.quantity) FROM tbl_user u
//    JOIN tbl_order o
//    ON u.userid = o.userid
//    GROUP BY u.addr, o.order_date
//    ORDER BY u.addr asc, sum(o.price * o.quantity) desc;
		
		String sql = "SELECT u.addr, o.order_date, sum(o.price * o.quantity) FROM tbl_user u"
				+ " JOIN tbl_order o"
				+ " ON u.userid = o.userid"
				+ " GROUP BY u.addr, o.order_date"
				+ " ORDER BY u.addr asc, sum(o.price * o.quantity) desc" ;
				
		
		pstmt = conn.prepareStatement(sql);
		rs =  pstmt.executeQuery();
		List<OrderDto> list = new ArrayList<>();
		OrderDto orderDto = null;
		if(rs != null) {
			while(rs.next()) {
				orderDto = new OrderDto();
				orderDto.setADDR(rs.getString(1));
				orderDto.setORDER_DATE(rs.getDate(2).toLocalDate());
				orderDto.setSUM(rs.getInt(3));
				list.add(orderDto);
			}	
		}
		rs.close();
		pstmt.close();
		return list;
	}
	public List<OrderDto> selectAllOrder4() throws Exception{
//		SELECT u.addr, o.order_date, sum(o.price * o.quantity) FROM tbl_user u
//	    JOIN tbl_order o
//	    ON u.userid = o.userid
//	    GROUP BY u.addr, o.order_date
//	    ORDER BY u.addr asc, sum(o.price * o.quantity) desc;
			
			String sql = "SELECT u.addr, o.order_date, sum(o.price * o.quantity) FROM tbl_user u"
					+ " JOIN tbl_order o"
					+ " ON u.userid = o.userid"
					+ " GROUP BY u.addr, o.order_date"
					+ " ORDER BY u.addr asc, sum(o.price * o.quantity) desc";
			
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			List<OrderDto> list = new ArrayList<>();
			OrderDto orderDto = null;
			if(rs != null) {
				while(rs.next()) {
					orderDto = new OrderDto();
					orderDto.setADDR(rs.getString(1));
					orderDto.setORDER_DATE(rs.getDate(2).toLocalDate());
					orderDto.setSUM(rs.getInt(3));
					list.add(orderDto);
				}	
			}
			rs.close();
			pstmt.close();
			return list;
		}
	
	
}







