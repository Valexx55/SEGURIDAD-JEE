package com.auth0.example.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

@SuppressWarnings("unused")
@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

   private boolean tokenValido (String token)
   {
	  boolean token_ok = true;
	  
	  try{
		  	//1 acceder a la clave pública
		  	JwkProvider provider = new UrlJwkProvider ("https://ibertech.eu.auth0.com/.well-known/jwks.json");
		  	Jwk clave = provider.get("ODhFNjY5NEVBRTBEMTA0NzBFMDMxQjRGQjZGNjdBRUI3MEJCNUM5Nw");
		  	RSAPublicKey public_key = (RSAPublicKey) clave.getPublicKey();
		  	
		  	System.out.println("Clave publica RSA =" + public_key.toString());
		  	
		  	//2 verificar
		  	Algorithm algoritmo = Algorithm.RSA256(public_key, null);
		  	JWTVerifier verifier = JWT.require(algoritmo).withIssuer("https://ibertech.eu.auth0.com/").build();
		  	DecodedJWT jwt_dec = verifier.verify(token);
		  	System.out.println("MENSAJE DECODE " + jwt_dec.toString());
		  	System.out.println("AUDIENCIA " +jwt_dec.getAudience());
		
		  
	  }catch (Exception e) {	
		// TODO: handle exception
		  e.printStackTrace();
		  token_ok = false;
	}
	  	
	  
	  return token_ok;
   }
    
    @RequestMapping(value = "/portal/home", method = RequestMethod.GET)
    protected String home(final Map<String, Object> model, final Principal principal) {
    	
        logger.info("Home page");
        
        if (principal == null) {
            return "redirect:/logout";
        }
        
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        String token = (String) auth.getCredentials();
        
        if (tokenValido (token))
        {
        	System.out.println("TOKEN OK! - FIRMA verificada");
        } else {
        	System.out.println("TOKEN KO! - FIRMA FALSA");
        }
        model.put("userId", principal);
        return "home";
    }

}
