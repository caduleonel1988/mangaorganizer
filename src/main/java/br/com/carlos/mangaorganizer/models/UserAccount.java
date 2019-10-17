package br.com.carlos.mangaorganizer.models;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class UserAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(cascade = {CascadeType.ALL ,CascadeType.REMOVE})
	@JoinColumn(name = "user_email")
	private User user;

	public UserAccount(User user) {
		this.user = user;
	}
	
	public UserAccount() {}

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL, CascadeType.REMOVE })
	@JoinColumn(name = "account_id")
	private Set<UserManga> mangas = new LinkedHashSet<>();

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public void add(UserManga userManga) {
		Set<UserManga> userMangas = new LinkedHashSet<>(mangas);
		userMangas.add(userManga);
		setMangas(userMangas);
	}

	public void remove(UserManga userManga) {
		mangas.remove(userManga);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<UserManga> getMangas() {
		return mangas;
	}

	public void setMangas(Set<UserManga> mangas) {
		this.mangas = mangas;
	}

}
