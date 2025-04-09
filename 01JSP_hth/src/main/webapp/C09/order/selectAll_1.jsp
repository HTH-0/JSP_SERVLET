<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<!--
	품목별 총합 (총합별 내림차순)
	select CATEGORY,sum(price*quantity) from tbl_order
	group by CATEGORY
	having sum(price*quantity) >=50000
	order by sum(price*quantity) desc;
-->
<%@page import="C04.UserDto,C09.*,java.util.*" %>
<%
	 List<OrderDto> list1 = DBUtils.getInstance().selectAllOrder1();
	 List<OrderDto> list2 = DBUtils.getInstance().selectAllOrder2();

	
%>

  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>품목별 총액 (50000원 이상)</h1>
	<%
	
	%>
	<table>
		<tr>
			<th>품목</th>
			<th>총합</th>
		</tr>
		<%
			for(OrderDto orderDto : list1){
				%>
					<tr>
						<th><%=orderDto.getCATEGORY() %></th>
						<th><%=orderDto.getSUM()%></th>
					</tr>
			<%	
			}
		%>
	</table>
	<h1>날짜별 구매 총 평균</h1>
	<!-- 
		SELECT order_date, round(avg(price * quantity),2)
		FROM tbl_order
		GROUP BY order_date;
	 -->
	<table>
		<tr>
			<th>품목</th>
			<th>총합</th>
		</tr>
		<%
			for(OrderDto orderDto : list2){
				%>
					<tr>
						<th><%=orderDto.getORDER_DATE() %></th>
						<th><%=orderDto.getAVG()%></th>
					</tr>
			<%	
			}
		%>
	</table>
</body>
</html>