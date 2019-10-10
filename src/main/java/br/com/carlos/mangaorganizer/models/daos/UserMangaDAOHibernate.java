package br.com.carlos.mangaorganizer.models.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.carlos.mangaorganizer.models.UserManga;

@Transactional
@Repository
public class UserMangaDAOHibernate implements UserMangaDAO {
	
	@PersistenceContext
	private EntityManager manager;  

	@Override
	public void add(UserManga userManga) {
		manager.persist(userManga);
	}

	public void remove(Integer id) {
		UserManga userManga = manager.find(UserManga.class, id);
		manager.remove(userManga);
	}

	@Override
	public UserManga find(Integer id) {
		return manager.createQuery("select distinct (m) from UserManga m where m.id = :id", UserManga.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public void modify(UserManga userManga) {
		UserManga mangaToPersist = find(userManga.getId());
		mangaToPersist.setLastChapter(userManga.getLastChapter());
		mangaToPersist.setNotes(userManga.getNotes());
		manager.persist(mangaToPersist);
	}

	@Override
	public List<UserManga> getAllUserMangas() {
		// TODO Auto-generated method stub
		return null;
	}

}
