<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="item.dto.ItemDTO"%>

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
.thumbnail {
	    background-repeat: no-repeat;
	    background-size: contain;
	    background-position: center center;
	    
	    height: auto;
	    width: 300px;
}
</style>

</head>
<body>
<h1> 상품 리스트 </h1>
<a href="item?cmd=insertPage">등록</a>
<a href="main.jsp">뒤로</a>

<table border="1px">
		<thead>
			<tr>
				<th>그림</th>
				<th>이름</th>
				<th>가격</th>
				<th>평점</th>
				<th>등록일자</th>
				<th>배송</th>
			</tr>
		</thead>
		
		<c:forEach var="row" items="${ itemInfo }">
				<tr>
					<td class="item_img" style="background-image:url('${row.item_img}');"></td>
					<td><a href="item?cmd=detail&num=${ row.item_num }">${ row.item_name }</a></td>
					<%-- 아이디 null이면 글자 NULL 출력 --%>
					<td>${ row.price }</td>
<%-- 					<c:if test="${ empty row.user_tel }"> 전화번호 없음 </c:if>  --%>
					<td>${ row.score }</td>
					<td>${ row.setTime }</td>
					<td>
						<c:if test="${ row.shipping_Level eq 0 }"> 3일 소요 예정 </c:if>
						<c:if test="${ row.shipping_Level eq 1 }"> 와우배송 </c:if>
						<c:if test="${ row.shipping_Level eq 2 }"> 로켓배송 </c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="user"><img class="thumbnail" src="https://cdn.discordapp.com/attachments/1455055270819659971/1486590151185666168/image.png?ex=69cbfd37&is=69caabb7&hm=3cc61688420b677b9733cae35171c20cb19cfa26416bc5f3168820546335ce39&"></a>
</body>
</html>