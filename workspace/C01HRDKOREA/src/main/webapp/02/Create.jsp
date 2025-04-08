<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 파라미터 받기 -->
    <%@page import="DBPKG.*" %>
    <%
    	String jumin = request.getParameter("v_jumin");
    	String name = request.getParameter("v_name");
    	String no = request.getParameter("m_no");
    	String time = request.getParameter("v_time");
    	String area = request.getParameter("v_area");
    	String confirm = request.getParameter("v_confirm");
    
    	VoteDTO voteDTO = new VoteDTO(jumin, name, no, time, area, confirm);
    	System.out.println(voteDTO);
    %>
    
    <!-- 파라미터 받기(액션태그) -->
    <jsp:useBean id="voteDTO2" class="DBPKG.VoteDTO" scope="request"/>
    <jsp:setProperty name="voteDTO2" property="*"/>
    
    <%
    	System.out.println(voteDTO2);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>