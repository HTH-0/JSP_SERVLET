<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String email = request.getParameter("email");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String password2 = request.getParameter("password2");

	// 유효성 검사
	
	// 이메일 확인
	if(!email.equals("test@gmail.com")){
		request.setAttribute("email_msg", "유효한 이메일을 작성해주세요");
		request.getRequestDispatcher("./join_form.jsp").forward(request, response);
	}
	// ID 확인
	if(!username.equals("admin")){
		request.setAttribute("username_msg", "유효한 아이디를 작성해주세요");
		request.getRequestDispatcher("./join_form.jsp").forward(request, response);
	}
	// 비밀번호 확인
	if(!password.equals("1234")){
		request.setAttribute("password_msg", "유효한 비밀번호를 작성해주세요");
		request.getRequestDispatcher("./join_form.jsp").forward(request, response);
	}
	// 비밀번호 재확인
	if(!password2.equals("1234")){
		request.setAttribute("password2_msg", "유효한 비밀번호를 작성해주세요");
		request.getRequestDispatcher("./join_form.jsp").forward(request, response);
	}
	
	
	// 사용자 상태 정보를 Session에 저장
	session.setAttribute("isAuth", true);
	session.setAttribute("role",);


%>