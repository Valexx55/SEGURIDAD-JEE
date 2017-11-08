package org.springframework.security.samples.servletapi.mvc;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.HtmlUtils;

/**
 * Servlet Filter implementation class MiFiltroXXS
 */
@WebFilter("/publica")
public class MiFiltroXXS implements Filter {

    /**
     * Default constructor. 
     */
    public MiFiltroXXS() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	private boolean esHtml (String comentario)
	{
		boolean isHtml = false;
		
			String comentario_escapado = HtmlUtils.htmlEscape(comentario);
			if (!comentario_escapado.equals(comentario))
			{
				isHtml = true;
			}
		
		return isHtml;
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		if (esHtml (request.getParameter("comentario")))
				{
			//le mando de vuelta
			HttpServletResponse hsr = (HttpServletResponse)response;
				hsr.sendRedirect("comentar");
				}
		else {
			//le dejo pasar
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
