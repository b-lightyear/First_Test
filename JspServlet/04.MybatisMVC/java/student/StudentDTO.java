package student;

public class StudentDTO {
	private String STUDENT_NAME, USER_ID, USER_PW, FIRST_NAME, LAST_NAME;
	private int STUDENT_NO;
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(String sTUDENT_NAME, String uSER_ID, String uSER_PW, String fIRST_NAME, String lAST_NAME,
			int sTUDENT_NO) {
		super();
		STUDENT_NAME = sTUDENT_NAME;
		USER_ID = uSER_ID;
		USER_PW = uSER_PW;
		FIRST_NAME = fIRST_NAME;
		LAST_NAME = lAST_NAME;

		STUDENT_NO = sTUDENT_NO;
	}

	public String getSTUDENT_NAME() {
		return STUDENT_NAME;
	}

	public void setSTUDENT_NAME(String sTUDENT_NAME) {
		STUDENT_NAME = sTUDENT_NAME;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_PW() {
		return USER_PW;
	}

	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}


	public int getSTUDENT_NO() {
		return STUDENT_NO;
	}

	public void setSTUDENT_NO(int sTUDENT_NO) {
		STUDENT_NO = sTUDENT_NO;
	}

	
	
	
	
}//class