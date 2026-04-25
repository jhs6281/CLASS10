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

<style>
.item_img {
	    background-repeat: no-repeat;
	    background-size: contain;
	    background-position: center center;
	    
	    height: 240px;
	    width: 300px;
}
</style>

</head>
<body>

	<h1>아이템 상세 페이지</h1>
	
	<a href="item?cmd=list">뒤로</a>
	
	<c:forEach var="row" items="${ itemInfo }">

		<div>상품번호 : ${ row.item_num }</div>
		<div class="item_img" style="background-image:url('${row.item_img}');">그림 :</div>
		<div>카테고리 : ${ row.category }</div>
		<div>아이디 : ${ row.item_id }</div>
		<div>상품명 : ${ row.item_name }</div>
		<div>가격 : ${ row.price }</div>
		<div>상세설명 : ${ row.item_info }</div>
		<div>평점 : ${ row.score }</div>
		<div>등록일자 : ${ row.setTime }</div>
		<div>
			배송정보:
			<c:if test="${ row.shipping_Level eq 0 }"> 3일 소요 예정 </c:if>
			<c:if test="${ row.shipping_Level eq 1 }"> 와우배송 </c:if>
			<c:if test="${ row.shipping_Level eq 2 }"> 로켓배송 </c:if>
		</div>

	</c:forEach>
	<a href='?cmd=update&num=${ itemInfo[0].item_num }' >정보수정</a>

	<a href="?cmd=delete&num=${ itemInfo[0].item_num }">삭제</a>

	<a href="">장바구니 담기</a>

</body>
</html>