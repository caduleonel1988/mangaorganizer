package br.com.carlos.mangaorganizer.models.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlos.mangaorganizer.models.Manga;
import br.com.carlos.mangaorganizer.models.UserManga;
import br.com.carlos.mangaorganizer.models.daos.MangaDAO;
import br.com.carlos.mangaorganizer.models.daos.UserMangaDAO;

@Service
public class UserMangaServiceImpl implements UserMangaService {
	
	@Autowired
	private UserMangaDAO userMangaDAO;
	
	@Autowired
	private MangaDAO mangaDAO;
	
	@Override
	@Transactional
	public void modify(UserManga userManga) {
		userMangaDAO.modify(userManga);
	}

	@Override
	@Transactional
	public void add(UserManga userManga) {
		userMangaDAO.add(userManga);
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		userMangaDAO.remove(id);
	}

	@Override
	@Transactional
	public UserManga find(Integer id) {
		return userMangaDAO.find(id);
	}

	
	/**
	 * Metodo para criar um manga do usuário, pois este manga de usuario tem alguns detalhes a mais como ultimo 
	 * capitulo lido pelo usuario (setado manualmente pelo proprio usuario) e notas.
	 * @param id User id
	 * @return UserManga
	 */
	@Override
	@Transactional
	public UserManga createUserManga(Integer id) {
		Manga manga = mangaDAO.find(id);
		UserManga userManga = new UserManga(manga); 
		
		return userManga;
	}

}
