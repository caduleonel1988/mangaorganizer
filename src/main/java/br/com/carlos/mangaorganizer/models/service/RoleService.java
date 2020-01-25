package br.com.carlos.mangaorganizer.models.service;

import java.util.List;

import br.com.carlos.mangaorganizer.models.Role;

public interface RoleService {
	
	void add(Role role);
	List<Role> getRoles();

}
