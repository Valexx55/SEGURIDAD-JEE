

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DameRegion
 */
@WebServlet("/DameRegion")
public class DameRegion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DameRegion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public String getRegionFromBd(String param) {
		String nreg = "";
		Connection conexion = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "password");
			st = conexion.createStatement();
			String consulta = "SELECT REGION_NAME FROM REGIONS WHERE REGION_NAME = '" + param+"'";
			System.out.println(consulta);
			rs = st.executeQuery(consulta);
			while (rs.next()) {
				nreg = nreg + rs.getString("REGION_NAME");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR AL ACCEDER A LAS REGIONES");

		} finally {
			try {
				if (rs!= null)rs.close();
				st.close();
				conexion.close();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ERROR AL LIBERAR RECURSOS");
			}
		}

		return nreg;
	}
    
    
    public String getRegionFromBdSt (String param) throws Exception{
		String nreg = "";
		Connection conexion = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "password");
			
			String consulta = "SELECT REGION_NAME FROM REGIONS WHERE REGION_NAME = ?";
			st = conexion.prepareStatement(consulta);
			st.setString(1, param);
			System.out.println(consulta);
			rs = st.executeQuery();
			while (rs.next()) {
				nreg = nreg + rs.getString("REGION_NAME");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR AL ACCEDER A LAS REGIONES");
			throw e;

		} finally {
			try {
				if (rs!= null)rs.close();
				st.close();
				conexion.close();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ERROR AL LIBERAR RECURSOS");
			}
		}

		return nreg;
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		throw new ServletException();
		/*String idregion = request.getParameter("idregion");
		String dato_region;
		try {
			dato_region = getRegionFromBdSt(idregion);
			request.setAttribute("region", dato_region);
			request.getRequestDispatcher("region.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException();
			//e.printStackTrace();
		}*/
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
