package com.emc.rpsp.infra.sqlplugin.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.service.AccountService;
import com.emc.rpsp.infra.common.auth.service.CurrentUserDetailsService;
import com.emc.rpsp.infra.sqlplugin.auth.domain.CurrentUserSqlImpl;
import com.emc.rpsp.users.service.UserService;

@Service
public class CurrentUserDetailsServiceSqlImpl implements CurrentUserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@Override
	public CurrentUserSqlImpl loadUserByUsername(String userName)
			throws UsernameNotFoundException {

		com.emc.rpsp.users.domain.User user = null;

		if (isImpersonatedAdmin(userName)) {
			user = userService.findUserByLogin(userService.getAdminLogin());
			Account account = accountService
					.findByName(getAccountName(userName));
			if (account != null) {
				user.setAccount(account);
				user.setLogin(userName);
			} else {
				user = null;
			}
		} else {
			user = userService.findUserByLogin(userName);
		}
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}
		CurrentUserSqlImpl currentUser = new CurrentUserSqlImpl(user);
		return currentUser;
	}

	private boolean isImpersonatedAdmin(String login) {
		boolean res = false;
		String adminLoginPrefix = userService.getAdminLogin().split("@")[0];
		String currLoginPrefix = login.split("@")[0];
		if (adminLoginPrefix.equals(currLoginPrefix)) {
			if (!userService.getAdminLogin().equals(login)) {
				res = true;
			}
		}
		return res;
	}

	private String getAccountName(String login) {
		String res = login.split("@")[1];
		return res;
	}

}
