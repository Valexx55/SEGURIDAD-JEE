package com.auth0.example.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SuppressWarnings("unused")
@Controller
public class LogoutController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    protected String logout(final HttpServletRequest req) {
        logger.debug("Performing logout");
        invalidateSession(req);
        return "redirect:" + req.getContextPath() + "/login";
    }

    private void invalidateSession(HttpServletRequest request) {
       /* if (request.getSession() != null)
        {
            request.getSession().invalidate();
        }*/
        //si tiene una sesi�n, la invalido
        HttpSession sesion = request.getSession(false);
        if (sesion!=null)
        {
        	sesion.invalidate();
        } //else 
    }

}
