package br.com.carlos.mangaorganizer.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class AuthenticationController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("login") String login,
						@RequestParam("password") String password,
						HttpSession session) {
		
		return null;
	}
}
