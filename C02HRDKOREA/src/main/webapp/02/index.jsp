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
	min-width: 200px;
	height: 40px;
}

td {
	border: 1px solid;
	min-width: 400px;
	height: 40px;
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


		<main>
			<h2>투표하기</h2>
			<form name="vote_form" action="./Create.jsp" method="post"
				onsubmit="return false">
				<table>
					<tr>
						<th>주민번호</th>
						<td><input type="text" name="v_jumin" /></td>
					</tr>
					<tr>
						<th>성명</th>
						<td><input type="text" name="v_name" /></td>
					</tr>
					<tr>
						<th>투표번호</th>
						<td><input type="text" name="m_no" /></td>
					</tr>
					<tr>
						<th>투표시간</th>
						<td><input type="text" name="v_time" /></td>
					</tr>
					<tr>
						<th>투표장소</th>
						<td><input type="text" name="v_area" /></td>
					</tr>
					<tr>
						<th>유권자확인</th>
						<td>
						<input type="radio" name="v_confirm" value="Y" />확인
						<input type="radio" name="v_confirm" value="N"/>미확인
						</td>
					</tr>
					<tr>
						<td colspan="2" class="button">
							<button type="submit" onclick="isValid()">투표하기</button>
							<button type="reset">다시하기</button>
						</td>
					</tr>


				</table>
			</form>

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