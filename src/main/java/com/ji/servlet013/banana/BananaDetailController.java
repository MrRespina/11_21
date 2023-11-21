package com.ji.servlet013.banana;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ji.servlet013.apple.AppleDAO;

@WebServlet("/BananaDetailController")
public class BananaDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (BananaDAO.getbananadao().getBananaDetail(request)) {

			request.setAttribute("content", "banana/detail.jsp");

		} else {

			BananaDAO.getbananadao().getBananaPage(1, request);
			request.setAttribute("content", "banana/banana.jsp");

		}

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(BananaDAO.getbananadao().update(request)) {			
			BananaDAO.getbananadao().getBananaDetail(request);
			BananaDAO.getbananadao().getBananaPage(1, request);
			request.setAttribute("content", "banana/banana.jsp");			
		}else {		
			BananaDAO.getbananadao().getBananaPage(1, request);
			request.setAttribute("content", "banana/banana.jsp");		
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);		
		
	}

}
