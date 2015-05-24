package com.emc.rpsp.users.service;

import java.util.List;

import com.emc.rpsp.login.domain.CurrentUser;
import com.emc.rpsp.users.domain.User;

public interface UserService {

	public List<User> findUsers();

	public CurrentUser findCurrentUser();

	public User findUser(Long id);

	public User findUserByLogin(String login);

	public User createUser(User user, Long accountId);

	public User updateUser(User user);

	public void deleteUser(Long id);
	
	public String getAdminLogin();

}
