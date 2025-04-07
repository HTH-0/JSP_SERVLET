package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
    public static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe",
            "system",
            "1234"
        );
        return con;
    }
    
    public List<MemberDto> func1() throws Exception {
    	con = getConnection();
//		select m.m_no, m.m_name, p.p_code, m.p_school, m.m_jumin, m.m_city
//		from TBL_MEMBER_202005 m
//    	join tbl_party_202005 p
//    	on m.p_code = p.p_code;
	
    	String sql = "select m.m_no, m.m_name, p.p_code, m.p_school, m.m_jumin, m.m_city, p.p_tel1, p.p_tel2, p.p_tel3"
    			+ " from TBL_MEMBER_202005 m"
    			+ " join tbl_party_202005 p"
    			+ " on m.p_code = p.p_code";
    	
    	pstmt = con.prepareStatement(sql);
    	rs = pstmt.executeQuery();
    	List<MemberDto> list = new ArrayList<>();
    	MemberDto memberDto = null;
    	if (rs != null) {
    		while(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setM_no(rs.getString(1));
				memberDto.setM_name(rs.getString(2));
				memberDto.setP_code(rs.getString(3));
				memberDto.setP_school(rs.getString(4));
				memberDto.setM_jumin(rs.getString(5));
				memberDto.setM_city(rs.getString(6));
				memberDto.setP_tel1(rs.getString(7));
				memberDto.setP_tel2(rs.getString(8));
				memberDto.setP_tel3(rs.getString(9));
				list.add(memberDto);
				
			}	
    	}
    	rs.close();
    	pstmt.close();
    	return list;
    }
    
    
    
}
