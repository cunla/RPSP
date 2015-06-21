package com.emc.rpsp.login.service;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.service.AccountService;
import com.emc.rpsp.login.domain.CurrentUser;
import com.emc.rpsp.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired private UserService userService;

    @Autowired private AccountService accountService;

    @Override public UserDetails loadUserByUsername(String userName)
    throws UsernameNotFoundException {

        com.emc.rpsp.users.domain.User user = null;

        if (isImpersonatedAdmin(userName)) {
            user = userService.findUserByLogin(userService.getAdminLogin());
            Account account = accountService.findByName(getAccountName(userName));
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
        CurrentUser currentUser = new CurrentUser(user);
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
