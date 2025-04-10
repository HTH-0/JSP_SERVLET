package DBPKG;

public class ResultDTO {
	private int m_no;
	private String m_name;
	private int count;
	
	
	public ResultDTO() {}


	public ResultDTO(int m_no, String m_name, int count) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.count = count;
	}


	public int getM_no() {
		return m_no;
	}


	public void setM_no(int m_no) {
		this.m_no = m_no;
	}


	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "ResultDTO [m_no=" + m_no + ", m_name=" + m_name + ", count=" + count + "]";
	}
	
	
	
}
