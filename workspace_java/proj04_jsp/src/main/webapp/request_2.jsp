<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="java.util.*" %>
 <%@ page import="todo.DTO.TodoDTO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% System.out.println("hello forward"); %>
	
	<% // getAttribute / int, Map (import 필요)
	int num = (int) request.getAttribute("num");
	Map map = (Map) request.getAttribute("map");
	%>
	
	<%-- 출력 --%>
	<%= num %> <br>
	<%= map %> <br>
	
	<%-- 출력 방법2 축약형(import 필요 없음) --%>
	<%= request.getAttribute("map") %> <br>
	
	<%-- 실습1. getAttribute / list --%>
	<% List list = (List) request.getAttribute("list"); %>
	
	<%-- 반복문으로 내용 출력 --%>
	<% for(Object obj : list){ %>
		<%= obj %>
	<% } %>
	
	<%  // DTO 내용 꺼내서 형 변환 -> 변수 저장
		TodoDTO todoDTO = (TodoDTO) list.get(3);
	
		int id = (int) todoDTO.getTodo_id();
		Date duedate = (Date) todoDTO.getTodo_duedate();
		int done = (int) todoDTO.getTodo_done();
		String content = (String) todoDTO.getTodo_content();
		Date ctime = (Date) todoDTO.getTodo_ctime();
	%> <br>
	
	<div>
	<%= /* 화면에 출력 */
		"<br> DTO.id : " + id +
		"<br> DTO.duedate : " + duedate +
		"<br> DTO.done : " + done +
		"<br> DTO.content : " + content +
		"<br> DTO.ctime : " + ctime 
	%> 
	</div> <br>
	
	<%-- 바로 출력은 어떻게 할까? 형 변환이 두 번 --%>
	<%= ((TodoDTO)list.get(3)).getTodo_content() %>
</body>
</html>