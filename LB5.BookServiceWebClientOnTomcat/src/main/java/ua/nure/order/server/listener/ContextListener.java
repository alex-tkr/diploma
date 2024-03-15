package ua.nure.order.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ua.nure.order.dao.DAOFactory;

@WebListener
public class ContextListener implements ServletContextListener {

	public static final Logger log = LoggerFactory.getLogger(ContextListener.class);
	
    @Override
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext ctx = event.getServletContext();
    	log.trace("Context initialized");
    	String selectedDao = ctx.getInitParameter("selectedDao");
    	log.debug("Get Init Parameter: selectedDao : {}",selectedDao);
		ctx.setAttribute("dao", DAOFactory.getInstance(selectedDao));
    }
	
}
