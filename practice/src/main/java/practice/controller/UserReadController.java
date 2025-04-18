package practice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserReadController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get 요청 받으면 페이지를 이동한다 >> login.jsp 페이지로
		req.getRequestDispatcher("WEB-INF/view/user/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post 요청 받으면 기존 값과 입력된 값 비교해서 유효한지 체크
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(!username.equals("admin") || !password.equals("1234")) {
			req.getRequestDispatcher("WEB-INF/view/user/login.jsp").forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}
	}
}
