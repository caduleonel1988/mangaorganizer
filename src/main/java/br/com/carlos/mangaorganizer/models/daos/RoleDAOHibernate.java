package br.com.carlos.mangaorganizer.models.daos;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.carlos.mangaorganizer.models.Role;

@Repository
@Transactional
public class RoleDAOHibernate implements RoleDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void add(Role role) {
		manager.persist(role);
	}
	
	@Override
	public List<Role> getAllRoles() {
		try {
			return manager.createQuery("from Role", Role.class).getResultList();
		} catch (Exception e) {
			return Collections.emptyList();
		} 
	}

}
