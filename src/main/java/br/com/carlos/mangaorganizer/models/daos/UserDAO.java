package br.com.carlos.mangaorganizer.models.daos;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.carlos.mangaorganizer.models.User;
import br.com.carlos.mangaorganizer.models.UserAccount;
import br.com.carlos.mangaorganizer.models.UserManga;

public interface UserDAO extends UserDetailsService {
	
	
	void add(User user);
	void remove(String email);
	void modify(User user);
	void modify(UserAccount account, UserManga userManga);
	User find(String email);
	List<User> getAllUsers();
	List<User> getUsers(String name, Integer email);

}
