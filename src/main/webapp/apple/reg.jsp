<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reg.jsp</title>
</head>
<body class="friutBody">
	<h1>Apple에 등록합니다!</h1>
	<form name="appleForm" action="AppleRegController" method="post" onsubmit="return appleRegCheck();">
		<table id = "friutContext" border="1" align="center">
			<tr>
				<td class="friutMainTr">지역</td><td><input name="a_location" style="width:220px;height:35px;font-family: 'n';font-size: 35px;" autocomplete="off" autofocus="autofocus" placeholder="지역"></td>
			</tr>
			<tr>
				<td class="friutMainTr">색</td><td><select name="a_color" style="height:40px;font-family: 'n';font-size: 35px;"><option>빨강</option><option>주황</option><option>초록</option><option>황금</option></select></td>
			</tr>
			<tr>
				<td class="friutMainTr">맛</td><td><select name="a_flavor" style="height:40px;font-family: 'n';font-size: 35px;"><option>달다</option><option>보통</option><option>별로</option></select></td>
			</tr>
			<tr>
				<td class="friutMainTr">가격</td><td><input name="a_price" style="width:220px;height:35px;font-family: 'n';font-size: 35px;" autocomplete="off" placeholder="숫자만입력"></td>
			</tr>
			<tr>
				<td class="friutMainTr">설명</td><td><textarea name="a_introduce" style="width:220px;height:50px;font-size: 35px;font-family:'n'" maxlength="80" autocomplete="off" placeholder="5자 이상"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><button style="width:270px;height:50px;">등록</button></td>
			</tr>
		</table>
	
	</form>
	
</body>
</html>