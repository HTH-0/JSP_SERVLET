<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 파라미터 받기 -->
<%@page import="Utils.*" %>
<%

%>  

<!-- 파라미터 받기(액션 태그) -: useBean + :setProperty -->
<jsp:useBean id="classDto" class="Utils.ClassDto" scope="request" />
<jsp:setProperty name="classDto" property="*" />

<%
	System.out.println(classDto);
%>




