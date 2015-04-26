package com.emc.rpsp.users.service.impl;

import com.emc.rpsp.domain.User;
import com.emc.rpsp.login.domain.CurrentUser;
import com.emc.rpsp.repository.UserRepository;
import com.emc.rpsp.users.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Value("${rpsp.admin.login}")
	private String adminLogin;

	@Value("${rpsp.admin.password}")
	private String adminPaswword;

	@PostConstruct
	public void init() {
		User existingAdmin = userRepository.findOneByLogin(adminLogin);
		if (existingAdmin == null) {
			User newAdmin = new User();
			newAdmin.setLogin(adminLogin);
			newAdmin.setEncodedPassword(adminPaswword);
			newAdmin.setPermission("ADMIN");
			newAdmin.setFirstName("admin");
			newAdmin.setLastName("admin");
			updateAuditFields(newAdmin);
			userRepository.save(newAdmin);
		}
	}

	@Override
	public List<User> findUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public CurrentUser findCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext()
		        .getAuthentication();
		CurrentUser currentUser = (CurrentUser) auth.getPrincipal();
		return currentUser;
	}

	@Override
	public User findUser(Long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	@Override
	public User createUser(User user) {
		updateAuditFields(user);
		user.setEncodedPassword(user.getPassword());
		user.setPermission("USER");
		User createdUser = userRepository.save(user);
		return createdUser;
	}

	@Override
	public User updateUser(User user) {
		User existingUser = userRepository.findOne(user.getId());
		if (existingUser == null) {
			return null;
		}
		if (user.getLogin() != null) {
			existingUser.setLogin(user.getLogin());
		}
		if (user.getPassword() != null) {
			existingUser.setEncodedPassword(user.getPassword());
		}
		if (user.getFirstName() != null) {
			existingUser.setFirstName(user.getFirstName());
		}
		if (user.getLastName() != null) {
			existingUser.setLastName(user.getLastName());
		}
		if (user.getEmail() != null) {
			existingUser.setEmail(user.getEmail());
		}
		User updatedUser = userRepository.save(existingUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}

	@Override
	public User findUserByLogin(String login) {
		User user = userRepository.findOneByLogin(login);
		return user;
	}

	public String getAdminLogin() {
		return adminLogin;
	}

	public void setAdminLogin(String adminLogin) {
		this.adminLogin = adminLogin;
	}

	public String getAdminPaswword() {
		return adminPaswword;
	}

	public void setAdminPaswword(String adminPaswword) {
		this.adminPaswword = adminPaswword;
	}

	void updateAuditFields(User user) {
		user.setCreatedBy("Anonimous");
		user.setCreatedDate(new DateTime());
	}

}
