package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dmdmd
 */
@WebServlet("/Ex01_Response")
public class Dmdmd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지 전환 RequestDispatcher 
		// JSP Container 에서 받아서 사용하게끔 만들어놓음.(서버 스타트시 알아서 객체를 내장객체화해둠)
		//RequestDispatcher rd = request.getRequestDispatcher("내가 가고싶은 jsp페이지");
		RequestDispatcher rd = request.getRequestDispatcher("Ex02_Response/Ex01_Redirect.jsp");
		
		request.setAttribute("id", "admin");
		request.setAttribute("pw", "admin1234"); // ↑ 지정해놓은 JSP까지 전송이 됨
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
