<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><a href="coopang">메인 페이지 </a></h1>

<hr>
카테고리 
<hr>
상태 : 
<!-- 로그인 유저 -->
<c:if test="${ userInfo.user_num ne null }">
	[로그인]
	<a href='user?cmd=detail&num=${ userInfo.user_num }'>마이페이지</a>
	<form method=post action="user">
		<input type="hidden" name="cmd" value="logout">
		<input type="submit" value="로그아웃">
	</form>
</c:if> 
<!-- 비로그인 유저 -->
<c:if test="${ userInfo.user_num eq null }">
	[비로그인]
	<a href='login.jsp'>로그인</a>
	<a href='user?cmd=signin'>회원가입</a>
</c:if>
<br>
<!-- admin  -->
<c:if test="${ userInfo.grade lt 2 }">
	
	[관리자]
	<a href='user?cmd=list'>회원 목록</a><br>
</c:if>
<hr>

<a href='item?cmd=list'>상품 목록</a><br>
<hr>
캐러셀 <br>
<hr>
이미지 <br>
<hr>
이미지 <br>
상품명 단위(몇개씩) <br>
가격 <br>
배송 정보 <br> 
평점


</body>
</html>