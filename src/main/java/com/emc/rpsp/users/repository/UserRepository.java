package com.emc.rpsp.users.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emc.rpsp.users.domain.User;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.activationKey = ?1")
	User getUserByActivationKey(String activationKey);

	@Query("select u from User u where u.activated = false and u.createdDate > ?1")
	List<User> findNotActivatedUsersByCreationDateBefore(DateTime dateTime);

	@Query("select u from User u")
	List<User> findAll();

	User findOneByEmail(String email);

	User findOneByLogin(String login);
}
