<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보를 입력해주세요.</h1>
	<form method="post" action="signIn"> <br>
		사원번호 : 	 <input type="text" name="empno"> <br>
		아이디 : 		 <input type="text" name="id"> <br>
		비밀번호 : 	 <input type="password" name="pw"> <br>
		비밀번호 확인 : <input type="password" name="pwcheck"> <br>
		이메일 : 		 <input type="text" name="email"> <br>
		입사날짜 : 	 <input type="date" name="hireDate"> <br>
		<input type="hidden" name="cmd" value="insert">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>