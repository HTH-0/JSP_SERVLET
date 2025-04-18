<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="create" method="post">
		<label >아이디 : <input type="text" name="username" /></label> <br />
		<label >비밀번호 : <input type="text" name="password" /></label> <br />
		<button type="submit">가입하기</button>
	</form>

</body>
</html>