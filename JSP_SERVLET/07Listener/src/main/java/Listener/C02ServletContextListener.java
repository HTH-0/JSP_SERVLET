package Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class C02ServletContextListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("[LISTENER] ");
	}
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("[LISTENER] ");
		
	}
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		
		System.out.println("[LISTENER] ");
	}
	
}
