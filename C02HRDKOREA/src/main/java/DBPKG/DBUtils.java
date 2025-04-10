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
	public DBUtils() {

	}
    public static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe",
            "system",
            "1234"
        );
        return con;
    }
    
    public List<MemberDTO> func1() throws Exception {
    	con = getConnection();
//		select m.m_no, m.m_name, p.p_code, m.p_school, m.m_jumin, m.m_city
//		from TBL_MEMBER_202005 m
//    	join tbl_party_202005 p
//    	on m.p_code = p.p_code;
	
    	String sql = "select m.m_no, m.m_name, p.p_name, m.p_school, m.m_jumin, m.m_city, p.p_tel1, p.p_tel2, p.p_tel3"
    			+ " from TBL_MEMBER_202005 m"
    			+ " join tbl_party_202005 p"
    			+ " on m.p_code = p.p_code";
    	
    	pstmt = con.prepareStatement(sql);
    	rs = pstmt.executeQuery();
    	List<MemberDTO> list = new ArrayList<>();
    	MemberDTO dto = null;
    	if (rs != null) {
    		while(rs.next()) {
    			dto = new MemberDTO();
    			dto.setM_no(rs.getString(1));
    			dto.setM_name(rs.getString(2));
    			dto.setP_name(rs.getString(3));
    			dto.setP_school(rs.getString(4));
    			dto.setM_jumin(rs.getString(5));
    			dto.setM_city(rs.getString(6));
    			dto.setP_tel1(rs.getString(7));
    			dto.setP_tel2(rs.getString(8));
    			dto.setP_tel3(rs.getString(9));
				list.add(dto);
				
			}	
    	}
    	rs.close();
    	pstmt.close();
    	return list;
    }
    
    public int func2(VoteDTO voteDTO) throws Exception {
    	con = getConnection();
    	// insert into tbl_vote_202005 values(?,?,?,?,?,?)
    	
    	String sql = "insert into tbl_vote_202005 values(?,?,?,?,?,?)";
    	
    	pstmt = con.prepareStatement(sql);
    	
    	pstmt.setString(1, voteDTO.getV_jumin());
    	pstmt.setString(2, voteDTO.getV_name());
    	pstmt.setString(3, voteDTO.getM_no());
    	pstmt.setString(4, voteDTO.getV_time());
    	pstmt.setString(5, voteDTO.getV_area());
    	pstmt.setString(6, voteDTO.getV_confirm());
    	
    	
    	int result = pstmt.executeUpdate();
    	pstmt.close();
    	return result;
    }
    public int func3() {
//    	SELECT m.m_no, m.m_name, COUNT(v_confirm) FROM tbl_member_202005 m
//    	JOIN tbl_vote_202005 v
//    	ON m.m_no = v.m_no
//    	WHERE v_confirm = 'Y'
//    	GROUP BY m.m_no, m.m_name
//    	ORDER BY count(v.v_confirm) DESC
    }
}
