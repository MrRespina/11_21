<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>apple.jsp</title>
</head>
<body class="friutBody">
	<table id="friutTable">
		<tr>
			<td class="fruitTitleTd" align="right">${r }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="AppleRegController">등록</a></td>
		</tr>
		<tr>
			<td align="center">
				<!-- DB에 저장된 데이터 나올 곳 -->
				<table id="friutContext" border="1">
					<tr class="dataTr">
						<th class="friutMainTr">지역</th>
						<th class="friutMainTr">가격</th>
						<th class="friutMainTr">맛</th>
						<th class="friutMainTr">색상</th>
						<th class="friutMainTr">소개</th>

					</tr>
					<c:forEach var="apple" items="${apples }">
						<tr class="dataTr" onclick="goAppleDetail(`${apple.a_location }`)">
							<td align="center">${apple.a_location }</td>
							<td align="center"><fmt:formatNumber
									value="${apple.a_price }" type="currency" /></td>
							<td class="dataTr">${apple.a_flavor }</td>
							<td class="dataTr">${apple.a_color }</td>
							<td class="dataTr">${apple.a_introduce }</td>
						</tr>

					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td><c:forEach var="p" begin="1" end="${pageCount }">
					<a href="ApplePageController?p=${p }">[ ${p } ]</a>
				</c:forEach></td>
		</tr>
		<tr>
			<td align="center">검색</td>
		</tr>
	</table>


</body>
</html>