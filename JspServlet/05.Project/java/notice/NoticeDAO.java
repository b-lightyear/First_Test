package notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.commonDAO;

public class NoticeDAO {
	//쿼리문 실행 기능을 가진 클래스(Mybatis)
	//CRUD : Create, Read, Update, Delete
	
	private SqlSession sql = commonDAO.sql;
	
	//공지글 답글 저장
	public void notice_reply_insert(NoticeDTO dto) {
		sql.insert("notice.reply_insert", dto);
		
	}
	
	//공지글 신규 저장
	public void notice_insert(NoticeDTO dto) {
		sql.insert("notice.insert", dto);
	}//insert
	
	//공지글 목록 조회 : 페이징처리O
	public NoticePageDTO notice_page(NoticePageDTO page) {
		//총 공지글 목록수를 조회
		page.setTotalList(sql.selectOne("notice.total", page));
		page.setList(sql.selectList("notice.list", page));
		
		return page;
	}
	
	//공지글 목록 조회 : 페이징처리X
	public List<NoticeDTO> notice_list() {
		return sql.selectList("notice.list");
	}//insert
	
	//공지글 상세조회
	public NoticeDTO notice_detail(int id) {
		return sql.selectOne("notice.detail", id);
	}//detail
	
	//공지글 조회수 증가처리
	public void notice_read(int id) {
		sql.update("notice.read", id);
	}//read
	
	//공지글 정보 변경
	public void notice_update(NoticeDTO dto) {
		sql.update("notice.update", dto);
	}
	
	//공지글 삭제
	public void notice_delete(int id) {

	}

	
	
}//class