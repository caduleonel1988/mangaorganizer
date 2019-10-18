package br.com.carlos.mangaorganizer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.carlos.mangaorganizer.models.Role;
import br.com.carlos.mangaorganizer.models.daos.RoleDAO;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@RequestMapping(value = "/roles")
public class RolesController {

	@Autowired
	private RoleDAO roleDAO;

	// Action Action para o Formulario Cadastro de Roles
	@RequestMapping(value = "/form")
	public ModelAndView form(Role role) {
		return new ModelAndView("roles/form");
	}

	// Action para Adicionar Roles
	@RequestMapping(method = RequestMethod.POST)
	public String add(Role role, RedirectAttributes redirectAttributes) {
		roleDAO.add(role);
		redirectAttributes.addFlashAttribute("message", "Role Cadastrada com Sucesso!");
		return "redirect:/roles";
	}

	// Action para Listar Roles
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("roles/list");
		modelAndView.addObject("roles", roleDAO.getRoles());
		return modelAndView;
	}
	
	//Verificar depois pois vou utilizar algo parecido para o detalhe de usuarios, ou alteração de usuarios.
	/*@RequestMapping(value = "/detalhe/{id}")
	public ModelAndView detail(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("products/detail");
		Product product = productDAO.find(id);
		modelAndView.addObject("product", product);
		
		return modelAndView;
		
	}*/

}
