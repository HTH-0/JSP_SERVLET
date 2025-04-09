<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 파라미터 받기 -->
    <%@page import="DBPKG.*" %>
    <%
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
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
    
   		DBUtils dbUtils = new DBUtils();
    	int result = dbUtils.func2(voteDTO2);
    	
    	if(result > 0){
    		out.println("<script> alert('투표 성공') </script>");
    		request.getRequestDispatcher("./Read.jsp").forward(request, response);
    	}
    	else{
    		out.println("<script> alert('') </script>");
    	}
    %>
    