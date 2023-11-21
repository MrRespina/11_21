<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" href="css/web.css">
<script type="text/javascript" src="js/appleJS.js"></script>
<script type="text/javascript" src="js/bananaJS.js"></script>
<script type="text/javascript" src="js/go.js"></script>
</head>
<body class="friutBody">
	<table id="mainTable">
		<tr>
			<td class="titleTd" align="center" colspan="4"><a
				href="HomeController">Title</a></td>
		</tr>

		<tr>
			<td id="siteContent" colspan="4"><jsp:include page="${content }" /></td>
		</tr>
		<tr id="siteMenu" align="center">
			<td class="mainTd" align="center"><a href="AppleController">Apple</a></td>
			<td class="mainTd" align="center"><a href="BananaController">Banana</a></td>
			<td class="mainTd" align="center"><a href="3">Cherry</a></td>
			<td class="mainTd" align="center"><a href="DBCController">DB연결</a></td>
		</tr>
	</table>
</body>
</html>