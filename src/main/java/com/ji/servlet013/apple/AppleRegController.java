package com.ji.servlet013.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AppleRegController")
public class AppleRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("content", "apple/reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AppleDAO.getAppledao().insertApple(request);	
		AppleDAO.getAppledao().getApples(1, request);;
		
		request.setAttribute("content", "apple/apple.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
