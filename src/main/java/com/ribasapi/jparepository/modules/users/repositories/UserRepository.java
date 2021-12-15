package com.ribasapi.jparepository.modules.users.repositories;

import com.ribasapi.jparepository.modules.users.entities.UserEntity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository <UserEntity, Long>{

	@Query(
		"SELECT user " +
		"FROM UserEntity user " +
		"WHERE (user.salary >= :minSalary AND user.salary <= :maxSalary)"
	)
	Page<UserEntity> findBySalary(Double minSalary, Double maxSalary, Pageable pageable);
}
