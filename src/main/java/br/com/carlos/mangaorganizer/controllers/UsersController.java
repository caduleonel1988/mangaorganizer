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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.carlos.mangaorganizer.models.User;
import br.com.carlos.mangaorganizer.models.UserAccount;
import br.com.carlos.mangaorganizer.models.daos.RoleDAO;
import br.com.carlos.mangaorganizer.models.daos.UserDAO;
import br.com.carlos.mangaorganizer.validations.UserValidation;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@RequestMapping(value = "/users")
public class UsersController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserValidation());
	}

	// Action para o Formulario de Cadastro de Usuários.
	@RequestMapping(value = "/form")
	public ModelAndView form(User user) {
		ModelAndView modelAndView = new ModelAndView("users/form");
		modelAndView.addObject("roleList", roleDAO.getRoles());
		
		return modelAndView;
	}

	// Action para Adicionar Usuario
	@CacheEvict(value = "users", allEntries = true)
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
			if (result.hasErrors()) {
				return form(user);
			}
		
			UserAccount userAccount = new UserAccount(user);
			user.setAccount(userAccount);
			userDAO.add(user);
			redirectAttributes.addFlashAttribute("message", "Usuário Cadastrado com Sucesso!");
		
		return new ModelAndView("redirect:/users");
	}

	// Action para Listar Usuários
	@Cacheable(value = "users")
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("users/list");
		List<User> users = userDAO.getUsers();
		modelAndView.addObject("users", users);
		
		return modelAndView;
	}

	// Action para Remover Usuários
	@CacheEvict(value = "users", allEntries = true)
	@RequestMapping(value = "/removeUser")
	public String remove(String email) {
		userDAO.remove(email);
		
		return "redirect:/users";
	}

	@RequestMapping(value = "/detail/")
	public ModelAndView detail(String email, User user) {
		ModelAndView modelAndView = new ModelAndView("forward:/accounts/detail");
		
		return modelAndView;
	}
	
	

}
