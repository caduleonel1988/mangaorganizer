package br.com.carlos.mangaorganizer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.carlos.mangaorganizer.models.User;
import br.com.carlos.mangaorganizer.models.UserManga;
import br.com.carlos.mangaorganizer.models.service.UserMangaService;

//TODO MELHORAR O CACHE POIS ELE FUNCIONA PARA EXIBIÇÃO, MAS ESTA MANTENDO O CACHE DESATUALIZADO NA HORA DA ALTERAÇÃO
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/mangas/usersManga")
public class UserMangasController {
	
	@Autowired
	private UserMangaService userMangaService;
	
	@RequestMapping(value = "/detail/{title}/{id}")
	public ModelAndView detail(@PathVariable("title") String title, @PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("/mangas/usersMangas/detail");
		UserManga userManga = userMangaService.find(id);
		modelAndView.addObject("userManga", userManga);
		
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value = "/removeUserManga", method = RequestMethod.POST) 
	public void remove(Integer id) {
		userMangaService.remove(id);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST) 
	public ModelAndView modifyUserManga(Integer id, UserManga userManga, User user) {
		ModelAndView modelAndView = new ModelAndView("redirect:/accounts/detail/{email}");
		userMangaService.modify(userManga);
		String email = user.getSessionUser().getEmail();
		
		modelAndView.addObject("email", email);
		
		return modelAndView;
	}
	
	
}
