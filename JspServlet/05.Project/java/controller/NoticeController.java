package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeList;

@WebServlet("*.no")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private RequestDispatcher rd;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list.no : 공지글 목록 요청
		//detail.no : 공지글 상세화면 요청
		//new.no : 신규 공지글 쓰기 화면 요청
		
		String uri = request.getServletPath();
		String view = "";
		boolean redirect = false;
		
		//응답할 화면 연결(공지글 목록 화면)
		if(uri.equals("/list.no")) {
			//DB에서 공지글 목록을 조회해와야 목룍화면에 출력할 수 있도록 할 수 있다.
			//request에 데이터를 담는다 => 비즈니스 로직
			new NoticeList().execute(request, response);
			
			//rd = request.getRequestDispatcher("notice/list.jsp");
			view = "/notice/list.jsp";
			
		} else if(uri.equals("/new.no")) {
			//신규 공지글쓰기 화면 요청
			
			//응답화면 연결 - 공지글쓰기 화면
			view="/notice/new.jsp";
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