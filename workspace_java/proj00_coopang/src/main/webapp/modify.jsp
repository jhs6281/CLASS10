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
</head>
<body>

<h1>정보 수정</h1>
	<c:forEach var="row" items="${ userInfo }">
		<form method="post" action="user">
			<input type="hidden" value="${ row.user_num }" name="num"><br> 
				
				회원번호 : <span>${ row.user_num }</span> <br> 
				닉네임 : <input type="text" value="${ row.user_nickname }" name="user_nickname"> <br>
				이메일 : <input type="text" value="${ row.user_email }" name="user_email"> <br> 
				이름 : <input type="text" value="${ row.user_name }" name="user_name"> <br>
				휴대폰번호 : <input type="text" value="${ row.user_tel }" name="user_tel"> <br> 
				아이디 : <input type="test" value="${ row.user_id }" name="user_id"> <br> 
				비밀번호 : <input type="password" value="${ row.user_pw }" name="user_pw"><br> 
				비밀번호 확인 : <input type="password" value="" name="pw_chk"><br> 
				<c:if test="${ param.msg eq 1 }">
					<div style="color: red;">비밀번호가 일치하지 않습니다.</div>
				</c:if>
				주소 : <input type="text" value="${ row.user_addr }" name="user_addr"> <br> 
				가입일자 : <input type="date"value="${ row.hiredate }" name="hiredate"> <br> 
				등급 :
				<c:if test="${ row.grade le 3 }">
					 <input type="text" value="${ row.grade }" name="grade"> <br>
				</c:if>
				<c:if test="${ not(row.grade le 3) }">
					 <input type="hidden" value="${ row.grade }" name="grade">
					 <span>${ row.grade }</span> <br>
				</c:if>
			<input type="hidden" name="cmd" value="modify"> 
			<input type="submit" value="수정완료"> 
			<a href="user">취소</a>
		</form>
	</c:forEach>
</body>
</html>