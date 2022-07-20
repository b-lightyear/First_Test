package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import customer.CustomerDTO;


@WebServlet("*.cu")
public class CusController extends HttpServlet {
	//고객 정보 조회해보기 (list.cu)
	//1. list.cu가 url로 요청이 됐을 때 연결이 되는지 크롬으로 확인
	//2. list.cu를 요청받는 servlet(controller) 만들기
	//3. list.jsp(customer 폴더 추가)로 연결하기(forward)
	//4. DAO를 구성해서 데이터 조회하기
	//5. 조회된 데이터를 forward시 list.jsp로 보내주기
	//6. 위에서 조회된 데이터를 jstl 이용해서 화면에 보여주기
	
	RequestDispatcher rd;
	CustomerDAO dao = new CustomerDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getServletPath().equals("/list.cu")) {
			//System.out.println(dao.list().size()); //사이즈 나오는지 체크
			//System.out.println("연결 완료");
			req.setAttribute("list", dao.list());
			rd = req.getRequestDispatcher("customer/list.jsp");
		
		} if(req.getServletPath().equals("/delete.cu")) {
			//CustomerDTO dto = new CustomerDTO();
			//dto.setId(Integer.parseInt(req.getParameter("id")));
			//int result = dao.delete(dto);
			
			dao.delete(req.getParameter("id"));
			System.out.println(req.getContextPath());
			resp.sendRedirect(req.getContextPath() + "/list.cu");
			return;
		}
		
		rd.forward(req, resp);
	}
}//class