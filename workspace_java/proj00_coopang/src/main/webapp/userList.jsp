<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="user.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 관리</h1>
	전체선택
	<input type="checkbox" id="chkbox_selectAll">
	<table border="1px">
		<thead>
			<tr>
				<th>회원번호</th>
				<th>이메일</th>
				<th>아이디</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>등급</th>
			</tr>
		</thead>

		<c:forEach var="row" items="${ userInfo }">
			<tr>
				<td>${ row.user_num }</td>
				<td>${ row.user_email }</td>
				<%-- 아이디 null이면 글자 NULL 출력 --%>
				<td><a href="user?cmd=detail&num=${ row.user_num }"> <c:if
							test="${ empty row.user_id }"> NULL </c:if> <c:if
							test="${ !(empty row.user_id) }"> ${ row.user_id } </c:if>
				</a></td>

				<td><c:if test="${ empty row.user_tel }"> 전화번호 없음 </c:if> <c:if
						test="${ !(empty row.user_tel) }"> ${ row.user_tel } </c:if></td>
				<td>${ row.user_addr }</td>
				<td>
					<c:if test="${ row.grade eq 1 }">최종 관리자</c:if> 
					<c:if test="${ row.grade eq 2 }">상위 관리자</c:if> 
					<c:if test="${ row.grade eq 3 }">관리자</c:if> 
					<c:if test="${ row.grade eq 4 }">와우 회원 가입 고객</c:if> 
					<c:if test="${ row.grade eq 5 }">일반 고객</c:if>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>