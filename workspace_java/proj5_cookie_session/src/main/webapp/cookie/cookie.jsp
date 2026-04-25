<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.popup{
	border: 1px solid red;
	width: 230px;
	height: 300px;
	
	box-shadow : 3px 3px 3px 3px #e2e2e2;
 	}
 	
 	.hide {
 		display: none;
 	}
 	
</style>

<script>
	window.addEventListener('load', function(){
		printCookie()
		bind()
	})
	
	function printCookie(){
		console.log( document.cookie )
		//name=최민수; dinner=국밥
		
		const cookies = document.cookie.split('; ')
		for( c of cookies){
			//name=최민수
			
			const name = c.split("=")[0]
			const value = c.split("=")[1]
			
			console.log(`name : \${name}, value : \${value}` )
			
			// 이름이 popup / value N -> 팝업 보지 않기
			if(name == "popup" && value == "N") {
				document.querySelector('.popup').classList.add("hide")
			}
		}
	}
	
	function bind(){
		document.querySelector("#noShow") 
			.addEventListener('click', function(event){
			
				if(event.target.checked) {
					// 세션 쿠키 (만료일이 없는 쿠키)
					// document.cookie = "popup=N"
					
					// 만료일이 있는 쿠키
					const now = new Date()
					const after10s = now.getSeconds() + 10 // 10초 뒤
					now.setSeconds(after10s)
					
					// expires로 만료 기간 설정
					document.cookie = "popup=N;expires="+now.toGMTString();
				} 
				
		})
	}
</script>

</head>
<body>

<div class="popup">
	공지사항 <br>
	꼭 보세요 <br>
	<hr>
	<input type="checkbox" id="noShow"> 10초 동안 보지 않기
</div>
	

</body>
</html>