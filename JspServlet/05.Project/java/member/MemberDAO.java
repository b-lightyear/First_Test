package member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	//쿼리문 실행기능을 가진 클래스 : SqlSessionTemplate
	 public static SqlSession sql;
	 
	 static {
		 String resource = "mybatis/config.xml";
		 //Resources.getResourceAsStream(resource);
		 try {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream(resource));
			sql = factory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
	/* CRUD : Create, Read, Update, Delete */
	 
	//로그인하기
	public MemberDTO member_login(String id, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		return sql.selectOne("member.login", map);
	}
	
	//아이디에 해당하는 salt 조회하기
	public String member_salt(String id) {
		return sql.selectOne("member.salt", id);
	}
	
	 //회원가입
	 public int member_join(MemberDTO dto) {
		 return sql.insert("member.join", dto);
	 }
	 
	 //내 정보 보기
	 public MemberDTO member_myinfo(String userid) {
		 return null;
	 }
	 
	 //아이디 중복 확인
	 public int member_id_check(String userid) {
		 return sql.selectOne("member.id_check", userid);
	 }
	 
	 //회원정보 수정
	 public int member_update(MemberDTO dto) {
		 return 0;
	 }
	 
	 //회원 탈퇴
	 public int member_delete(String userid) {
		 return 0;
	 }
	 
	//전체회원정보조회
	public List<MemberDTO> member_list() {
		return sql.selectList("member.list");
	}
	public void member_pw_encrypt(MemberDTO dto) {
		sql.update("member.pw_encrypt", dto);
	}
		
}//class