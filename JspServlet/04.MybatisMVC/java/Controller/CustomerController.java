package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import customer.CustomerDTO;


@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	RequestDispatcher rd;
	CustomerDAO dao = new CustomerDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rd = req.getRequestDispatcher("error/404.jsp");
		
		if(req.getServletPath().equals("/list.cu")) {
			req.setAttribute("list", dao.getList());
			rd = req.getRequestDispatcher("customer/listjstl.jsp");
			//dao.test();
			
		} else if(req.getServletPath().equals("/insert.cu")) {
			/*
			 * System.out.println(req.getParameter("name"));
			 * System.out.println(req.getParameter("gender"));
			 * System.out.println(req.getParameter("email"));
			 * System.out.println(req.getParameter("phone"));
			 */
			
			CustomerDTO dto = new CustomerDTO();
			dto.setName(req.getParameter("name"));
			dto.setPhone(req.getParameter("phone"));
			dto.setEmail(req.getParameter("email"));
			dto.setGender(req.getParameter("gender"));
			
			int result = dao.insert(dto);
			return;

		} else if(req.getServletPath().equals("/update.cu")) {
			CustomerDTO dto = new CustomerDTO();
			dto.setName(req.getParameter("name"));
			dto.setPhone(req.getParameter("phone"));
			dto.setEmail(req.getParameter("email"));
			dto.setGender(req.getParameter("gender"));
			dto.setId(Integer.parseInt(req.getParameter("id")));
			
			int result = dao.update(dto);
			PrintWriter out = resp.getWriter();	//응답을 위한 객체
			out.println(result);
			
			return;
		}
		rd.forward(req, resp);
	}
}