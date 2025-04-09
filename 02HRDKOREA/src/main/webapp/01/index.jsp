<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
}

main>h2 {
	text-align: center;
	font-size: 1.8rem;
	font-weight: 500;
}

table {
	border-collapse: collapse;
	min-width: 500px;
	min-height: 200px;
	margin: 0 auto;
}

th, td {
	border: 1px solid;
	min-width: 100px;
	min-height: 30px;
	text-align: center;
}

footer {
	height: 80px;
}
</style>

</head>
<body>

	<!-- 
	select m.m_no, m.m_name, p.p_code, m.p_school, m.m_jumin, m.m_city
	from TBL_MEMBER_202005 m
    join tbl_party_202005 p
    on m.p_code = p.p_code;
	 -->
	<%@page import="DBPKG.*,java.util.*"%>
	<%
		DBUtils dbUtils = new DBUtils();
		List<MemberDTO> list = dbUtils.func1();
	%>


	<div class="wrapper">
		<!-- 헤더 -->
		<%@ include file="/layouts/Header.jsp"%>


		<!-- 네비 -->
		<%@ include file="/layouts/Nav.jsp"%>



		<main>
			<h2>후보조회</h2>
			<table>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>소속정당</th>
					<th>학력</th>
					<th>주민번호</th>
					<th>지역구</th>
					<th>대표전화</th>
				</tr>
				<%
	

						for (MemberDTO dto : list) {
				%>
				<tr>
					<th><%=dto.getM_no()%></th>
					<th><%=dto.getM_name()%></th>
					<th><%=dto.getP_name()%></th>
					<%
					String school = dto.getP_school();
					switch (school) {
					case "1":
						out.print("<td>고졸</td>");
						break;
					case "2":
						out.print("<td>학사</td>");
						break;
					case "3":
						out.print("<td>석사</td>");
						break;
					case "4":
						out.print("<td>박사</td>");
						break;
					}
					%>
					<%
					String jumin = dto.getM_jumin();
					String front = jumin.substring(0, 6); 
					String back = jumin.substring(5); 
					%>
					<td><%=front + "-" + back%></td>
					<th><%=dto.getM_city()%></th>
					<th><%=dto.getP_tel1() + "-" + dto.getP_tel2() + "-" + dto.getP_tel3()%></th>

				</tr>
				<%
				}
				%>
			</table>
		</main>



		<!-- 푸터 -->
		<%@ include file="/layouts/Footer.jsp"%>

	</div>

</body>
</html>