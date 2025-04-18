<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
	<h2>로그인 페이지</h2>
	<form action="login" method="post">
		<label>아이디 : <input type="text" name="username" /> </label> <br />
		<label>비밀번호 : <input type="text" name="password" /> </label> <br />
		<button type ="submit">로그인하기</button>
	</form>
</body>
</html>