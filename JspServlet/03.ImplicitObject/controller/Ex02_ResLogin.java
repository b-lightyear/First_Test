package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex02_ResLogin")
public class Ex02_ResLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex02_ResLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Ex02_Response/Ex02_ResLogin.jsp");
		rd.forward(request, response);
	}

	
}//class