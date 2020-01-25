package br.com.carlos.mangaorganizer.models.service;

import java.util.List;

import br.com.carlos.mangaorganizer.models.User;
import br.com.carlos.mangaorganizer.models.UserAccount;
import br.com.carlos.mangaorganizer.models.UserManga;

public interface UserService {
	
	void add(User user);
	void remove(String email);
	void modify(User user);
	void modifyMangaList(UserAccount account, UserManga userManga);
	User find(String email);
	List<User> getUsers();
	void createUserAccount(User user);

}
