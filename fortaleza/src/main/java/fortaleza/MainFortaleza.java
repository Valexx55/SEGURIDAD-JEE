package fortaleza;

import java.io.File;

//import org.owasp.esapi.interfaces.IAuthenticator;
import org.owasp.esapi.Authenticator;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;
import org.owasp.esapi.EncoderConstants;
import org.owasp.esapi.User;
import org.owasp.esapi.Validator;
import org.owasp.esapi.codecs.Codec;
import org.owasp.esapi.codecs.OracleCodec;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.ScanException;

import com.sun.xml.internal.ws.policy.PolicyException;

public class MainFortaleza {

	private Authenticator auth_instance;
	private Validator validator_instance;
	
	private String validaMail (String nombre) throws IntrusionException, ValidationException
	{
		String str_dev = null;
		
		//Nombre a referirse, entrada, nombre de la expresión regular, máxima longitud, permitir nulo o no
			str_dev = validator_instance.getValidInput("Mail", nombre, "Email", 100, false);
		
		return str_dev;
	}
	
	protected String escapaOracleSt (String input){
	    String cad_esc = null;
	    
	    Codec ORACLE_CODEC = new OracleCodec();
	    Encoder oe = ESAPI.encoder();
	    cad_esc = oe.encodeForSQL( ORACLE_CODEC, input);

	    return cad_esc;
	}
	
	private String genPwd ()
	{
		String nueva_pwd = null;
			
			nueva_pwd = auth_instance.generateStrongPassword();
			
		return nueva_pwd;
	}
	
	public void validateHTML(String input) {
	    try {
	        //No se admite una entrada vacía
	        if (input.isEmpty() == true) {
	            throw new IntrusionException("No se admite el campo vacío", "");
	        }
	        //Se obtiene el archivo de configuración a través del classpath
	        Policy politica = Policy.getInstance(new File ("antisamy-tinymce-1.4.4.xml")); // getInstance(Tools.class.getResource("/antisamy-tinymce-1.4.4.xml"));
	        AntiSamy validator = new AntiSamy();
	        //Antes de analizar la cadena es convertida en su forma canónica
	        //ESAPI.encoder().canonicalize(input)
	        CleanResults cr = validator.scan(ESAPI.encoder().canonicalize(input), politica);

	        //Si ha ocurrido un error se lanza una excepción indicando el error
	        if (cr.getNumberOfErrors() != 0) {
	            throw new IntrusionException("Ha introducido código HTML que no está permitido",
	                    cr.getErrorMessages().get(0).toString());
	        }
	    }  catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		MainFortaleza mf1 = new MainFortaleza();
		mf1.auth_instance = ESAPI.authenticator();
		mf1.validator_instance = ESAPI.validator();
		
		try
		{
			mf1.genPwd();
			mf1.validaMail("quemas@no.es");
			String orascp2 = mf1.escapaOracleSt("SELECT REGION_NAME FROM REGIONS WHERE REGION_NAME = '' or 1='1'");
			System.out.println(orascp2);
			mf1.validateHTML("<script>alert('PELIGRITO');</script>");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
}
