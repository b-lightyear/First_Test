package pack05.ojdbc2;

import java.util.Scanner;

public class UserInfoDAO extends StudentDAO {	
	
	//로그인
	//현재는 StudentDAO를 상속받아서 썼다면, 나중에는 접속객체를 초기화 접속객체 닫기 등등
	//하나의 공통 클래스로 몰아넣기 (재사용이 편하다)
	
	//공통으로 사용되는 로직은 commons, common등 공통이라는 패키지를 별도로 두고,
	//프로젝트 인원들이 같이 사용되도록 유도함 (DB접속, 숫자를 리턴하는 메소드)
	
	//로그인 처리를 위한 메소드 만들기 : loginUser(); ...파라메터가 필요할까?
	//어떤 클래스에서 호출하든 사용가능해야 한다)
	//true, false를 이용해서 true가 나오면 로그인 됨 -> 이것만 정답X
	//-1은 확실히 실패, 그 외에는 성공(jdbc)
	
	//로그인
	public UserInfoDTO loginUser(String id, String pw) {	//파라매터 개수가 적어도 두 개는 되어야 한다. 아이디, 비밀번호 필요
		//SELECT * FROM user_info WHERE user_id = '' AND user_pw = '';
		UserInfoDTO dto = new UserInfoDTO();
		conn = getConnection();
		String sql = "SELECT *  FROM user_info  WHERE user_id = ?  AND user_pw = ?";
		//물음표 개수는 ps.set갯수와 맞춰줘야 한다.
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id); 	//왼쪽을 기준으로 첫번째 물음표를 찾고 그 물음표에 어떤 값을 넣음
			ps.setString(2, pw); 	//?에 자동으로 입력해준다
			
			rs = ps.executeQuery();
			while(rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_pw(rs.getString("user_pw"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		
		return dto;
	}//loginUser()
	
	//회원가입
	public UserInfoDTO joinUser(UserInfoDTO dto) {
		//메인에서 회원정보를 입력받고, 입력받은 결과로 회원가입처리.
		conn = getConnection();
		String sql = "INSERT INTO user_info VALUES (5, ?, ?, ?, ?, sysdate, sysdate, 'N')";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getUser_pw());
			ps.setString(3, dto.getFirst_name());
			ps.setString(4, dto.getLast_name());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		
		return dto;
	}//joinUser
	
	//스캐너 메세지
	
	//사용자에게 어떤 메세지를 보여줌과 동시에 스캐너로 값을 입력받는 메소드
	public String rtnStrMsg(Scanner scn, String msg) {
		System.out.println(msg);
		return scn.nextLine();
	}//stnStrMsg
	
		
	//회원 정보 수정 (USER_ID, USER_PW, FIRST_NAME, LAST_NAME)
	public UserInfoDTO infoUpdate(UserInfoDTO dto) {
		conn = getConnection();
		String sql = "UPDATE user_info  SET user_pw = ?, last_name = ?, first_name = ?, UPDATE_YMD = sysdate  WHERE user_id = ?";
		//sql문구 테스트 후 ?로 바꾸고 파라메터로 넘김
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_pw());
			ps.setString(2, dto.getLast_name());
			ps.setString(3, dto.getFirst_name());
			ps.setString(4, dto.getUser_id());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}//try
		return dto;
	}//infoUpdate()
	
	//회원정보보기
	public void info(UserInfoDTO dto) {
		System.out.println(dto.getUser_id());
		System.out.println(dto.getUser_pw());
		System.out.println(dto.getFirst_name());
		System.out.println(dto.getLast_name());
	}//info()
	
	//회원탈퇴
	public boolean quit(UserInfoDTO dto) {
		conn = getConnection();
		String sql = "DELETE FROM user_info WHERE student_no = 5 AND user_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;
	}//quit()
		
}//class