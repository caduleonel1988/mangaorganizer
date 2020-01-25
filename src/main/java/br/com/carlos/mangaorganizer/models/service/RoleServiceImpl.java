package br.com.carlos.mangaorganizer.models.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.carlos.mangaorganizer.models.Role;
import br.com.carlos.mangaorganizer.models.daos.RoleDAO;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleDAO roleDAO;
	
	@Override
	@Transactional
	public void add(Role role) {
		roleDAO.add(role);
	}

	@Override
	@Transactional
	public List<Role> getRoles() {
		return roleDAO.getRoles();
	}

}
