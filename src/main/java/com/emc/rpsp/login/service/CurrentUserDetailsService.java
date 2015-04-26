package com.emc.rpsp.login.service;

import com.emc.rpsp.login.domain.CurrentUser;
import com.emc.rpsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HttpServletRequest request;

	@Override
	public UserDetails loadUserByUsername(String userName)
	        throws UsernameNotFoundException {

		com.emc.rpsp.domain.User user = userRepository.findOneByLogin(userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}
		CurrentUser currentUser = new CurrentUser(user);
		return currentUser;
	}

}
