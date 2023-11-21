<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reg.jsp</title>
<style>
input {
	width: 220px;
	height: 35px;
	font-family: 'n';
	font-size: 35px;
}

textarea {
	width: 220px;
	height: 60px;
	font-size: 30px;
	font-family: 'n'
}

select {
	widht: 150px;
	height: 40px;
	font-family: 'n';
	font-size: 35px;
}
</style>
</head>
<body class="friutBody">
	<h1>Banana에 등록합니다!</h1>
	<form name="bananaForm" action="BananaRegController" method="post"
		onsubmit="return bananaRegCheck();">
		<table id="friutContext" border="1" align="center">

			<tr>
				<td class="friutMainTr">상표</td>
				<td><input name="b_trademark" autocomplete="off"
					autofocus="autofocus" placeholder="상표"></td>
			</tr>
			<tr>
				<td class="friutMainTr">원산지</td>
				<td><input name="b_location" autocomplete="off"
					autofocus="autofocus" placeholder="원산지"></td>
			</tr>
			<tr>
				<td class="friutMainTr">갯수</td>
				<td><input name="b_bundle" autocomplete="off"
					autofocus="autofocus" placeholder="갯수/숫자만입력"></td>
			</tr>
			<tr>
				<td class="friutMainTr">색</td>
				<td><select name="b_color"><option>초록</option>
						<option>노랑</option>
						<option>황금</option></select></td>
			</tr>
			<tr>
				<td class="friutMainTr">맛</td>
				<td><select name="b_flavor"><option>별로</option>
						<option>보통</option>
						<option>달다</option></select></td>
			</tr>
			<tr>
				<td class="friutMainTr">가격</td>
				<td><input name="b_price" autocomplete="off"
					autofocus="autofocus" placeholder="가격/숫자만입력"></td>
			</tr>
			<tr>
				<td class="friutMainTr">설명</td>
				<td><textarea name="b_introduce" maxlength="80"
						autocomplete="off" placeholder="5자 이상"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><button style="width: 288px; height: 50px;">등록</button></td>
			</tr>

		</table>
	</form>
	<button style="width: 288px; height: 50px; margin-top: 20px;"
		onclick="goBackBanana()">돌아가기</button>
</body>
</html>