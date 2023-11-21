package com.ji.servlet013.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleDetailController")
public class AppleDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(AppleDAO.getAppledao().getAppleDetail(request)) {
			
			request.setAttribute("content", "apple/detail.jsp");
			
		} else {	// false 일 때 게시판의 1페이지 나오게.
			
			AppleDAO.getAppledao().getApples(1, request);
			request.setAttribute("content", "apple/apple.jsp");
			
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(AppleDAO.getAppledao().update(request)) {
			AppleDAO.getAppledao().getAppleDetail(request);
			AppleDAO.getAppledao().getApples(1, request);
			request.setAttribute("content", "apple/apple.jsp");
		} else {
			AppleDAO.getAppledao().getApples(1, request);
			request.setAttribute("content", "apple/apple.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
