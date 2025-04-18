package practice.dao;

import java.util.ArrayList;
import java.util.List;

import practice.domain.User;

public class UserDao {
	private static List<User> users = new ArrayList<>();

	public void save(User user) {
		users.add(user);
		System.out.println("User saved : " + user.getUsername());
	}

	public List<User> findAll() {
		return users;
	}

}
