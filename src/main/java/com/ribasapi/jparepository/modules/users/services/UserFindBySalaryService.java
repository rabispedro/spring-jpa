package com.ribasapi.jparepository.modules.users.services;

import java.util.logging.Logger;

import com.ribasapi.jparepository.modules.users.daos.UserSalaryDAO;
import com.ribasapi.jparepository.modules.users.entities.UserEntity;
import com.ribasapi.jparepository.modules.users.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserFindBySalaryService {
	@Autowired
	private UserRepository userRepository;

	public Page<UserEntity> execute(UserSalaryDAO userSalaryDAO, Pageable pageable) {
		Logger.getLogger("UserSalayDAO: " + userSalaryDAO);
		Double minSalary = userSalaryDAO.getMinSalary().get();
		Double maxSalary = userSalaryDAO.getMaxSalary().get();
		Page<UserEntity> users = this.userRepository.findBySalary(minSalary, maxSalary, pageable);
		return users;
	}

}
