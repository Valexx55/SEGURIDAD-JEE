

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletError
 */
@WebServlet("/ServletError")
public class ServletError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletError() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/**
		TODO OBTENER LOS DETALLES DE LA EXEPCIÓN
		 */
		//1 registrar
		
		Throwable tw = (Throwable)request.getAttribute("javax.servlet.error.exception");
		Integer code_error = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String servlet = (String)request.getAttribute("javax.servlet.error.servlet_name");
		String uri = (String) request.getAttribute("javax.servlet.error.request_uri");
		
		//2 redirigir a la página de error genérica
		response.sendRedirect("error.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
