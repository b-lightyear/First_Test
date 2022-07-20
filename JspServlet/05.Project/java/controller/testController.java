package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.commonDAO;


@WebServlet("*.pj")
public class testController extends HttpServlet {
	//RequestDispatcher rd;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("여기~~");
		//rd = req.getRequestDispatcher("test/test.jsp");

		commonDAO dao = new commonDAO();
		dao.test();
		//System.out.println(result);
		//rd.forward(req, resp);
	}

}
