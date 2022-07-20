package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import department.DepartmentDAO;
import employees.EmployeeDAO;

@WebServlet({"/list.emp", "/list.dept"})
public class HrController extends HttpServlet {
	RequestDispatcher rd;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("연결");
		
		if(req.getServletPath().equals("/list.emp")) {
			System.out.println("list.emp 연결");
			
			EmployeeDAO dao = new EmployeeDAO();
			req.setAttribute("list", dao.getlist());
			rd = req.getRequestDispatcher("list/empList.jsp");
			
		} else if(req.getServletPath().equals("/list.dept")) {
			System.out.println("list.dept 연결");
			
			DepartmentDAO dao =new DepartmentDAO();
			req.setAttribute("list", dao.list());
			rd = req.getRequestDispatcher("list/deptList.jsp");
		}
		rd.forward(req, resp);
	}
	

}
