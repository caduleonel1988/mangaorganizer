package br.com.carlos.mangaorganizer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaController {

	
	@RequestMapping(value= "/ola")
	public String ola() {
		return "user/ola";
		
	}
}
