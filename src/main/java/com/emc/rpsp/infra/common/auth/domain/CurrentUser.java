package com.emc.rpsp.infra.common.auth.domain;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.users.domain.User;

/**
 * Created by morand3 on 11/29/2015.
 */
public interface CurrentUser {
    public User getUser();

    public Account getAccount();
}
