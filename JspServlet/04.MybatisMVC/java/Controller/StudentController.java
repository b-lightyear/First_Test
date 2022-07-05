package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.StudentDAO;
import student.StudentDTO;

//*aa
//<a href="test.aa"</a>
//전체적으로 연습해보기.......


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
			
			//ArrayList<StudentDTO> list = dao.getManualList();
			//req.setAttribute("list", list);
			
			// JSP 에 보내서 출력 해보기 
			ArrayList<StudentDTO> list = dao.info();
			req.setAttribute("list", list);
			rd = req.getRequestDispatcher("student/list.jsp");
			
		}else if(req.getServletPath().equals("/test.st")) {
			dao.selectOne();
			System.out.println(dao.info().size());
			
		}else if(req.getServletPath().equals("/detail.st")) {
			//DTO데이터베이스 칼럼이랑 맞춰서 만들어놓은 클래스(필드 == 데이터베이스 칼럼)
			StudentDTO dto = dao.getStudentInfo(req.getParameter("student_no"), req.getParameter("user_id"));
			
			//한 명의 상세 정보 조회()
			System.out.println(req.getParameter("student_no"));
			System.out.println(req.getParameter("user_id"));
			
			//ArrayList인지 다른건지
			//DAO 메소드 만들기 getStudentInfo(), 리턴타입 자유롭게
			//detail.jsp
			req.setAttribute("dto", dto);
			rd = req.getRequestDispatcher("student/detail.jsp");

		}else if(req.getServletPath().equals("/update.st")) { //정보 수정
			StudentDTO dto = dao.getStudentInfo(req.getParameter("student_no"), req.getParameter("user_id"));
			req.setAttribute("dto", dto);
			rd = req.getRequestDispatcher("student/update.jsp");
			
		}else if(req.getServletPath().equals("/modify.st")) { //정보 수정...?
			
			StudentDTO dto = new StudentDTO(null, req.getParameter("user_id"), null, req.getParameter("first_name"), req.getParameter("last_name"), Integer.parseInt(req.getParameter("student_no")));
			int result = dao.modifyinfo(dto);
			
			//어떤 데이터를 넘길 필요가 없음 (페이지 새로고침만 하면 된다)
			resp.sendRedirect("list.st");
			return;	//rd = req.getRequestDispatcher("student/list.jsp");
					//페이지를 바로 요청해버리면 list가 없기 때문에 에러 발생
			
		}else if(req.getServletPath().equals("/delete.st")) { //정보삭제
			//DAO를 통해서 삭제처리
			StudentDTO dto = new StudentDTO(null, req.getParameter("user_id"), null, req.getParameter("first_name"), req.getParameter("last_name"), Integer.parseInt(req.getParameter("student_no")));
			StudentDTO delete = dao.deleteInfo(dto);
			resp.sendRedirect("list.st");
			return;
			
		}
		
		//if
		
		dao.dbClose(); //DB 꼭 닫기~!!
		rd.forward(req, resp);
		//컨트롤러에서 jsp로 넘길 때에는 attribute, jsp에서 컨트롤러는 forward
		
	}//Servlet
}//class