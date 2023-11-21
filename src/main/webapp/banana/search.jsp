<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="friutBody">
	<table id="friutTable">
		<tr>
			<td align="center">
				<table id="friutContext" border="1">
					<tr class="dataTr">
						<th class="friutMainTr">상표</th>
						<th class="friutMainTr">원산지</th>
						<th class="friutMainTr">과일갯수</th>
						<th class="friutMainTr">색</th>
						<th class="friutMainTr">맛</th>
						<th class="friutMainTr">가격</th>
						<th class="friutMainTr">설명</th>
					</tr>
					<c:forEach var="banana" items="${bananas }">
						<tr class="dataTr" onclick="goBananaDetail(`${banana.b_num }`)">
							<td align="center">${banana.b_trademark }</td>
							<td align="center">${banana.b_location }</td>
							<td align="center">${banana.b_bundle }</td>
							<td align="center">${banana.b_color }</td>
							<td align="center">${banana.b_flavor }</td>
							<td align="center"><fmt:formatNumber
									value="${banana.b_price }" type="currency" /></td>
							<td>${banana.b_introduce }</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>

		<tr>
			<td><button onclick="goBackBanana();">돌아가기</button></td>
		</tr>

	</table>


</body>
</html>