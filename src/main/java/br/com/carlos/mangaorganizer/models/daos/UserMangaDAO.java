package br.com.carlos.mangaorganizer.models.daos;

import br.com.carlos.mangaorganizer.models.UserManga;

public interface UserMangaDAO {
	
	void modify(UserManga userManga);
	void add(UserManga userManga);
	void remove(Integer id);
	UserManga find(Integer id);
	

}
