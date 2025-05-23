package Controller.book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Service.BookServiceImpl;

public class BookUpdateController implements SubController {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private BookServiceImpl bookService;

	public BookUpdateController() throws Exception {
		this.bookService = BookServiceImpl.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookUpdateController execute..");

		try {
			// 파라미터
			String bookCode = req.getParameter("bookCode");

			BookDto bookDto = null;

			// 유효성
			if (!isValid(bookDto)) {
				req.getRequestDispatcher("/WEB-INF/view/book/read.jsp?bookCode=" + bookCode).forward(req, resp);
			}

			// 서비스
			Map<String, Object> serviceResponse = bookService.modifyBook(bookDto);

			// 뷰
			resp.sendRedirect(req.getContextPath() + "/book/list");

		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			} catch (Exception e2) {
			}
		}

	}

	private boolean isValid(BookDto bookDto) {
		if (true) {
			;
		}
		return true;
	}

	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
	
}
