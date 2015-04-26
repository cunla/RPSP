package com.emc.rpsp.login.domain;

import com.emc.rpsp.domain.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends
        org.springframework.security.core.userdetails.User {

	private User user;

	public CurrentUser(User user) {
		super(user.getLogin(), user.getPassword(), AuthorityUtils
		        .createAuthorityList(user.getPermission()));
		this.user = user;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
