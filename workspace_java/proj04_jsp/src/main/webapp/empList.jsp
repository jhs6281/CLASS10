<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="empDTO.EmpDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${ list }
	<h1> 사원 목록 </h1>
	
	<% List<EmpDTO> dto = (List<EmpDTO>) request.getAttribute("list"); %>
	<% System.out.println(dto); %>
	
	<table border="1px">
	
	

		<thead>
			<tr>
				<th>EmpNo</th>
				<th>ename</th>
				<th>job</th>
				<th>mgr</th>
				<th>hiredate</th>
				<th>sal</th>
				<th>comm</th>
				<th>deptno</th>
			</tr>
		</thead>
	<c:forEach var="item" items="${ list }">
		<tr>
			<td> ${ item.getEmpno() } </td> 
			<td> ${ item.getEname() } </td>
			<td> ${ item.getJob() } </td> 
			<td> ${ item.getMgr() } </td> 
			<td> ${ item.getHireDate() } </td>
			<td> ${ item.getSal() } </td>
			<td> ${ item.getComm() } </td> 
			<td> ${ item.getDeptno() } </td> 
		</tr>
	</c:forEach>
	
	</table>
</body>
</html>