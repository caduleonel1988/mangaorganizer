package br.com.carlos.mangaorganizer.controllers;

import java.util.Set;

import javax.transaction.Transactional;
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

import br.com.carlos.mangaorganizer.models.Manga;
import br.com.carlos.mangaorganizer.models.User;
import br.com.carlos.mangaorganizer.models.UserAccount;
import br.com.carlos.mangaorganizer.models.UserManga;
import br.com.carlos.mangaorganizer.models.daos.MangaDAO;
import br.com.carlos.mangaorganizer.models.daos.UserDAO;
import br.com.carlos.mangaorganizer.models.daos.UserMangaDAO;
import br.com.carlos.mangaorganizer.validations.UserValidation;

@Transactional
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@RequestMapping(value = "/accounts")
public class UserAccountsController {
	
	@Autowired	
	private UserDAO userDAO;

	@Autowired
	private MangaDAO mangaDAO;
	
	@Autowired
	private UserMangaDAO userMangaDAO;
	
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
		user = userDAO.find(email);
		modelAndView.addObject("user", user);
		modelAndView.addObject("mangas", getUserMangas(user));

		return modelAndView;
	}
	
	/**
	 * Metodo auxiliar utilizado para trazer um Set de mangas do usuario
	 * @param user
	 * @return Set<UserMangas>
	 */
	@Cacheable(value = "userMangas")
	private Set<UserManga> getUserMangas(User user) {
		return user.getAccount().getMangas();
	}
	
	@RequestMapping(value = "/manga/add", method = RequestMethod.POST)
	public ModelAndView addManga(Integer mangaId, User user) {
		ModelAndView modelAndView = new ModelAndView("redirect:/accounts/detail/{email}") ;
		UserManga userManga = createUserManga(mangaId);
		userMangaDAO.add(userManga);

		user = user.getSessionUser();
		UserAccount userAccount = user.getAccount();
		userDAO.modifyMangaList(userAccount, userManga);
		
		modelAndView.addObject("email", user.getEmail());
		return modelAndView;
		
	}

	/**
	 * Metodo para criar um manga do usuário, pois este manga de usuario tem alguns detalhes a mais como ultimo 
	 * capitulo lido pelo usuario (setado manualmente pelo proprio usuario) e notas.
	 * @param id User id
	 * @return UserManga
	 */
	private UserManga createUserManga(Integer id) {
		Manga manga = mangaDAO.find(id);
		UserManga userManga = new UserManga(manga); 
		
		return userManga;
	}
	
	/**
	 * Metodo para modificar a conta do usuario
	 * @param user usuario a ser validado
	 * @param result result binding com os possiveis erros de validação
	 * @return modelAndView
	 */
	@CacheEvict(value = "users", allEntries = true)
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public ModelAndView modifyAccount(@Valid User user, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("redirect:/users");
		if (result.hasErrors()) {
			return detail(user.getEmail(), user);
		}
		userDAO.modify(user);
		
		return modelAndView;
	}

}
