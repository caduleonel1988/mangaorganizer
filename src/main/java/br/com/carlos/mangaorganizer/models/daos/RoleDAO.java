package br.com.carlos.mangaorganizer.models.daos;

import java.util.List;

import br.com.carlos.mangaorganizer.models.Role;

public interface RoleDAO {

	void add(Role role);
	//void remove(Integer id); 
	List<Role> getRoles();

	/*
	 * void modify(Role role);
	 * Role find(Integer id); 
	 * List<Role> getAllRoles();
	 */
}