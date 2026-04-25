<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="userdto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
window.addEventListener("load", function(){
	bind()
})

function bind (){
	const chk_unique = document.querySelector('#chk_unique')
		chk_unique.addEventListener("click", function(){
			<% request.setAttribute("chk_unique", 1); %>
			
	})
}
</script>

</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="user"> <br>
	
<!-- 		empno : 	 <input type="text" name="empno" value="1"> <br> -->
		ename : 	 <input type="text" name="ename" value="ename"> <br>
		email : 	 <input type="text" name="email" value="email"> <br>
		
		id : 		 <input type="text" name=id value="id"> 
					 <button type="button" id="chk_unique">중복검사 아직 안됨</button> <br>
					 <c:if test="${ param.msg eq 1 }">
					 	<div style="color: red;">중복된 아이디입니다.</div>
					 </c:if>
					 
					 
		pw : 	 <input type="password" name="pw" value="1234"> <br>
		pw check : <input type="password" name="pw" value="1234"> <br>
			<c:if test="${ param.msg eq 2 }">
					<div style="color: red;">비밀번호가 일치하지 않습니다.</div>
			</c:if>
<!-- 		grade : 		 <input type="text" name=grade value="5"> <br> -->
		
		<input type="hidden" name="cmd" value="insert">
		<input type="submit" value="회원가입">
		<a href="user">뒤로</a>
	</form>
</body>


</html>