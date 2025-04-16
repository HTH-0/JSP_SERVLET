package Controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;

public class BookListController implements SubController{
	private HttpServletRequest req;
	private HttpServletResponse resp;
	

	public BookListController() throws Exception{

	}
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookListController execute..");
		

		try {
			String uri = req.getMethod();
			
			if(uri.equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(req, resp);
				return ;
			}
	
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}

	}

	private boolean isValid(BookDto bookDto) {

		return true;
	}
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
