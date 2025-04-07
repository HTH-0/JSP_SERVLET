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



		<main>
			<h2>03폴더</h2>
		</main>
		
		
		
		<!-- 푸터 -->
		<%@ include file="/layouts/Footer.jsp"%>

	</div>

</body>
</html>