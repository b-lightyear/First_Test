package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.StudentDAO;
import student.StudentDTO;

@WebServlet("*.st")	//전체를 받는 url패턴(맵핑)을 사용할 때는 '/' 빼야한다. 안 그러면 오류남!!!
public class StudentController extends HttpServlet {
	RequestDispatcher rd;
	
	StudentDAO dao = new StudentDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rd = req.getRequestDispatcher("error/404.jsp");	//나중에 추가 예정(22.06.30 SHS)
		if(req.getServletPath().equals("/list.st")) {
			//추후 DB에서 가져온 정보를 이용 => 지금은 ArrayList를 수동으로 만들기
			//ArrayList<StudentDTO> list = dao.getManualList();
			//for (int i = 0; i < list.size(); i++) {
			//	System.out.println(list.get(i).getSTUDENT_NO());
			//}//for
			
			//Object List = dao.getManualList();
			//JSP에 보내서 출력해보기.........
			//req.setAttribute("list", list);
			
			
			ArrayList<StudentDTO> list = dao.getManualList();
			req.setAttribute("list", list);
			// JSP 에 보내서 출력 해보기 
			rd = req.getRequestDispatcher("student/list.jsp");
			
		}//if
		rd.forward(req, resp);
	}
}//class