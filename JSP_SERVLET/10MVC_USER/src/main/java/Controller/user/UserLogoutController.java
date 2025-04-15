package Controller.user;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.UserDto;
import Domain.Service.UserServiceImpl;

public class UserLogoutController implements SubController {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	private UserServiceImpl userService;

	public UserLogoutController() throws Exception {
		userService = UserServiceImpl.getInstance();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] UserLoginController execute..");

		try {
			var session = req.getSession(false);
			
			if (session == null || session.getAttribute("isAuth") == null || !(Boolean) session.getAttribute("isAuth")) {
				req.getSession().setAttribute("message", "로그인 상태가 아닙니다");
				resp.sendRedirect(req.getContextPath() + "/user/login.do");
				return;
			}

			boolean isLogout = userService.logout(session);
			
			String message = isLogout ? "로그아웃 성공" : "로그아웃 실패";
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(req.getContextPath() + "/index.do");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				req.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(req, resp);
			} catch (Exception e1) {
			}
		}
	}

	private boolean isValid(UserDto userDto) {
		if (userDto.getUsername() == null || userDto.getUsername().length() <= 4) {
			req.setAttribute("username_err", "userid의 길이는 최소 5자이상이어야합니다");
			System.out.println("[INVALID] userid의 길이는 최소 5자이상이어야합니다");
			return false;
		}
		if (userDto.getUsername().matches("^[0-9].*")) {
			System.out.println("[INVALID] userid의 첫문자로 숫자가 들어올수 없습니다");
			req.setAttribute("username_err", "userid의 userid의 첫문자로 숫자가 들어올수 없습니다");
			return false;
		}

		return true;
	}

	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
	// FrontController -> UserLogoutController 등록 (URI : /user/logout)
	// UserLogoutController
	// - 1 파라미터받기 생략
	// - 2 session 안 속성 정보(isAuth , role , username) 꺼내오고 유효성 체크
	// - isAuth == false 라면 포워딩 /WEB-INF/login.jsp session에 message 속성 추가 "로그인상태가
	// 아닙니다"
	// UserService
	// - logout함수 내 처리
	// - session invalid 처리 하기
	// - Map<String,Object> 로 return "isLogout",true , "message","로그아웃성공"

	// UserLogoutController
	// - isLogout 정보를 확인하여 로그아웃 성공/실패 둘다 /login.do
	// - message는 session 에 저장
}
