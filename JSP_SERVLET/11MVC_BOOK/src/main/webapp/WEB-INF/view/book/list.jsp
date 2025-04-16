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
			<h1>/BOOK/LIST</h1>
			<!-- 게시물 필터 처리(전체/이름/출판사/ISBN) -->
			<section>
				<div>
					PAGE : <span></span> / <span>100</span> (현재페이지 / 전체페이지)
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>도서코드</th>
							<th>도서명</th>
							<th>출판사</th>
							<th>ISBN</th>
						</tr>
					</thead>
					
					<tbody>
					
					</tbody>
					
					<tfoot>
						<tr>
							<td colspan=3></td>
						</tr>
					</tfoot>
				</table>
			</section>
			<!-- 게시물 표시 -->
			<section>
			
			</section>

			Page : 1 / 100 page
			
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>







