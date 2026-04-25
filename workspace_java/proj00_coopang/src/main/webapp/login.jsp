<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='main.jsp'>메인페이지</a>
<hr>
<h1>Login</h1>
<form method="post" action="user">
	이메일 : <input type="text" name="email"> <br>
	비밀번호 : <input type="password" name="pw"> <br>
	<c:if test="${ param.msg eq 1 }">
		<div style="color: red;">아이디 혹은 비밀번호가 일치하지 않습니다.</div>
	</c:if>
	<input type="submit" value="로그인"> <br>
	<input type="hidden" name="cmd" value="login"> <br>
</form>

<h1>회원가입 </h1>
<form method="post" action="user">
	<input type="hidden" name="cmd" value="signin"> <br>
	<input type="submit" value="회원가입"> <br>
</form>



</body>
</html>