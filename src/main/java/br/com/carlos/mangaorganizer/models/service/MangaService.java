package br.com.carlos.mangaorganizer.models.service;

import java.util.List;

import br.com.carlos.mangaorganizer.models.Manga;

public interface MangaService {
	
	void modify(Manga manga);
	void add(Manga manga);
	void remove(Integer id);
	Manga find(Integer id);
	List<Manga> getMangas();

}
