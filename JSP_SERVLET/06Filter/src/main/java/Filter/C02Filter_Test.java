package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/main.do")
public class C02Filter_Test implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//REQUEST 전 처리코드
		System.out.println("[FILTER] MAIN FILTER  START...");
		
		chain.doFilter(req, resp);
		
		//RESPONSE 후 처리코드
		System.out.println("[FILTER] MAIN FILTER END...");	
	}

}
