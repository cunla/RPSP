package com.emc.rpsp.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emc.rpsp.accounts.domain.Account;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findOneByName(String name);
}
