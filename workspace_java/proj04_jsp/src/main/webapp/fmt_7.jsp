<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Date" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<pre>
		Date date = new Date() ; // 시계 생성
		System.out.println(date);
		
		String format = "yyyy년 MM월 dd일 HH:mm:ss.SSS"; // 양식 지정
		SimpleDateFormat sdf = new SimpleDateFormat(format); // SimpleDateFormat("양식")
		String strDate = sdf.format(date); // 힙 영역의 값 get
		System.out.println(strDate); 
</pre>

<hr>

new Date() : <%= new Date() %>

<hr>

<fmt:formatDate
	value="<%= new Date() %>"
	pattern="yyyy년 MM월 dd일 a HH:mm:ss.SSS"
/>
</body>
</html>