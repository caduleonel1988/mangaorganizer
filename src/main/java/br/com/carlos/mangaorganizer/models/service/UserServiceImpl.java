package br.com.carlos.mangaorganizer.models.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlos.mangaorganizer.models.User;
import br.com.carlos.mangaorganizer.models.UserAccount;
import br.com.carlos.mangaorganizer.models.UserManga;
import br.com.carlos.mangaorganizer.models.daos.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void add(User user) {
		userDAO.add(user);
	}

	@Override
	@Transactional
	public void remove(String email) {
		userDAO.remove(email);
	}

	@Override
	@Transactional
	public void modify(User user) {
		userDAO.modify(user);
	}

	@Override
	@Transactional
	public void modifyMangaList(UserAccount account, UserManga userManga) {
		userDAO.modifyMangaList(account, userManga);
	}

	@Override
	@Transactional
	public User find(String email) {
		return userDAO.find(email);
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public void createUserAccount(User user) {
		UserAccount userAccount = new UserAccount(user);
		user.setAccount(userAccount);
	}

}
