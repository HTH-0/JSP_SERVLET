<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ page import="C04.UserDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	EL ( Expression Language ) : 내장 객체의 Scope 참조
	pageScope : 현재 JSP 페이지 내에서만 사용 가능한 속성/기능 (관련 내장 객체 : pageContext)
	requestScope : 하나의 요청 처리 동안 (관련 내장 객체 : request)
	sessionScope : 일정기간 동안( 지정 or 기본값) (관련 내장 객체 : session)
	applicaitionScope : 서버 종료 시 동안 (관련 내장 객체 : applications)

 -->

<%
	pageContext.setAttribute("P_ATTR", "P_ATTR_VALUE");
	request.setAttribute("R_ATTR", "R_ATTR_VALUE");
	session.setAttribute("S_ATTR","S_ATTR_VALUE");
	application.setAttribute("A_ATTR","A_ATTR_VALUE");
	
	pageContext.setAttribute("DUP", "PAGE VALUE");
	request.setAttribute("DUP", "REQUEST VALUE");
	session.setAttribute("DUP","SESSION VALUE");
	application.setAttribute("DUP","APPLICATION VALUE");
	
	

	
	
%>
	<hr />
	<!--  EL : PARAM -->
	
	USERNAME : ${param.username} <br />
	PASSWORD : ${param.password} <br />
	
	<!-- 	EL : ATTRIBUTE  -->
	PAGECONTEXT's ATTR : ${P_ATTR} <br />
	PAGECONTEXT's ATTR : ${pageScope.P_ATTR} <br />
	REQUESTCONTEXT's ATTR : ${R_ATTR} <br />
	REQUESTCONTEXT's ATTR : ${requestScope.R_ATTR} <br />
	SESSION's ATTR : ${S_ATTR} <br />
	SESSION's ATTR : ${sessionScope.S_ATTR} <br />
	APPLICATION's ATTR : ${A_ATTR} <br />
	APPLICATION's ATTR : ${applicationScope.A_ATTR} <br />
	
	
	<hr />.
	<!--  EL : ATTRIBUTE(중복값) -->
	DUPLICATED VALUE : ${DUP} <br />
	<hr />
	
	<!--  EL : OBJECT -->
	<%
	UserDto userDto = new UserDto("user1", "1234", "ROLE_USER");
	request.setAttribute("userDto", userDto);
	%>
	표현식 : <%=userDto.getUserid() %> <br/>
	EL : ${userDto.userid} <br />
	
	<!-- EL : 연산자 -->
	연산 : <%= 1+1 %> <br />
	EL : ${1+1} <br />
	
	<!--  NULL CHECK -->
	NULL : ${null} <br />
	empty NULL : ${empty null} <br />
	
	empty null : ${empty TEST} <br />
	empty not null : ${!empty TEST} <br />
	
</body>
</html>