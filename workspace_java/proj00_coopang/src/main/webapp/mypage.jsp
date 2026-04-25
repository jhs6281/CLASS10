<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<a href="coopang">메인으로</a> <br>
	<c:forEach var="row" items="${ userInfo }">
		회원번호 : ${ row.user_num } <br>
		닉네임 : ${ row.user_nickname } <br>
		이메일 : ${ row.user_email } <br>
		이름 : ${ row.user_name } <br>
		전화번호 : ${ row.user_tel } <br>
		아이디 : ${ row.user_id } <br>
		비밀번호 : ${ row.user_pw } <br>
		주소 : ${ row.user_addr } <br>
		가입일자 : ${ row.hiredate } <br>
		등급 : 
				<c:if test="${ row.grade eq 1 }">최종 관리자</c:if>
				<c:if test="${ row.grade eq 2 }">상위 관리자</c:if>
				<c:if test="${ row.grade eq 3 }">관리자</c:if>
				<c:if test="${ row.grade eq 4 }">와우 회원 가입 고객</c:if>
			    <c:if test="${ row.grade eq 5 }">일반 고객</c:if>
		<br>
	</c:forEach>
	<a href='?cmd=update&num=${ userInfo.get(0).user_num }'>정보수정</a>

	<a href="?cmd=delete&num=${ userInfo.get(0).user_num }">회원삭제</a>

	<a href="">장바구니</a>





</body>
</html>