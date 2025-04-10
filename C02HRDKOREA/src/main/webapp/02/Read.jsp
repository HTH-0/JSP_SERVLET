<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@page import="java.time.LocalDate,java.time.format.DateTimeFormatter" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
:root {
	
}

* {
	box-sizing: border-box;
}

body {
	padding: 0;
	margin: 0;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
	color: black;
}

.wrapper {
	
}

header {
	height: 80px;
}

nav {
	height: 50px;
}

main {
	height: calc(100vh - 80px - 50px - 80px);
	display: flex;
	justify-content: left;
	align-items: center;
	flex-direction: column;
}

table {
	border-collapse: collapse;
}

th {
	border: 1px solid;
	
}

td {
	border: 1px solid;
	
}

.button {
	align-items: center;
	justity-content: center;
	text-align: center;
}

footer {
	height: 80px;
}
</style>

</head>
<body>
	<div class="wrapper">
		<!-- 헤더 -->
		<%@ include file="/layouts/Header.jsp"%>


		<!-- 네비 -->
		<%@ include file="/layouts/Nav.jsp"%>
		<!-- 파라미터 받기(액션태그) -->
		
    <jsp:useBean id="voteDTO2" class="DBPKG.VoteDTO" scope="request"/>
    <jsp:setProperty name="voteDTO2" property="*"/>

		<main>
			<h2>투표검수조회</h2>
			<table>
				<tr>
					<th>성명</th>
					<th>생년월일</th>
					<th>나이</th>
					<th>성별</th>
					<th>후보번호</th>
					<th>투표시간</th>
					<th>유권자확인</th>
				</tr>
				<tr>
					<td><%=voteDTO2.getV_name() %></td>
					<%
						String jyear = voteDTO2.getV_jumin().substring(0, 2);
						String jmonth = voteDTO2.getV_jumin().substring(4, 6);
						String jday = voteDTO2.getV_jumin().substring(6, 8);
						out.print("<td>19" + jyear + "년" + jmonth + "월" + jday + "일생</td>");
					%>
					<%
						int year = Integer.parseInt(voteDTO2.getV_jumin().substring(0,2));
						int age = 120 - year;
						out.println("<td>만 " + age + "세</td>");
					%>
					<%
						char gender = voteDTO2.getV_jumin().charAt(6);
						if(gender % 2 == 0){
							out.print("<td>여자</td>");
						}else{
							out.print("<td>남자</td>");
						}
					%>
					<td><%=voteDTO2.getM_no() %></td>
					<%
						String front = voteDTO2.getV_time().substring(0, 2);
						String back = voteDTO2.getV_time().substring(2);
						out.print("<td>" + front + ":" + back + "</td>");
					%>
					<%
						String a = voteDTO2.getV_confirm();
						if(a == "Y"){
							out.print("<td>확인</td>");
						}else{
							out.print("<td>미확인</td>");
						}
					%>
				</tr>
			</table>
				
		</main>



		<!-- 푸터 -->
		<%@ include file="/layouts/Footer.jsp"%>


		<script>
			function isValid() {
				// form 요소 찾기
				var form = document.vote_form;
				// 유효성 검사
				if (form.v_jumin.value === "") {
					alert("주민번호가 입력되지 않았습니다!")
					return;
				}
				if(form.v_confirm.value===""){
					alert("유권자 확인이 선택되지 않았습니다")
					return;
				}
				// submit 처리
				form.submit();
			}
		</script>
	</div>

</body>
</html>