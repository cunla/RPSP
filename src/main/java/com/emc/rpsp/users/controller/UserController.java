package com.emc.rpsp.users.controller;

import com.emc.rpsp.domain.User;
import com.emc.rpsp.login.domain.CurrentUser;
import com.emc.rpsp.repository.UserRepository;
import com.emc.rpsp.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<User>> findUsers() {
		List<User> users = userService.findUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/current-user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<User> findCurrentUser() {
		CurrentUser currentUser = userService.findCurrentUser();
		return new ResponseEntity<>(currentUser.getUser(), HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<User> findUser(@PathVariable("id") Long id) {
		User user = userService.findUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User sameLoginUser = userService.findUserByLogin(user.getLogin());
		if (sameLoginUser != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		User createdUser = userService.createUser(user);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.LOCATION, "users/" + createdUser.getId());
		return new ResponseEntity<>(createdUser, httpHeaders,
		        HttpStatus.CREATED);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User existingUser = userService.findUser(user.getId());
		if (existingUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		User sameLoginUser = userService.findUserByLogin(user.getLogin());
		if (sameLoginUser != null
		        && sameLoginUser.getId() != existingUser.getId()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
		User user = userService.findUser(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/users/login/{login}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteUserByLogin(
	        @PathVariable("login") String login) {
		User user = userService.findUserByLogin(login);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUser(user.getId());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
