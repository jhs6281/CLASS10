<!-- html 주석 브라우저에서만 숨겨지는 형태 / Message, 함수도 기능함 -->
<%-- jsp 주석 자바에서 컴파일이 안됨 --%>

<%-- 

	디렉티브 태그
	"<%@"로 시작하는 태그
	1. page      : 페이지 설정 및 import
	2. include   : 다른 jsp body에 붙여넣기
	3. taglib    : custom tag library 

	@ 붙은 것은 java로 번역하라는 뜻

 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List" import="java.util.Map"
	import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	window.onload = function() {
		console.log("jsp_1.jsp")
	}
</script>

</head>
<body>
	<h1>hello world</h1>
	<!-- 스크립틀릿 Scriptlet -->
	<%
	// 여기는 java 땅 입니다.
	System.out.println("hello java");
	%>

	<table border="1">
		<%
		for (int i = 0; i < 5; i++) {
		%>
		<tr>
			<td>제목</td>
			<td>내용</td>
		</tr>
		<%
		}
		%>

		<%
		for (int i = 0; i < 5; i++) {
			out.write(" <tr>");
			out.write(" <td> 제목 2 </td>");
			out.write(" <td> 내용 2 </td>");
			out.write(" </tr>");
		}
		%>
	</table>
	<br>


	<form method="get" action="">
		이름 : <input type="text" name="name"> <input type="submit"
			value="이름 전송">
	</form>
	<br>

	<%
	String name = request.getParameter("name");
	System.out.println("name: " + name);

	int a = 10;
	%>

	<!-- 표현식 -->
	<%=a%>
	<br>
	<%="out.writer를 바꾼 형태 : " + request.getParameter("name")%>

	<!-- 선언문 -->
	<%!String title = "보스";

	String getTitle() {
		return this.title;
	}%>
	<br>
	<%=getTitle()%>

	<!-- 	구구단 2단 출력 -->
	<%
	int gugu = 2;
	for (int i = 1; i <= 9; i++) {
		out.println(gugu + "x" + i + "=" + (gugu * i) + "<br>");
	}
	%>
	<hr>

	<%
	for (int i = 0; i <= 9; i++) {
	%>
	2 x
	<%=i%>
	=
	<%=(2 * i)%>
	<br>
	<%
	}
	%>

	<hr>

	<!-- Include (불러오기) -->
	<%@ include file="footer.jsp"%>
	<%--
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<h1> footer.jsp </h1>
	 --%>
</body>
</html>