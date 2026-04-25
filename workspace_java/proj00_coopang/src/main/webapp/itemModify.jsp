<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="item.dto.ItemDTO"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 정보 수정</h1>

		<form method="post" action="item">
	<c:forEach var="row" items="${ itemInfo }">
			<input type="hidden" value="${ row.item_num }" name="item_num"><br>
			<div>상품번호 : ${ row.item_num }</div>
			그림 : <input type="text" value="${ row.item_img }" name="item_img"> <br>
			카테고리 : 
			<select type="" value="${ row.category }" name="category">
				<option>식품</option>
				<option>생활용품</option>
			</select> <br>
			아이디 : <input type="text" value="${ row.item_id }" name="item_id"> <br> 
			상품명 : <input type="text" value="${ row.item_name }" name="item_name"> <br> 
			가격 : <input type="text" value="${ row.price }" name="price"> <br>
			상세설명 :
			<textarea name="item_info" name="item_info">${ row.item_info }</textarea> <br>
			평점 : <input type="text" value="${ row.score }" name="score"> <br>
			등록일자 : <input type="date" value="${ row.setTime }" name="setTime"> <br>
			배송정보 : <input type="text" value="${ row.shipping_Level }" name="shipping_Level"> <br>

			<input type="hidden" name="cmd" value="modify"> 
			<input type="submit" value="수정완료"> <a href="item">취소</a>
	</c:forEach>

	</form>
</body>
</html>