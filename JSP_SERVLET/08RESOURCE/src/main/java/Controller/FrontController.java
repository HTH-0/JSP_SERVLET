package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	private Map<String, SubController> map = new HashMap<>();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[FC] service ..");
		String endPoint = req.getRequestURI();
		System.out.println("[FC] endpoint .." + endPoint);
		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 인증(/user/*) 회원 CRUD, 로그인, 로그아웃
		map.put("/user/create", new UserCreateController());
		
		
		// 도서(/book/*) 도서 CRUD
		
		
	}
	
}
