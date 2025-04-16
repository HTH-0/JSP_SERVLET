<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- link -->
	<%@include file="/resources/layouts/link.jsp" %>
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/layouts/topHeader.jsp" %>
			<!-- nav -->
			<%@include file="/resources/layouts/nav.jsp" %>
		</header>
		<main  class="layout">
			<h1>/BOOK/CREATE</h1>
			<form action="${pageContext.request.contextPath}/book/create" method="post"></form>
				<div>
					<label for="">bookCode</label> <span>${bookCode}</span> <br />
					<input type="text" name="bookCode" placeholder="bookCode"/>
				</div>
				<div>
					<label for="">bookName</label> <span>${bookName}</span> <br />
					<input type="text" name="bookName" placeholder="bookName"/>
				</div>
				<div>
					<label for="">publisher</label> <span>${publisher}</span> <br />
					<input type="text" name="publisher" placeholder="publisher"/>
				</div>
				<div>
					<label for="">isbn</label> <span>${isbn}</span> <br />
					<input type="text" name="isbn" placeholder="isbn"/>
				</div>
				<div>
					<button>도서 등록</button>
				</div>
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>







