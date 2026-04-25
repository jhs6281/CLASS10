<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<%@ page import="
                 javax.servlet.http.HttpSession,
                 emp.EmpDTO,
                 java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
			
	%>
	<hr>
<c:forEach var="i" items="${list}">
    empno : ${ i.empno } <br>
    ename : ${ i.ename } <br>
    job : ${ i.job } <br>
    mgr : ${ i.mgr } <br>
    hireDate : ${ i.hireDate } <br>
    sal : ${ i.sal } <br>
    comm : ${ i.comm } <br>
    deptno : ${ i.deptno } <br>
    <hr>
</c:forEach>
</body>
</html>