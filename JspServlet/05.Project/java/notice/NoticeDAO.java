package notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.commonDAO;

public class NoticeDAO {
	//쿼리문 실행 기능을 가진 클래스(Mybatis)
	//CRUD : Create, Read, Update, Delete
	
	private SqlSession sql = commonDAO.sql;
	
	//공지글 신규 저장
	public void notice_insert(NoticeDTO dto) {
		
	}
	
	//공지글 목록 조회
	public List<NoticeDTO> notice_list() {
		return sql.selectList("notice.list");
	}
	
	//공지글 상세조회
	public NoticeDTO notice_detail(int id) {
		return null;
	}
	
	//공지글 조회수 증가처리
	public void notice_read(int id) {
		
	}
	
	//공지글 정보 변경
	public void notice_update(NoticeDTO dto) {
		
	}
	
	//공지글 삭제
	public void notice_delete(int id) {
		
	}
	
}//class