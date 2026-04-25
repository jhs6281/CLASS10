<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="str" value="영일이삼사오육칠팔구삼사"></c:set>

\${ str } : ${ str } <br><br>
길이 : \${ fn:length(str) } : ${ fn:length(str) } <br>
자르기 : \${ fn:substring(str, 3, 6) } : ${ fn:substring(str, 3, 6) } <br><br>
치환 : \${ fn:replace(str, "삼사", "34") } : ${ fn:replace(str, "삼사", "34") } <br>
[둘 다 바뀐다. 확인 / javascript는 한개만 바꿨음] <br><br>

위치 찾기 : \${ fn:indexOf(str, "삼사") } : ${ fn:indexOf(str, "삼사") } <br>
위치 찾기 : \${ fn:indexOf(str, "삼사2") } : ${ fn:indexOf(str, "삼사2") } <br>
[값을 찾을 수 없다면 -1] <br><br>

<!--  ${ str } <%= "a" %> -->
<%= "a" %>
 
</body>
</html>