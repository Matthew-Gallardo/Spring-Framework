package org.acumen.training.codes.services;

import java.util.List;
import java.util.stream.Collectors;

public class UserDao {

	private List<User> users;

	public UserDao(List<User> users) {
		this.users = users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public List<String> getNames() {
		return users.stream().map((u) -> u.getName()).sorted()
				.collect(Collectors.toList());
	}

	
	
}