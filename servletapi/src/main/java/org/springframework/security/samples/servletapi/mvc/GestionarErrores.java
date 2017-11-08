package org.springframework.security.samples.servletapi.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = { "org.springframework.security.samples.servletapi.mvc" })
public class GestionarErrores {

	@ExceptionHandler(Throwable.class)
	public String errores(Exception e) {
		e.printStackTrace();
		return "error";
	}

}
