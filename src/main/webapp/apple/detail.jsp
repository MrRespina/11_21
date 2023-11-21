<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="friutBody">
	<h1>상세정보/수정</h1>
	<form action="AppleDetailController" method="post">
		<table id="friutContext" border="1" align="center">
			<tr>
				<td class="friutMainTr">지역</td>
				<td><input readonly="readonly" name="a_location"
					value="${apple.a_location }"></td>
			</tr>
			<tr>
				<td class="friutMainTr">색</td>
				<td><input autocomplete="off" name="a_color"
					value="${apple.a_color }"></td>
			</tr>
			<tr>
				<td class="friutMainTr">맛</td>
				<td><input autocomplete="off" name="a_flavor"
					value="${apple.a_flavor }"></td>
			</tr>
			<tr>
				<td class="friutMainTr">가격</td>
				<td><input autocomplete="off" name="a_price"
					value="${apple.a_price }"></td>
			</tr>
			<tr>
				<td class="friutMainTr">설명</td>
				<td><textarea autocomplete="off" style="width:220px;height:60;" maxlength="80" name="a_introduce">${apple.a_introduce }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><button style="width: 270px; height: 50px;">수정</button></td>
			</tr>
		</table>

	</form>
		<table align="center">
			<tr>
				<td><button onclick="goBackApple()">돌아가기</button>
				</td>
				<td><button onclick="deleteApple('${apple.a_location}')">삭제!</button>
				</td>
			</tr>
		</table>
		

</body>
</html>