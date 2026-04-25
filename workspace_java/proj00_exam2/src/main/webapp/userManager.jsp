<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*" import="examDTO.SignInDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 관리</h1>

	<form method="post" action="delete">
		전체선택 <input type="checkbox" id="chkbox_selectAll">
		<table border="1px">
			<thead>
				<tr>
					<th>선택</th>
					<th>사원번호</th>
					<th>아이디</th>
					<th>이메일</th>
					<th>재직중</th>
				</tr>
			</thead>

			<c:forEach var="item" items="${ DBlist }">
				<tr>
					<td><input type="checkbox" name="chk_selectOne"
						value="${ item.num }" class="chkbox_selectOne"></td>
					<td>${ item.empno }</td>
					<td><a href="signIn?cmd=detail&num=${ item.num }"> <%-- null이면 글자 NULL 출력 --%>
							<c:if test="${ empty item.id }"> NULL </c:if> <c:if
								test="${ !(empty item.id) }"> ${ item.id } </c:if>
					</a></td>
					<td><c:if test="${ empty item.email }"> 이메일 없음 </c:if> <c:if
							test="${ !(empty item.email) }"> ${ item.email } </c:if></td>
					<td>${ item.working }</td>
				</tr>
			</c:forEach>

		</table>
	</form>
</body>

<script>
	function bind() {
	    selectAll();
	}

	function selectAll() {

	    const chkbox_selectAll = document.querySelector("#chkbox_selectAll")

	    console.log("test")
	    
	    chkbox_selectAll.addEventListener("change", function () {

	    	
	        const chkbox_selectOne = document.querySelectorAll(".chkbox_selectOne")
	        if (chkbox_selectAll.checked) {
	             chkbox_selectOne.forEach(value => {
	                 chkbox_selectOne.checked = true
	                 console.log("test")
	              })
	            //chkbox_selectOne.checked = true

	        } else {
	            chkbox_selectOne.checked = false
	        }
	    })
	}
	</script>

</html>