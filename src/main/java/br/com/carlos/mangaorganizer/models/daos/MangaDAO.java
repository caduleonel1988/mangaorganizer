package br.com.carlos.mangaorganizer.models.daos;

import java.util.List;

import br.com.carlos.mangaorganizer.models.Manga;

public interface MangaDAO {
	
	void modify(Manga manga);
	void add(Manga manga);
	void remove(Integer id);
	Manga find(Integer id);
	List<Manga> getMangas();
	

}
