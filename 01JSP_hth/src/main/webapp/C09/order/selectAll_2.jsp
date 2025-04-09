<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    SELECT u.addr, o.order_date, sum(o.price * o.quantity) FROM tbl_user u
    JOIN tbl_order o
    ON u.userid = o.userid
    GROUP BY u.addr, o.order_date
    ORDER BY u.addr asc, sum(o.price * o.quantity) desc;
     -->
    <%@page import="C04.UserDto,C09.*,java.util.*" %>
<%
	 List<OrderDto> list1 = DBUtils.getInstance().selectAllOrder3();
	 

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>지역/날짜별 구매 총액</h1>
	<table>
		<tr>
			<th>지역</th>
			<th>날짜</th>
			<th>총액</th>
		</tr>
		<tr>
			<th>대구</th>
			<th>2025-01-01</th>
			<th>10000</th>
		</tr>
		<%
			for(OrderDto orderDto : list1){
				// 날짜 포맷팅 해서 모양 변경(yyyy*mm*dd)
				%>
					<tr>
						<th><%=orderDto.getADDR() %></th>
						<th><%=orderDto.getORDER_DATE()%></th>
						<th><%=orderDto.getSUM()%></th>
					</tr>
				<%	
			}
		%>
	</table>
</body>
</html>