package br.com.carlos.mangaorganizer.models.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import br.com.carlos.mangaorganizer.models.User;
import br.com.carlos.mangaorganizer.models.UserAccount;
import br.com.carlos.mangaorganizer.models.UserManga;

@Repository
@Transactional
public class UserDAOHibernate implements UserDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void add(User user) {
		hashUserPassword(user);
		manager.persist(user);
	}

	private void hashUserPassword(User user) {
		String gensalt = BCrypt.gensalt();
		String hashpw = BCrypt.hashpw(user.getPassword(), gensalt);
		user.setPassword(hashpw);
	}

	@Override
	public void remove(String email) {
		User user = manager.find(User.class, email);
		manager.remove(user);
	}

	@Override
	public List<User> getAllUsers() {
		return manager.createQuery("from User", User.class).getResultList();
	}

	@Override
	public List<User> getUsers(String name, Integer email) {
		return null;
	}

	@Override
	public User find(String email) {
		return manager.createQuery("select distinct(u) from User u "
				+ "where u.email = :email", User.class)
				.setParameter("email", (email))
		
		/*return manager.createQuery("select distinct(u) from User u "
				+ "join fetch u.roles where u.email = :pEmail", User.class)
				.setParameter("pEmail", (email))*/
				.getSingleResult();
		// usar depois o select distinct(u) from User u join fetch + "join fetch where u.email = pEmail", User.class)
	}

	
	  @Override 
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  	  return find(username); }

	@Override
	public void modify(User user) {
		user = find(user.getEmail());
		manager.merge(user);
		
	}
	
	public void modify(UserAccount account, UserManga userManga) {
		account = manager.find(UserAccount.class, account.getId());
		account.add(userManga);
		manager.merge(account);
	}
	 

}
