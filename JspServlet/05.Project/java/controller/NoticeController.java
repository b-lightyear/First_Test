package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import member.MemberDAO;
import member.MemberDTO;
import notice.NoticeDetail;
import notice.NoticeDownload;
import notice.NoticeInsert;
import notice.NoticeList;
import notice.NoticeRead;
import notice.NoticeReplyInsert;
import notice.NoticeUpdate;

@WebServlet("*.no") @MultipartConfig
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list.no : 공지글 목록 요청
		//detail.no : 공지글 상세화면 요청
		//new.no : 신규 공지글 쓰기 화면 요청
		
		String uri = request.getServletPath();
		String view = "";
		boolean redirect = false;
		CommonUtil util = new CommonUtil();
		
		
		//응답할 화면 연결(공지글 목록 화면)
		if(uri.equals("/list.no")) {
			//임의로 로그인 후 나중에 처리
			String id = "admin2";
			MemberDAO dao = new MemberDAO();
			String salt = dao.member_salt(id);
			String salt_pw = util.getEncrypt("4321", salt);
			MemberDTO member = dao.member_login(id, salt_pw);
			request.getSession().setAttribute("userInfo", member);
			
			//DB에서 공지글 목록을 조회해와야 목룍화면에 출력할 수 있도록 할 수 있다.
			//request에 데이터를 담는다 => 비즈니스 로직
			new NoticeList().execute(request, response);
			
			//rd = request.getRequestDispatcher("notice/list.jsp");
			view = "/notice/list.jsp";
		
			
		//신규 공지글 저장처리 요청
		} else if(uri.equals("/insert.no")) {
			//화면에서 입력한 정보를 DB에 신규 저장(비즈니스 로직(커맨드처리))한 후 응답화면 연결 (목록화면으로)
			view = "list.no";
			redirect = true;
			
			new NoticeInsert().execute(request, response);
			
			
		//공지글 상세화면 요청 : 화면에서 선택한 공지글 정보를 DB에서 조회
		} else if(uri.equals("/detail.no")) {
			//조회수 증가처리
			new NoticeRead().execute(request, response);
			//공지글 상세화면 요청
			//화면에서 선택한 공지글 정보를 DB에서 조회해와
			//화면에 출력할 수 있도록 request 에 데이터를 담는다: 비지니스로직
			new NoticeDetail().execute(request, response);
			//응답화면연결 - 상세화면 
			view = "/notice/detail.jsp";

			
		//해당 글에 대한 첨부파일 정보를 DB에서 조회 후, 클라이언트에 다운로드 처리 (비즈니스 로직)
		} else if(uri.equals("/download.no")) {
			new NoticeDownload().execute(request, response);
			return;
			
			
		//공지글 수정 : 해당 글의 정보를 DB에서 조회 후, 수정화면에 출력할 수 있도록 request에 데이터 담기 (비즈니스 로직)
		} else if(uri.equals("/modify.no")) {
			new NoticeDetail().execute(request, response);
			view = "/notice/modify.jsp";
		
			
		//공지글 수정 후 저장 처리 : 화면에서 입력한 정보를 DB에 변경저장한 후, 상세화면으로 연결
		} else if(uri.equals("/update.no")) {
			new NoticeUpdate().execute(request, response);
			view = "detail.no?id="+request.getParameter("id") ;
			redirect = true;
					
			
		//답글쓰기 : 원글의 정보를 DB에서 조회한 후, 답글쓰기 화면에 출력할 수 있도록 request에 담는다 (비즈니스로직)
		} else if(uri.equals("/reply.no")) {
			//원글의 정보를 DB에서 조회
			new NoticeDetail().execute(request, response);
			
			//응답화면 연결
			view = "/notice/reply.jsp";
			
			
		//답글 저장 : DB 저장 후 목록 화면 요청
		} else if(uri.equals("/reply_insert.no")) {
			//화면에서 입력한 답글 정보를 DB에 저장
			new NoticeReplyInsert().execute(request, response);
			
			//응답화면 연결
			view = "list.no";
			redirect = true;
			
			
		//신규 공지글쓰기 화면 요청
		} else if(uri.equals("/new.no")) {
			view="/notice/new.jsp"; //응답 화면 연결
		}
		
		
		//rd.forward(request, response);
		if( redirect ) {
			response.sendRedirect(view);
		}else 
			request.getRequestDispatcher(view).forward(request, response);
		
		/* 화면 연결 형태 방식 (2가지)
		 - forward : 기본형태
		 - redirect
		 */
	}

}//class