<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- c(코어)는 uri(라이브러리)에 저장 되어있음 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="a" value="10"></c:set>
\${ a } : ${ a } <br>
<%
	String name = "현수";
%>
\${ name } : ${ name } <br>
<input value="<%=name %>"> <br>
<!-- request에 할당한다 var은 키, value가 값 -->
<c:set var="name2" value="<%=name%>" /> <br>
\${ name2 } : ${ name2 } <br>

생명주기 우선순위 <br>
scope : page > request > session > application <br>
<c:set var="name3" value="<%=name%>" scope="page" /> <br>
scope를 생략하면 page \< 중요
<!-- 현재 페이지까지 생명주기 -->
<c:set var="wish" value="데이트" scope="page" />
<!-- 현재 페이지 + forward로 전달해서 응답할 때까지 -->
<c:set var="wish" value="여행" scope="request" />
<!-- 다른탭끼리 -->
<c:set var="wish" value="게임" scope="session" />
<!-- 서버 -->
<c:set var="wish" value="잠" scope="application" />
<br>
\${wish} : ${wish}
<%
	System.out.println("name2 : "  + name);
%>

pageScope : ${ pageScope.wish } <br>
requestScope : ${ requestScope.wish } <br>
sessionScope : ${ sessionScope.wish } <br>
applicationScopte : ${ applicationScope.wish } <br>

<!-- request 보냄. -->
<%-- <jsp:forward page="jstl_5_1scope.jsp" /> --%>

<hr>
<c:set var="b" value="100" />
<c:if test="true"> 항상 참 </c:if> <br>
<c:if test="${b>10}"> b는 10보다 큽니다 </c:if> <br>
<c:if test="${ b eq 100 }"> b는 100입니다 </c:if> <br>
<!-- false라 출력 안됨 -->
<c:if test="${ not (b eq 100) }"> b는 100이 아니다 </c:if> <br>

<c:choose>
	<c:when test="${ b eq 99 }">
		b는 99입니다 <br>
	</c:when>
	<c:when test="${ b eq 101 }">
		b는 101입니다 <br>
	</c:when>
	<c:otherwise>
		b는 99와 101이 아닙니다 <br>
	</c:otherwise>
</c:choose>

<hr>
<%
	List list = new ArrayList();
	for(int i=25; i<30; i++){
		
		Map map = new HashMap();
		map.put("정신연령", i);
		map.put("실제나이", 10+i);
		
		list.add(map);
	}
%>
<c:set var="list2" value="<%=list%>" />
${ list2[0].실제나이 } <br>
${ list2.get(0).실제나이 } <br>

<br> 
items <br>
<%-- <c:forEach var="m" items="<%=list %>"> --%>
<c:forEach var="m" items="${ list2 }">
	정신연령 : ${m.정신연령} <br>
	실제나이 : ${m.실제나이} <br><br>
</c:forEach>

<hr>

begin, end 시작과 끝<br>
<c:forEach var="i" begin="0" end="3">
	${i}, ${list2[i].정신연령}<br>
</c:forEach>
<hr>

step n구간씩 건너뛰기<br>
<c:forEach var="i" begin="0" end="15" step="2">
	${i}, ${list2[i].정신연령}<br>
</c:forEach>
<hr>
varStatus<br>								<!-- loop 는 그냥 변수 -->
<c:forEach var="i" begin="0" end="4" step="2" varStatus="loop">
	${i}<c:if test="${ not loop.last }">,</c:if> <!-- 쉼표 -->
	loop.index : ${ loop.index } <br> <!-- n번째 (step이라 인덱스랑 다름) -->
	loop.count : ${ loop.count } <br> <!-- n번째 진짜 카운트 돌았는지 -->
	loop.first : ${ loop.first } <br>
	loop.last : ${ loop.last } <br>
</c:forEach>

<hr>
items, begin 등 같이 사용 <br>
<c:forEach var="m" items="${ list2 }" begin="1" end="3" varStatus="loop">
	${loop.index }, ${m.실제나이}<br>
</c:forEach>

<hr>
2~9단 출력. 단 3단 7단은 출력하지 않음 <br>
<c:forEach var="gugu" begin="2" end="9" varStatus="loop">
	<c:if test="${ not( loop.index eq 3 ) and (gugu ne 7) }">
		<c:forEach var="num" begin="1" end="9" varStatus="loop2">
			${ gugu } x ${ loop2.index } = ${ gugu*num } <br>
		</c:forEach><br>
	</c:if>
</c:forEach>
일부러 여러가지 섞어본 것
<hr>

c:url 사용 이유<br>
1. context path를 자동으로 추가한다<br>
2. 영어나 숫자 외 문자를 자동으로 url-encoding을 해준다 <br>
3. 쿠키 금지일 때 ";jsessionid=어쩌고"을 자동으로 붙여줌
<hr>
<c:url var="url1" value="/el_4.jsp"></c:url>
<a href="${ url1 }" target="_blank">el_4.jsp</a>

<c:url var="url2" value="https://search.naver.com/search.naver">
	<c:param name="query" value="한글소스" />
</c:url>

<a href="${ url2 }" target="_blank">네이버 검색창</a>

<hr>
c:out<br>

param.html : ${ param.html } : innerHTML <br>
c:out : <c:out value="${ param.html }" /> : innerText <br> 

<!-- 
	< : &lt;
	> : &gt;
	공백 : &nbsp;
	& : &amp;
 -->
</body>
</html>