package org.springframework.security.samples.servletapi.mvc;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class EscuchaSesiones
 *
 */
@WebListener
public class EscuchaSesiones implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public EscuchaSesiones() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("Sesi�n Creada");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("Sesi�n destru�da");
    }
	
}
