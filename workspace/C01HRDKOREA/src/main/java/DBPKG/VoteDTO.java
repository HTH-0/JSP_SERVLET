package DBPKG;

public class VoteDTO {
	private String m_jumin;
	private String m_name;
	private String m_no;
	private String v_time;
	private String v_area;
	private String v_confirm;
	public VoteDTO() {}
	public VoteDTO(String m_jumin, String m_name, String m_no, String v_time, String v_area, String v_confirm) {
		super();
		this.m_jumin = m_jumin;
		this.m_name = m_name;
		this.m_no = m_no;
		this.v_time = v_time;
		this.v_area = v_area;
		this.v_confirm = v_confirm;
	}
	public String getM_jumin() {
		return m_jumin;
	}
	public void setM_jumin(String m_jumin) {
		this.m_jumin = m_jumin;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getV_time() {
		return v_time;
	}
	public void setV_time(String v_time) {
		this.v_time = v_time;
	}
	public String getV_area() {
		return v_area;
	}
	public void setV_area(String v_area) {
		this.v_area = v_area;
	}
	public String getV_confirm() {
		return v_confirm;
	}
	public void setV_confirm(String v_confirm) {
		this.v_confirm = v_confirm;
	}
	@Override
	public String toString() {
		return "VoteDTO [m_jumin=" + m_jumin + ", m_name=" + m_name + ", m_no=" + m_no + ", v_time=" + v_time
				+ ", v_area=" + v_area + ", v_confirm=" + v_confirm + "]";
	}
	
}
