<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="examDTO.SignInDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% List<SignInDTO> list = (List<SignInDTO>) request.getAttribute("list"); %>
	<% System.out.println(list.get(0).getNum()); %>
	
	<form method="post" action="signIn">
	 <% for(SignInDTO item : list) { %>
 		<input type="hidden" value="<%= item.getNum() %>" name="num"> <br>
 		번호 : <span><%= item.getNum() %></span> <br>
 		사원번호 : <input type="text" value="<%= item.getEmpno() %>" name="empno"> <br>
 		아이디 : <input type="text" value="<%= item.getId() %>" name="id"> <br>
 		비밀번호 : <input type="text" value="<%= item.getPw() %>" name="pw"> <br>
 		이메일 : <input type="text" value="<%= item.getEmail() %>" name="email"> <br>
 		입사날짜 : <input type="date" value="<%= item.getHireDate() %>" name="hireDate"> <br>
 		재직중 : <input type="text" value="<%= item.getWorking() %>" name="working"> <br>
 	 <% } %>
 	 	<input type="hidden" name="cmd" value="modify">
 		<input type="submit" value="수정완료"> <a href="signIn">취소</a>
 	</form>
	
</body>
</html>