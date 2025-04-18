package practice.service;

import practice.dao.UserDao;
import practice.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public void register(String username, String password) {
		User user = new User(username, password);
		userDao.save(user);
	}
}
