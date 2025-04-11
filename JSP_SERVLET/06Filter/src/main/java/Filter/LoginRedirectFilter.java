package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginRedirectFilter implements Filter{
	// login.do
	// 로그인 성공 시 redirect 경로를 role 별로 
	// Role_ADMIN >> /admin_main 으로 리다이렉트
	// Role_MANAGER >> /manager_main 으로 리다이렉트
	// Role_USER >> /user_main 으로 리다이렉트
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
	
		HttpSession session = request.getSession();
		
		String myRole = (String)session.getAttribute("role");
		if(myRole==null) {
			response.sendRedirect(request.getContextPath()+"/login.do?msg=not authenticated...");
			return ;
		}
		
		switch(myRole) {
		case "ROLE_ADMIN":
			response.sendRedirect(request.getContextPath() + "/admin_main");
			return;
		case "ROLE_MANAGER":
			response.sendRedirect(request.getContextPath() + "/manager_main");
			return;
		case "ROLE_USER":
			response.sendRedirect(request.getContextPath() + "/user_main");
			return;
			
		default:
			response.sendRedirect(request.getContextPath() + "/login.do?msg=invalid role");
			return;
		}
		
		
	}
	
}
