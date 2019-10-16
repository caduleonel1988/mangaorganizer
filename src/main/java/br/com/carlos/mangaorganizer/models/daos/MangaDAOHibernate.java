package br.com.carlos.mangaorganizer.models.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.carlos.mangaorganizer.models.Manga;

@Transactional
@Repository
public class MangaDAOHibernate implements MangaDAO {
	
	@PersistenceContext
	private EntityManager manager;  

	@Override
	public void modify(Manga manga) {
		manager.merge(manga);
	}

	@Override
	public void add(Manga manga) {
		manager.persist(manga);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Manga find(Integer id) {
		return manager.createQuery("select distinct (m) from Manga m where m.id = :id", Manga.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public List<Manga> getMangas() {
		return manager.createQuery("from Manga", Manga.class).getResultList() ;
	}

}
