<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="user.dto.UserDTO" %>
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
	
		닉네임 : 	 <input type="text" name="user_nickname" value="nickname"> <br>
		이메일 : 	 <input type="text" name="user_email" value="email"> <br>
		이름 : 		 <input type="text" name=user_name value="name"> <br>
		전화번호 : 		 <input type="text" name=user_tel value="010-xxxx-xxxx"> <br>
		
		아이디 : 		 <input type="text" name=user_id value="id"> 
					 <button type="button" id="chk_unique">중복검사 아직 안됨</button> <br>
					 <c:if test="${ param.msg eq 1 }">
					 	<div style="color: red;">중복된 아이디입니다.</div>
					 </c:if>
					 
					 
		비밀번호 : 	 <input type="password" name="user_pw" value="1234"> <br>
		비밀번호 확인 : <input type="password" name="pwcheck" value="1234"> <br>
			<c:if test="${ param.msg eq 2 }">
					<div style="color: red;">비밀번호가 일치하지 않습니다.</div>
			</c:if>
		주소 : 		 <input type="text" name=user_addr value="address"> <br>
		
		<input type="hidden" name="cmd" value="insert">
		<input type="submit" value="회원가입">
		<a href="user">뒤로</a>
	</form>
</body>


</html>