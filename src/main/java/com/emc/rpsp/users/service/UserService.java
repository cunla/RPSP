package com.emc.rpsp.users.service;

import com.emc.rpsp.domain.User;
import com.emc.rpsp.login.domain.CurrentUser;

import java.util.List;

public interface UserService {

	public List<User> findUsers();

	public CurrentUser findCurrentUser();

	public User findUser(Long id);

	public User findUserByLogin(String login);

	public User createUser(User user);

	public User updateUser(User user);

	public void deleteUser(Long id);

}
