<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="jsp_1.jsp">
		<jsp:param name="name" value="qq" />
	</jsp:include> 
	
		<%-- include 안에 주석 있으니까 에러 나더라 --%>
		<%--<jsp:param name="name" value="abcd"></jsp:param> --%>
<%-- 	<jsp:forward page="footer.jsp" /> --%>
	
	<% 
		empDTO.EmpDTO dto2 = new empDTO.EmpDTO();
		pageContext.setAttribute("dto2", dto2);
	%>
    <!-- 	     id는 key값 / class는 경로까지 지정 import 안먹음 -->
	<jsp:useBean id="dto" class="empDTO.EmpDTO" scope="page" />
	
	property에 지정한 글씨를 기반으로 setter 호출 <br>
	<jsp:setProperty name="dto" property="empNo" value='<%= Integer.parseInt(request.getParameter("empno")) %>' /> <br>
	<jsp:setProperty name="dto" property="empNo" value="${param.empno }" /> <br>
	<jsp:setProperty name="dto" property="*" /> <br>
	
	전달받은 파라미터 이름을 기반으로 알아서 모든 setter를 호출한다
	
	<jsp:setProperty name="dto" property="eName" /><br>
	
	<jsp:getProperty name="dto" property="eName" /><br>
	
	getProperty를 사용하지 않는 이유 <br>
	\${ dto.eName } : ${ dto.eName }
	
</body>
</html>