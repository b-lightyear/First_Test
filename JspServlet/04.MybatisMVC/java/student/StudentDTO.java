package student;

public class StudentDTO {
	private String student_name, user_id, user_pw, first_name, last_name;
	private int student_no;
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(String student_name, String user_id, String user_pw, String first_name, String last_name,
			int student_no) {
		super();
		this.student_name = student_name;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.first_name = first_name;
		this.last_name = last_name;
		this.student_no = student_no;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getStudent_no() {
		return student_no;
	}

	public void setStudent_no(int student_no) {
		this.student_no = student_no;
	}

}//class