<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ajax.jsp</h1>

	<button type="button" id="btn">ajax1 실행</button>
	<button type="button" id="btn2">ajax1 실행</button>
	<button type="button" id="btn3">ajax2 실행</button>
	<button type="button" id="btn4">ajax2 실행</button>
	<button type="button" id="btn5">ajax3 실행</button>
	<button type="button" id="btn6">ajax4 실행</button> <br>
	<button type="button" id="btn7">ajax5 실행</button> 
	<button type="button" id="btn8">ajax6 실행</button> 

	<div id="textBox"></div>
</body>
<script>
document.querySelector('#btn').addEventListener("click", function(){
    console.log("click!")
	
	 const url = 'ajax1?id=123&age=123'
			 
			fetch(url, {
				method : 'get'
			}).then(function(response){
				return response.text()
			}).then(function(data){
				console.log(data)
			}).catch(function (error) {
	            console.error(error)
	        })
			
})

document.querySelector('#btn2').addEventListener("click", function(){
    console.log("btn2 click!")
	
	 const url = 'ajax1?id=123&age=123'
			 
			fetch(url, {
				method : 'get'
			}).then(function(response){
				return response.text()
			}).then(function(data){
				console.log(data)
			}).catch(function (error) {
	            console.error(error)
	        })
			
})

// JSON 보내기
document.querySelector('#btn3').addEventListener("click", function(){
    console.log("btn3 click!")
	
    let param = {
    	id : 1234
    }
	 const url = 'ajax2'
			 
			fetch(url, {
				
				method : 'post', /* get, put, delete */
				headers : {
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(param)
				
			}).then(function(response){
				return response.text()
			}).then(function(data){
				console.log(data)
			}).catch(function (error) {
	            console.error(error)
	        })
			
})
// 4번 예전 방식
document.querySelector('#btn4').addEventListener("click", function(){
    console.log("btn4 click!")
	
    const url = 'ajax2'
    let param = {
    	id : 1234
    }
    
   const xhr = new XMLHttpRequest();

   xhr.open('post', url)
   xhr.setRequestHeader('Content-Type', 'application/json')
   xhr.send( JSON.stringify(param) )
   xhr.onload = function () {
   		console.log(xhr.responseText)
   }
			
})

// 비동기 동기화 시키는 방법
document.querySelector('#btn5').addEventListener("click", async function(){
    console.log("btn5 click!")
	
    let param = {
    	id : 1234,
    }
	 const url = 'ajax3'
	 const response = await fetch (url, {
				
				method : 'post', /* get, put, delete */
				headers : {
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(param)
				
			})
    const data = await response.text()
    console.log(data)
			
})

document.querySelector('#btn6').addEventListener("click", async function(){
    console.log("btn6 click!")
	
    let param = {
    	id : 1234,
    	age : 21
    }
	 const url = 'ajax4'
	 const response = await fetch (url, {
				
				method : 'post', /* get, put, delete */
				headers : {
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(param)
				
			})
//     const data = await response.text()
    const data = await response.json()
//     console.log(JSON.parse(data))
			console.log(data)
})

document.querySelector('#btn7').addEventListener("click", async function(){
    console.log("btn7 click!")
	
    let param = {
    	id : 1234,
    	age : 21
    }
	 const url = 'ajax5'
	 const response = await fetch (url, {
				
				method : 'post', /* get, put, delete */
				headers : {
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(param)
				
			})
//     const data = await response.text()
    const data = await response.json()
//     console.log(JSON.parse(data))
	console.log(data)
})

document.querySelector('#btn8').addEventListener("click", async function(){
    console.log("btn8 click!")
	
    let param = {
    	id : 1234,
    	age : 21
    }
	 const url = 'ajax6'
	 const response = await fetch (url, {
				
				method : 'post', /* get, put, delete */
				headers : {
					'Content-Type' : 'application/json'
				},
				body : JSON.stringify(param)
				
			})
//     const data = await response.text()
    let data = await response.json()
//     console.log(JSON.parse(data))
	console.log(data)
	
	const textBox = document.querySelector('#textBox')
	
	textBox.innerText = data + "\n"
	
// 	textBox.innerText += data.list[0].id
	
	data.list.forEach(val => {
		textBox.innerText += val.id + "\n"
		textBox.innerText += val.pw + "\n" 
		textBox.innerText += val.email + "\n"
	})
// 	textBox.innerText = data.list

	textBox.innerText += data.totalCount + "\n"
	textBox.innerText += data.pageNo + "\n"
	textBox.innerText += data.keyword + "\n"
	textBox.innerText += data.type + "\n"
	
})

</script>
</html>