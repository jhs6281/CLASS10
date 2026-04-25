<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
    <%@ page import="item.dto.ItemDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>상품 등록</h1>


	<form method="post" action="item"> <br>
	
		상품이미지주소 :<input type="text" name="item_img"> <br>
		카테고리 : 	<select name="category">
						<option>식품</option>
						<option>생활용품</option>
					</select> <br>
		상품아이디 : 	<input type="text" name="item_id"> <br>
		상품명 : 		<input type="text" name="item_name"> <br>
		가격 : 		<input type="text" name="price"> <br>
		상세설명 : 	<input type="textarea" name="item_info"> <br>
		배송정보 : 	<label> <input type="radio" name="shipping_Level" value="0" checked> 일반배송 </label> 
				 	<label> <input type="radio" name="shipping_Level" value="1"> 와우배송 </label> 
				 	<label> <input type="radio" name="shipping_Level" value="2"> 로켓배송 </label> <br>
		
<!-- 제품명 → Product Name -->
<!-- 생산자 및 소재지 → Manufacturer and Place of Origin -->
<!-- 소비기한 또는 품질유지기한 → Expiration Date or Best Before Date -->
<!-- 소비기한(또는 유통기한) → Use-by Date (or Expiration Date) -->
<!-- 제조년월일 → Date of Manufacture -->
<!-- 포장단위별 내용물의 용량(중량), 수량 → Net Content (Weight/Volume) and Quantity per Package -->
<!-- 원재료명 및 함량 → Ingredients and Content -->
		
		<input type="hidden" name="cmd" value="insert">
		<input type="submit" value="상품등록">
		<a href="item">뒤로</a>
	</form>

</body>
</html>