package br.com.carlos.mangaorganizer.models.service;

import java.util.Set;

import br.com.carlos.mangaorganizer.models.User;
import br.com.carlos.mangaorganizer.models.UserAccount;
import br.com.carlos.mangaorganizer.models.UserManga;

public interface UserAccountService {
	
	Set<UserManga> getUserMangas(User user);
	UserAccount getUserAccount(User user);
}
