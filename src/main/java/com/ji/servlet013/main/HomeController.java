package com.ji.servlet013.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ji.servlet013.apple.AppleDAO;
import com.ji.servlet013.banana.BananaDAO;

/*
MVC 패턴
DAO <> Controller <> Jsp(View)
JSP Model 2 의 Controller는 기능별로 새로 만들 것

jsp 틀 만듬 > C에 연결하기
DAO에서 각종 작업 진행 > C에 연결하기

jsp에서 만든 값 DAO에서 사용할 때 : parameter
DAO에서 만든 값 jsp에서 사용할 때 : attribute

db 테이블 연결하려면 JavaBean 짝으로 만들어두기
DB 연결하려면 ojdbc8.jar / context.xml / DBManager.jar

페이지 이동 : form + buttm / A tag / javascript의 location.href

jsp에서 반복문 조건문 표현방식 > jstl.jar

DAO에서 jsp의 parameter 받아올 땐 : request.getParamter
jsp에서 DAO의 attribute 받아올 때 : ${Elements}

jsp에서 jsp:include(표준액션태그)로 구멍을 뚫어놓은 곳은
모든 Controller에서 채워줘야(안채우면 무한루프 에러) 
*/

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HomeController() {

		AppleDAO.getAppledao().countApples();
		BananaDAO.getbananadao().getBananaCount();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("content", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
	}

}
