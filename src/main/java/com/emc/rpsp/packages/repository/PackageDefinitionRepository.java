package com.emc.rpsp.packages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emc.rpsp.packages.domain.PackageDefinition;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface PackageDefinitionRepository extends JpaRepository<PackageDefinition, Long> {
}
