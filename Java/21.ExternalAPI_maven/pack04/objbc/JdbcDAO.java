package pack04.objbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JdbcDAO {
	//데이터베이스에서 데이터를 가지고 오는 모든 처리를 담당하는 클래스(객체)
	//가지고 온 데이터를 묶어서 저장하기 위한 클래스 (DTO)
		
	//1. 연결개체 (Connection) : 연결을 만드는 객체
	//2. 전송객체 (...StateMent) : 연결로를 통해서 전송을 하는 객체
	//3. 결과객체 (ResultSet) : 전송객체가 어떤 쿼리를 실행하고나서 결과를 가지고 오면 담기위한 객체 (ex. SQL에서는 질의결과)
	
	private Connection conn;	//연결객체
	private PreparedStatement ps;	//전송객체
	private ResultSet rs;	//결과객체
		
		
	//연결객체가 필요할 때마다 호출해서 연결객체를 리턴받는 메소드
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn Error!!!!");
		}
		return conn;
	}//getConnection()
		
		
	//getConn 메소드를 활용해서  221.로 시작하는 db에서 dual 테이블 이용 1을 조회하기
	public boolean getInt() {
		conn = getConnection();
		String sql = "select 1 num from dual";
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("num"));
			}//while
		} catch (Exception e) {
			System.out.println("getInt");
			e.printStackTrace();
		}finally {
			dbClose();
		}//try
			
		return false;
	}//getInt()
		
		
	//통신 닫는 메소드 (순서 생각해보기)
	//열 때 통신연결로를 열고 전송객체를 보내고 결과 객체 받음
	//통신을 열 때랑 역순으로 닫아주면 된다.
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
		
		
	//학생 정보를 조회해서 내 정보만 따로 가지고 오는 메소드를 만들기.
	//DTO 만드는 이유 :  메소드는 하나의 데이터타입만 return 가능함
	//Database에는 여러 데이터타입으로 데이터가 존재함(NUMBER,VARCHAR2,Date....)이런것들을
	//한번에 묶어서 처리하기 위한 객체 (DTO) 
	public JdbcDTO getInfo() {
		JdbcDTO dto = null;
		conn = getConnection();
		String sql = "select * from student where student_no = 5";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("STUDENT_NO"));	//오라클의 number는 int
				System.out.println(rs.getString("STUDENT_NAME"));	//오라클의 varchar2는 String
				
				dto = new JdbcDTO(rs.getInt("STUDENT_NO"), rs.getString("STUDENT_NAME"));
			}//while, 이 결과를 JdbcDTO에 담고 return하게 만들기
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
			
		return dto ;	//null이 아니라 내가 조회한 데이터를 어디서든 사용할 수 있게 리턴해주는 메소드
	}//getInfo()
	
	//메소드접근제한자  리턴타입  메소드이름
	//리턴타입O ▶ 리턴해줘야함
	//메소드나 멤버(필드) 리턴타입등등에 제한X
	
	
	
	//학생 정보를 전체 조회해서 ArrayList 타입을 리턴하는 메소드 생성
	//이름 형식 마음대로 하기
	public ArrayList<JdbcDTO> getAll() {
		
		ArrayList<JdbcDTO> dto = new ArrayList<JdbcDTO>();
		
		conn = getConnection();
		String sql = "select * from student";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("STUDENT_NO"));
				System.out.println(rs.getString("STUDENT_NAME"));
				
				dto.add(new JdbcDTO(rs.getInt("STUDENT_NO"), rs.getString("STUDENT_NAME")));
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		return dto;
	}//getAll()	
	
	
	//JAVA에서 JDBC를 이용해서 INSERT QUERY를 ORACLE에 전송하고
	// 오라클에서는 전송받은 쿼리를 실행하고 그 결과를 다시 자바쪽에 보내줌
	//연결 <-> 전송 -> 결과
	public int insertUser() {
		conn = getConnection(); //커넥션 객체 초기화(연결)
		String sql = "INSERT INTO user_info VALUES (5, 'SHS', 'hshs', 'HANSOL', 'SHIN', '2022-06-20', '2022-06-20')"; 	//실행할 SQL문
		try {
			ps = conn.prepareStatement(sql);	//전송객체 초기화
			//SELECT 했을 때에는 executeQuery라는 메소드를 이용했지만,
			//Insert,Update,Delete를 할 때에는 데이터의 수정이 이루어졌는지의 결과만 필요하기 때문에
			//executeUpdate()라는 메소드를 사용 (성공 1 / 실패 0, -1)
			return ps.executeUpdate();	//AUTO COMMIT(자동으로 커밋된다)
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		//무결정 제약조건 오류 ▶ 데이터 값이 같아서 데이터를 추가할 수 없다. 수정 후 추가하기.
		return 0;
	}//insertUser()
	
	
	//updatdUser 메소드를 혼자서 만들고 수정되는지 확인하기(auto Commit)
	public int updateUser() {
		conn = getConnection();
		String sql = "UPDATE user_info  SET user_pw = '000000'  WHERE student_no = 5";
		try {
			ps = conn.prepareStatement(sql);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		return 0;
	}//updateUser()
	
	
	//회원정보 삭제
	public int deleteUser() {
		conn = getConnection();
		String sql = "DELETE FROM user_info WHERE student_no = 5 AND user_id = 'SHS'" ;
		
		try {
			ps = conn.prepareStatement(sql);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		
		return 0;
	}//deleteUser()
	
	
}//class