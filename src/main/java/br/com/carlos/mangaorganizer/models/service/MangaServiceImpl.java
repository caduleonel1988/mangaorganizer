package br.com.carlos.mangaorganizer.models.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlos.mangaorganizer.models.Manga;
import br.com.carlos.mangaorganizer.models.daos.MangaDAO;

@Service
public class MangaServiceImpl implements MangaService {
	
	@Autowired
	private MangaDAO mangaDAO;

	@Override
	@Transactional
	public void modify(Manga manga) {
		mangaDAO.modify(manga);
	}

	@Override
	@Transactional
	public void add(Manga manga) {
		mangaDAO.add(manga);
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		mangaDAO.remove(id);
	}

	@Override
	@Transactional
	public Manga find(Integer id) {
		return mangaDAO.find(id);
	}

	@Override
	@Transactional
	public List<Manga> getMangas() {
		return mangaDAO.getMangas();
	}

}
