<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="examDTO.SignInDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 상세 페이지</h1>
	<a href="signIn">목록</a>
	<hr>
	<c:forEach var="dto" items="${ list }">
  		번호 : ${dto.num} <br>
  		사원번호 : ${dto.empno} <br>
  		아이디 : ${dto.id} <br>
  		비밀번호 : ${dto.pw} <br>
  		이메일 : ${dto.email} <br>
  		입사날짜 : ${dto.hireDate} <br>
  		재직중 : ${dto.working} <br>
	</c:forEach>
	<hr>
	<a href='signIn?cmd=update&num=${ list[0].num }'>수정</a>
	<a href="signIn?cmd=delete&num=${ list[0].num }">삭제</a>



</body>
</html>