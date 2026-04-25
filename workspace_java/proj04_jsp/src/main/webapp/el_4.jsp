<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
\[${ 10 }] : [${ 10 }] <br>
[\${ null }] : [${ null }] <br>
	: null이면 아무것도 안나옴, 예외 발생하지 않음 <br><br>

\${ 10+5 } : ${10+5} <br>
	: 간단한 연산 가능 <br><br>
	
\${ "10"+5 } : ${ "10"+5 } <br>
	: EL은 계산할 때 문자를 숫자로 바꾼다 <br> <br>
	
<%-- \${ "a"+5 } : ${ "a"+5 } --%> 
<%-- \${ "a"+"b" } : ${ "a"+"b" } --%> 
	: 문자 연산 = 에러 <br>
	
\${ "a" } : ${ "a" } <br>
	: 문자만 출력은 가능 <br><br>
	
\${ "a"+=1 } : ${ "a"+=1 } <br>
	: 이건 됨 <br> <br>
<%
	String a = "a";
	a = a + 1;
%>

\${ 10 % 4 } : ${ 10 % 4 } <br>
\${ 10 mod 4 } : ${ 10 mod 4 } <br>
	: 나머지 문법 <br><br>
	
\${ 10 / 4 } : ${ 10 / 4 } <br>
\${ 10 div 4 } : ${ 10 div 4 } <br>
	: 나누기 문법 <br><br>
	
\${ 10 == 4 } : ${ 10 == 4 } <br>
\${ "a" == "a" } : ${ "a" == "a" } <br>
\${ 10 eq 4 } : ${ 10 eq 4 } <br>
	: equal 문법 <br><br>
	
\${ 10 != 4 } : ${ 10 != 4 } <br>
\${ 10 ne 4 } : ${ 10 ne 4 } <br>
	: not equal 문법 <br><br>
	
\${ !("a" eq "a") } : ${ !("a" eq "a") } <br>
\${ not("a" eq "a") } : ${ not("a" eq "a") } <br>
	: 괄호 equal 문법 <br><br>
	
\${ 10 > 4 } : ${ 10 > 4 } <br>
\${ 10 gt 4 } : ${ 10 gt 4 } <br>
	: greater than <br><br>

\${ 10 < 4 } : ${ 10 < 4 } <br>
\${ 10 lt 4 } : ${ 10 lt 4 } <br>

\${ 10 < 4 } : ${ 10 < 4 } <br>
\${ 10 ge 4 } : ${ 10 ge 4 } <br>

\${ 10 < 4 } : ${ 10 < 4 } <br>
\${ 10 le 4 } : ${ 10 le 4 } : little or equal <br>

\${ ( 10 <= 4 ) eq "false" } : ${ ( 10 <= 4 ) eq "false" } <br><br>

\S{ (100>3) && (7 != 3) } : ${ (100>3) && (7 != 3) } <br>
\S{ (100 gt 3) and (7 ne 3) } : ${ (100 gt 3) and (7 ne 3) } <br><br>

\S{ (100>3) || (7 != 3) } : ${ (100>3) || (7 != 3) } <br>
\S{ (100>3) or (7 ne 3) } : ${ (100>3) or (7 ne 3) } <br><br>

<hr>

\S{ empty "글씨" } : ${ empty "글씨" } <br>
\S{ empty "" } : ${ empty "" } <br>
\S{ empty null } : ${ empty null } <br><br>
<strong> 내용이 없으면 true 배열, 맵, 전부 가능! </strong> <br>

파라미터 생략 : 
request.getParameter("a") : <%= request.getParameter("a") %> <br>

\S{ param.a } : ${ param.a } <br>
\S{ param.b } : ${ param.b } <br><br>

\S{ paramValues.a } : ${ paramValues.a } <br>
\S{ paramValues.a[0] } : ${ paramValues.a[0] } <br>
\S{ paramValues.a[1] } : ${ paramValues.a[1] } <br>
\S{ paramValues.a[100] } : ${ paramValues.a[100] } 에러 없음에 주의<br>

request.getAttribute("num") : <%= request.getAttribute("num") %> <br><br>
\S{ num } : ${ num } <br>
\S{ num2 } : ${ num2 } <br><br>

\S{ list } : ${ list } <br>
\S{ list[0] } : ${ list[1] } <br><br>

\S{  map } : ${ map } <br>
\S{ map["하나"] } : ${ map["하나"] } <br><br>

\S{  todoDTO } : ${ todoDTO } <br>
\S{ todoDTO.content } : ${ todoDTO.content } <br><br>





</body>
</html>