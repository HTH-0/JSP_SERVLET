<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JOIN FORM</h1>
	<div style="min-height: 25px; font-size: .8rem; color: orange">
		${param.message}</div>
	<form action="${pageContext.request.contextPath}/C06/03/join.jsp">
		<div>
			<label>이메일 :</label><span>${email_msg}</span> <br />
			<input type="text"  name="email"/>			
		</div>
		<div>
			<label>아이디 :</label><span>${username_msg}</span> <br />
			<input type="text"  name="username"/>		
		</div>
		<div>
			<label>비밀번호 :</label><span>${password_msg}</span> <br />
			<input type="text"  name="password"/>		
		</div>
		<div>
			<label>비밀번호 확인 :</label><span>${password2_msg}</span> <br />
			<input type="text"  name="password2"/>		
		</div>

		<div>
			<button>회원가입</button>	
		</div>


	</form>

</body>
</html>