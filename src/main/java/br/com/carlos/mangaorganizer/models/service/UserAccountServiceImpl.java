package br.com.carlos.mangaorganizer.models.service;

import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.carlos.mangaorganizer.models.User;
import br.com.carlos.mangaorganizer.models.UserAccount;
import br.com.carlos.mangaorganizer.models.UserManga;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	/**
	 * Metodo auxiliar utilizado para trazer um Set de mangas do usuario
	 * @param user
	 * @return Set<UserMangas>
	 */
	@Override
	@Cacheable(value = "userMangas")
	public Set<UserManga> getUserMangas(User user) {
		return user.getAccount().getMangas();
	}

	@Override
	public UserAccount getUserAccount(User user) {
		UserAccount userAccount = user.getSessionUser().getAccount();
		
		return userAccount;
	}

}
