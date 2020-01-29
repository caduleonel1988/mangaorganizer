package br.com.carlos.mangaorganizer.models.service;

import br.com.carlos.mangaorganizer.models.UserManga;

public interface UserMangaService {
	
	void modify(UserManga userManga);
	void add(UserManga userManga);
	void remove(Integer id);
	UserManga find(Integer id);
	UserManga createUserManga(Integer id);

}
