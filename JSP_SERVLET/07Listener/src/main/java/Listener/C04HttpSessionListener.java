package Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class C04HttpSessionListener implements HttpSessionListener{
	
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("[LISTENER] C03 HTT~~ Lis ~~ created");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("[LISTENER] C03 HTT~~ Lis ~~ destroyed");
	}
}
