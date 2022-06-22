package pack05.ojdbc2;

public class StudentDTO {
	private int student_no;
	private String student_name;
	
	//생성자 메소드 만드는 이유 : get, set이용해서도 필드에 값을 세팅할 수 있지만(private)
	//객체를 생성하자마자 필드에 바로 값을 주는 게 편할 때 사용한다.
	//필드에 비어있는 값이 없게 생설해야 하는 경우에 사용한다.
	public StudentDTO() {
	}

	public StudentDTO(int student_no, String student_name) {
		super();
		this.student_no = student_no;
		this.student_name = student_name;
	}

	public int getStudent_no() {
		return student_no;
	}

	public void setStudent_no(int student_no) {
		this.student_no = student_no;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
	
}//class