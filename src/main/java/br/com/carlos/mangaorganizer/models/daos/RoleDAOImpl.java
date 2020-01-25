package br.com.carlos.mangaorganizer.models.daos;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.carlos.mangaorganizer.models.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void add(Role role) {
		manager.persist(role);
	}
	
	@Override
	public List<Role> getRoles() {
		try {
			return manager.createQuery("from Role", Role.class).getResultList();
		} catch (Exception e) {
			return Collections.emptyList();
		} 
	}

}
