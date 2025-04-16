package Controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;

public class BookCreateController implements SubController{
	private HttpServletRequest req;
	private HttpServletResponse resp;
	

	public BookCreateController() throws Exception{

	}
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookCreateController execute..");
		

		try {
			String uri = req.getMethod();
			
			if(uri.equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
				return ;
			}
			
			String bookCode = req.getParameter("bookCode");
			String bookName = req.getParameter("bookName");
			String publisher = req.getParameter("publisher");
			String isbn = req.getParameter("isbn");
			
			BookDto bookDto = new BookDto(bookCode, bookName, publisher, isbn);
			
			if(!isValid (bookDto)) {
				req.getRequestDispatcher("WEB-INF/view/book/error.jsp").forward(req,resp);	
			
			}
			
			
			
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}

	}

	private boolean isValid(BookDto bookDto) {

		if(bookDto.getBookCode() == null) {
			req.setAttribute("bookCode", "bookCode 입력하세요");
			return false;
		}
		if(bookDto.getBookName() == null) {
			req.setAttribute("bookName", "bookName 입력하세요");
			return false;
		}
		if(bookDto.getPublisher() == null) {
			req.setAttribute("publisher", "Publisher 입력하세요");
			return false;
		}
		if(bookDto.getIsbn() == null) {
			req.setAttribute("isbn", "isbn 입력하세요");
			return false;
		}
		
		if(
			bookDto.getBookCode() == null ||
			bookDto.getBookName() == null ||
			bookDto.getPublisher() == null ||
			bookDto.getIsbn() == null 
		) {
			return false;
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
