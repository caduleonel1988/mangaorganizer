package br.com.carlos.mangaorganizer.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.carlos.mangaorganizer.models.Manga;
import br.com.carlos.mangaorganizer.models.Status;
import br.com.carlos.mangaorganizer.models.daos.MangaDAO;
import br.com.carlos.mangaorganizer.validations.MangaValidation;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@RequestMapping(value = "/mangas")
public class MangasController {

	@Autowired
	private MangaDAO mangaDAO;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new MangaValidation());
	}

	@RequestMapping(value = "/form")
	public ModelAndView form(Manga manga) {
		ModelAndView modelAndView = new ModelAndView("mangas/form");
		modelAndView.addObject("mangaStatus", Status.values());

		return modelAndView;
	}

	@CacheEvict(value = "mangasList", allEntries = true)
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(@Valid Manga manga, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return form(manga);
		}
		mangaDAO.add(manga);
		redirectAttributes.addFlashAttribute("message", "Manga Cadastrado Com Sucesso");

		return new ModelAndView("redirect:/mangas");
	}

	@Cacheable(value = "mangasList")
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("mangas/list");
		List<Manga> mangas = mangaDAO.getMangas();
		modelAndView.addObject("mangas", mangas);

		return modelAndView;
	}
	
	@RequestMapping(value = "detail/{id}")
	public ModelAndView detail(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("mangas/detail");
		Manga manga = mangaDAO.find(id);
		modelAndView.addObject("manga", manga);
		modelAndView.addObject("mangaStatus", Status.values());
		
		return modelAndView;
	}
	
	@CacheEvict(value = "mangasList", allEntries = true)
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modifyManga(@Valid Manga manga, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("redirect:/mangas");
		if (result.hasErrors()) {
			return detail(manga.getId());
		}
		mangaDAO.modify(manga);
		
		return modelAndView;
	}
}
