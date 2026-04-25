<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> SECRET </h1>
<c:if test="${ param.login eq y }">
passcode : ${ passcode } <br>
암구호 : ${ 암구호 } <br>
</c:if>

<c:if test="${ param.login ne y }">
	<% response.sendRedirect("login"); %>
</c:if>


</body>
</html>