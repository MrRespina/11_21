package com.ji.servlet013.banana;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ji.servlet013.apple.AppleDAO;

@WebServlet("/BananaPageController")
public class BananaPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int p = Integer.parseInt(request.getParameter("p"));
		BananaDAO.getbananadao().getBananaPage(p, request);
		request.setAttribute("content", "banana/banana.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
