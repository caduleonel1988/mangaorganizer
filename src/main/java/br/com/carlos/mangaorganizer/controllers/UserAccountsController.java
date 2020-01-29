package br.com.carlos.mangaorganizer.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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

import br.com.carlos.mangaorganizer.models.User;
import br.com.carlos.mangaorganizer.models.UserAccount;
import br.com.carlos.mangaorganizer.models.UserManga;
import br.com.carlos.mangaorganizer.models.service.UserAccountService;
import br.com.carlos.mangaorganizer.models.service.UserMangaService;
import br.com.carlos.mangaorganizer.models.service.UserService;
import br.com.carlos.mangaorganizer.validations.UserValidation;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@RequestMapping(value = "/accounts")
public class UserAccountsController {
	
	@Autowired	
	private UserService userService;

	@Autowired
	private UserMangaService userMangaService;
	
	@Autowired
	private UserAccountService userAccountService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserValidation());
	}
	
	//TODO REFATORAR PARA COLOCAR CACHE NO DETALHE. ATENÇÃO POIS É UM METODO QUE UTILIZA A CONTA DO USUARIO E OS MANGAS DELE
	/**
	 * Metodo exibir o detalhe do usuário. O metodo é 
	 * @param email 
	 * @param user
	 * @return ModelAndView para a pagina de detalhes do usuario, contendo o usuario e seus mangas.  
	 */
	@RequestMapping(value = "/detail/{email}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("email") String email, User user) {
		ModelAndView modelAndView = new ModelAndView("users/accounts/detail");
		user = userService.find(email);
		modelAndView.addObject("user", user);
		modelAndView.addObject("mangas", userAccountService.getUserMangas(user));

		return modelAndView;
	}
	
	@RequestMapping(value = "/manga/add", method = RequestMethod.POST)
	public ModelAndView addManga(Integer mangaId, User user) {
		ModelAndView modelAndView = new ModelAndView("redirect:/accounts/detail/{email}") ;
		UserManga userManga = userMangaService.createUserManga(mangaId);
		UserAccount userAccount = userAccountService.getUserAccount(user);
		user = user.getSessionUser();
		
		userMangaService.add(userManga);

		userService.modifyMangaList(userAccount, userManga);
		
		modelAndView.addObject("email", user.getEmail());
		return modelAndView;
	}

	//TODO MELHORAR A ALTERAÇÃO DE USUARIOS, O REDIRECIONAMENTO AINDA ESTA MEIO PROCEDURAL
	/**
	 * Metodo para modificar a conta do usuario
	 * @param user usuario a ser validado
	 * @param result result binding com os possiveis erros de validação
	 * @return modelAndView
	 */
	@CacheEvict(value = "users", allEntries = true)
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public ModelAndView modifyAccount(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/accounts/detail/{email}") ;
		if (result.hasErrors()) {
			return detail(user.getEmail(), user);
		}
		
		userService.modify(user);
		redirectAttributes.addFlashAttribute("message", "Usuário Modificado com Sucesso!");
		modelAndView.addObject("email", user.getEmail());
		
		return modelAndView;
	}

}
