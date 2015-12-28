package com.emc.rpsp.users.service;

import java.util.List;

import com.emc.rpsp.infra.common.auth.domain.AbstractCurrentUser;
import com.emc.rpsp.users.domain.User;

public interface UserService {

    public List<User> findUsers();

    public AbstractCurrentUser findCurrentUser();

    public User findUser(Long id);

    public User findUserByLogin(String login);

    public User createUser(User user);

    public User updateUser(User user);

    public void deleteUser(Long id);

    public String getAdminLogin();

}
