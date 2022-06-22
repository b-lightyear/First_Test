package pack05.ojdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO {
	//JDBC를 통해서 연결과 연결해제 등등의 기능이 필요하다면 가지고 와야함.
	//API의 경우 내가 직접 코딩하는 게 적음(이미 만들어진 기능을 호출해서 사용)
	//따라서 어떤 게 필요한지를 외우고 빠지면 복붙해도 노상관, 규칙은 외우기(연결, 전송, 결과)
		
	//학생 정보를 전체 조회할 수 있는 메소드 : getStudentList();
	//전체정보를 어떤 클래스에서 호출하든 사용가능해야 한다)
	
	public Connection conn;
	public PreparedStatement ps;
	public ResultSet rs;
	
	//오라클 연결
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		
		return conn;
	}//getConnection()
	
	//DB 닫기
	public void dbClose() {
		try {
			if(rs != null) {
				rs.close();
			}//if
				
			if(ps != null) {
				ps.cancel();
			}//if
		
			if(conn != null) {
				conn.close();
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try
	}//dbClose()
	
	//전체학생조회
	public ArrayList<StudentDTO> getStudentList() {
		//DTO(변수) : 한 가지 값만 가진다.
		//Connection 객체 등 이용해서 DB에서 정보를 가지고옴. 그 결과를 리턴
		conn = getConnection();
		ArrayList<StudentDTO> dto = new ArrayList<StudentDTO>();
		String sql = "SELECT * FROM student";
	
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				//System.out.println(rs.getInt("student_no") + rs.getString("student_name"));
				
				dto.add(new StudentDTO(rs.getInt("student_no"), rs.getString("student_name")));
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		return dto;	//리턴값... 제대로 쓰기
	}//getStudentList()
	
	// viewList라는 메소드는 조회된 결과를 전체 콘솔창에 출력하는 메소드
	public void viewList(ArrayList<StudentDTO> dto) {
		
		if(dto == null || dto.size() == 0) {
			System.out.println("보여줄 목록이 없습니다.");
			return ;
		}
		
		for (int i = 0; i < dto.size(); i++) {
			System.out.println(dto.get(i).getStudent_no() + "." + dto.get(i).getStudent_name());
		}//for
	}//viewList()
	
}//class


/*메소드~~
* 내가 알고 있는 어떤 것이든 메소드의 리턴타입이 될 수 있으니 한계를 두고 생각을 닫지 말자!!
1. 접근제한자(public, protected, default(생략), private)
2. 멤버의구분 (static 유무) : 인스턴스화 해야 사용, 안 해도 사용 가능
3. 리턴타입 (void의 유무) : 리턴을 하는지 안 하는지 구분
	- void가 있을 때 return은 더 이상 진행을 하지 않고 여기서 끝내겠다는 의미.
4. 메소드이름 (소문자로 시작해서 기능을 구별할 수 있는 단어)
5. 파라메터부 (메소드가 실행될 때 필요한 매개변수(파라메터)가 있다면 넘겨주는 부분
*/