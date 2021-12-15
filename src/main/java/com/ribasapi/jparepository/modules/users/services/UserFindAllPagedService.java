package com.ribasapi.jparepository.modules.users.services;

import com.ribasapi.jparepository.modules.users.entities.UserEntity;
import com.ribasapi.jparepository.modules.users.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserFindAllPagedService {
	@Autowired
	private UserRepository userRepository;
	
	public Page<UserEntity> execute(Pageable pageable) {
		Page<UserEntity> users = this.userRepository.findAll(pageable);
		return users;
	}
}
