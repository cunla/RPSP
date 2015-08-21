package com.emc.rpsp.infra.common.auth.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.emc.rpsp.infra.common.auth.domain.AbstractCurrentUser;

public interface CurrentUserDetailsService extends UserDetailsService {

	
	public  AbstractCurrentUser loadUserByUsername(String userName)
			throws UsernameNotFoundException;

}
