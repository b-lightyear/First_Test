package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("*.te")
public class AllMapping extends HttpServlet {
	//doGet, doPost - 어떤 요청이 들어오는지에 따라서 로직을 분리해두는 것은 보안상 좋으나 코딩에 불편함이 많다
	
	//Webapp에서 어떤 경로를 내가 폴더로 만들고 Servlet에 요청을 하려고 하면 헷갈림.
	// * 전체를 맵핑 받을 수 있게도 할 수가 있다! Servlet을 Controller(Spring)와 유사한 구조 만들기
	
	//* : 전체 입력받겠다
	//. : 구분자 (ex.djafjioejfa.구분자)
	//고객관리(Customer) *.cu
	//Hr(계정) *.hr
	//Student *.st
	
	RequestDispatcher rd;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("여기 서비스까지 옴");
		System.out.println(req.getMethod());
		
		String uri = req.getRequestURI();
		System.out.println(uri);
		
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		
		//header.te 라는 요청이 들어왔을 경우에만 보내고 싶음
		//그 외에는 Ex02_Failed로
		//if(servletPath.equals("/header.te")) {
		if(req.getServletPath().equals("/header.te")) {
			rd = req.getRequestDispatcher("/Ex02_Response/Ex03_ResHeader.jsp"); //경로이동
		}else if(req.getServletPath().equals("/out.te")) {
			rd = req.getRequestDispatcher("/Ex03_Out/Ex01_Out.jsp");
		}else if(req.getServletPath().equals("/out2.te")) {
			//@Response(응답) 응답을 JSP나 다른 뷰단을 통해서 하는 게 아니라 URL(Controller, Servlet) 자체에서 하고 싶을 때 씀
			//JSP (JSP 파일한테 바로 객체생성해서 공개된 영역)
			//JAVA (직접 변수에 담아서 쓰게끔 만든 영역)
			//@ResponseBody : 어노테이션을 달면 바로 응답을 하게 되어있음(Spring)
			
			PrintWriter out = resp.getWriter();
			//매번 HTML 태그를 쓰면 불편함
			//contentType을 줄 수가 있다(응답하는 스트림이 어떤 형태의 파일인지)
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			//out.println("<html>");
			//Gson 객체 이용해서 Lib(API)를 처리
			//out.println("<script> alert('됨');</script>");
			//out.println("</html>");
			
		}else {
			rd = req.getRequestDispatcher("/Ex02_Response/Ex02.Failed.jsp"); //경로이동
		}//if
		
		//rd.forward(req, resp);
	}
}