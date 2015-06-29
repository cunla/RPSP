package com.emc.rpsp.accounts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emc.rpsp.accounts.domain.AccountConfig;

/**
 * Spring Data JPA repository for the Account Config entity.
 */
public interface AccountConfigsRepository extends JpaRepository<AccountConfig, Long> {
	
	@Query("select ac from AccountConfig ac where ac.account.id = ?1")
	List<AccountConfig> findAccountConfigs(Long accountId);
}
