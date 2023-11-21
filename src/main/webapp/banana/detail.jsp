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
	<form action="BananaDetailController" method="post">
		<table id="friutContext" border="1" align="center">
		<tr>
				<td class="friutMainTr">등록번호</td>
				<td><input name="b_num" readonly="readonly" value="${banana.b_num }"></td>
			</tr>
			<tr>
				<td class="friutMainTr">상표</td>
				<td><input name="b_trademark" value="${banana.b_trademark }"></td>
			</tr>
			<tr>
				<td class="friutMainTr">지역</td>
				<td><input name="b_location" value="${banana.b_location }"></td>
			</tr>
			<tr>
				<td class="friutMainTr">갯수</td>
				<td><input autocomplete="off" name="b_bundle"
					value="${banana.b_bundle }"></td>
			</tr>
			<tr>
				<td class="friutMainTr">색</td>
				<td><input autocomplete="off" name="b_color"
					value="${banana.b_color }"></td>
			</tr>
			<tr>
				<td class="friutMainTr">맛</td>
				<td><input autocomplete="off" name="b_flavor"
					value="${banana.b_flavor }"></td>
			</tr>
			<tr>
				<td class="friutMainTr">가격</td>
				<td><input autocomplete="off" name="b_price"
					value="${banana.b_price }"></td>
			</tr>
			<tr>
				<td class="friutMainTr">설명</td>
				<td><textarea autocomplete="off"
						style="width: 220px; height: 60;" maxlength="80"
						name="b_introduce">${banana.b_introduce }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><button style="width: 305px; height: 50px;">수정</button></td>
			</tr>
		</table>

	</form>
	<table align="center">
		<tr>
			<td><button onclick="goBackBanana()">돌아가기</button></td>
			<td><button onclick="deleteBanana('${banana.b_num}')">삭제!</button>
			</td>
		</tr>
	</table>


</body>
</html>