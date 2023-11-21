<%@page import="com.ji.servlet013.dbmanager.JiDBManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dbc.jsp</title>
</head>
<body>
	dbc.jsp 입니다?
	<%
String result = "실패";
	Connection conn = null;
try {

	//1.
	//Class.forName("oracle.jdbc.driver.OracleDriver");
	//String addr = "jdbc:oracle:thin:@localhost:1521:xe";
	//conn = DriverManager.getConnection(addr, "respina", "sdj7524");
	conn = JiDBManager.connect("jiPool");	// context.xml의 name
	result = "성공";

} catch (Exception e) {
	e.printStackTrace();
}
%>
	<h1><%=result%></h1>
</body>
</html>