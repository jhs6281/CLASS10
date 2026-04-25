<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="emp_DTO.EmpDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	window.addEventListener('load', bind)

	function bind() {
        const url = '' // json 받아올 url
            const option = {
                method: 'get'
            }
            // 새로운 방식
            fetch(url, option).then(function (response) {
                return response.json()
            }).then(function (json) {
                console.log(json)
            }).catch(function (error) { // 에러 발생시 catch
                console.error(error)
            })
	}
</script>

</head>
<body>
	<h1>사원 목록</h1>

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
		<c:forEach var="item" items="${ map.list }">
			<tr>
				<td>${ item.getEmpno() }</td>
				<td>${ item.getEname() }</td>
				<td>${ item.getJob() }</td>
				<td>${ item.getMgr() }</td>
				<td>${ item.getHireDate() }</td>
				<td>${ item.getSal() }</td>
				<td>${ item.getComm() }</td>
				<td>${ item.getDeptno() }</td>
			</tr>
		</c:forEach>

	</table>


	<%
	Map map = (Map) request.getAttribute("map");
	int total = (int) map.get("totalCount");
	int size = (int) map.get("size");

	int totalPage = (int) Math.ceil((double) total / size);

	int section = 5; // 한번에 보여줄 페이지들의 수

	int pageNum = (int) map.get("page");

	int end_section = (int) Math.ceil((double) pageNum / section) * section; // 페이지 끝자리 ( 5 미만일 때 or 맨 마지막 자리 )
	int start_section = end_section - section + 1; // 페이지 첫자리 계산 6, ,11 ,16

	if (end_section > totalPage) {
		end_section = totalPage;
	}
	
	%>

	<c:if test="<%=start_section == 1%>">이전</c:if>

	<c:if test="<%=start_section != 1%>">
		<a href='list?size=10&page=<%=start_section - 1%>'>이전</a>
	</c:if>


	<c:forEach var="i" begin="<%=start_section%>"
		end="<%=end_section%>">
		<a href='list?size=10&page=${i}'> <c:if test="${ map.page eq i }">
				<strong> ${ i } </strong>
			</c:if> <c:if test="${ map.page ne i }">
			 ${ i } 
		</c:if>
		</a>
	</c:forEach>

	<c:if test="<%=end_section == totalPage%>">다음</c:if>
	<c:if test="<%=end_section != totalPage%>">
		<a href=list?size=10&page= <%=end_section + 1%>>다음</a>
	</c:if>



</body>
</html>