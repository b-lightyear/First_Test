package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex01_Request")
public class Ex01_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Ex01_Request() {
        super();
    }  
	
    
    //JSP 컨테이너(WAS + JSP 기능을 모아놓은 상자)
    //요청(크롬) => JSP => JAVA => Class => Execute => 결과를 보여줌
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("========== 성공! ==========");
		//JSP에서 Form태그를 통해서 *요청한* 파라매터를 받아보기
		//Form 태그 안에 있는 위젯의 name 속성을 그대로 적어준다.
		System.out.println(req.getParameter("name"));	//Json(String Key, value)[] {}
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pw"));
		
		//입력한 아이디와 비밀번호를 통해서 회원가입처리(JDBC) 로그인처리(JDBC)
		
		System.out.println(req.getRemoteAddr());
		System.out.println(req.getRemoteHost());
		System.out.println(req.getContextPath());
		
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========== 성공! ==========");
		doGet(request, response);
	}

}
