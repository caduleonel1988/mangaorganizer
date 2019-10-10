package br.com.carlos.mangaorganizer.models.daos;

import java.util.List;

import br.com.carlos.mangaorganizer.models.UserManga;

public interface UserMangaDAO {
	
	void modify(UserManga userManga);
	void add(UserManga userManga);
	void remove(Integer id);
	UserManga find(Integer id);
	List<UserManga> getAllUserMangas();
	

}
