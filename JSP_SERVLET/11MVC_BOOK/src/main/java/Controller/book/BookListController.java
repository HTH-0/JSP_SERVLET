package Controller.book;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Service.BookServiceImpl;

public class BookListController implements SubController{
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private BookServiceImpl bookService;

	public BookListController() throws Exception{
		this.bookService = BookService.getInstance();
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
			
			
			Map<String, Object> serviceResponse = bookService.getAllBooks();
			Boolean status = (Boolean)serviceResponse.get("status");
			if(status) {
				List<BookDto> list = (List<BookDto>)serviceResponse.get("list");
				req.setAttribute("list", serviceResponse);
			}else {
				
			}
			req.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(req, resp);
			
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
