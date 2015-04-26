package com.emc.rpsp.web.rest;

//import com.codahale.metrics.annotation.Timed;

import com.emc.rpsp.domain.User;
import com.emc.rpsp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing users.
 */
@RestController
@RequestMapping("/app")
public class UserResource {

	private final Logger log = LoggerFactory.getLogger(UserResource.class);

	@Inject
	private UserRepository userRepository;

	// /**
	// * GET /rest/users/:login -> get the "login" user.
	// */
	// @RequestMapping(value = "/rest/users/{login}",
	// method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_VALUE)
	// // @Timed
	// ResponseEntity<User> getUser(@PathVariable String login) {
	// log.debug("REST request to get User : {}", login);
	// return Optional.ofNullable(userRepository.findOne(login))
	// .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
	// .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	// }

	/**
	 * GET /rest/users -> get all users list.
	 */
	@RequestMapping(value = "/rest/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<User>> getUser() {
		log.debug("REST request to get all users");
		return Optional.ofNullable(userRepository.findAll())
		        .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
		        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
