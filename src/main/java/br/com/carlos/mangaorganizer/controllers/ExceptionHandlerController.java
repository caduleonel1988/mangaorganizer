package br.com.carlos.mangaorganizer.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception exception) {
		ModelAndView modelAndView = new ModelAndView("error");
		exception.printStackTrace();
		
		return modelAndView;
	}

//	Configuração para quando eu tiver tempo para procurar como tratar este erro 404 programaticamente, por hora 
//	fica no web.xml
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	@ExceptionHandler(NoHandlerFoundException.class)
//	public ModelAndView error404Handler(HttpServletRequest request,NoHandlerFoundException exception) {
//		ModelAndView modelAndView = new ModelAndView("error");
//		exception.printStackTrace();
//		
//		return modelAndView;
//	}
	
}
