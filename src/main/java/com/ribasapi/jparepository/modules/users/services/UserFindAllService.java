package com.ribasapi.jparepository.modules.users.services;

import java.util.List;

import com.ribasapi.jparepository.modules.users.entities.UserEntity;
import com.ribasapi.jparepository.modules.users.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFindAllService {
	@Autowired
	private UserRepository userRepository;
	
	public List<UserEntity> execute() {
		List<UserEntity> users = userRepository.findAll();
		return users;
	}
}
