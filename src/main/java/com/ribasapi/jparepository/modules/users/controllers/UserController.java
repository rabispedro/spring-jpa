package com.ribasapi.jparepository.modules.users.controllers;

import java.util.List;

import com.ribasapi.jparepository.modules.users.daos.UserSalaryDAO;
import com.ribasapi.jparepository.modules.users.entities.UserEntity;
import com.ribasapi.jparepository.modules.users.services.UserFindAllPagedService;
import com.ribasapi.jparepository.modules.users.services.UserFindAllService;
import com.ribasapi.jparepository.modules.users.services.UserFindBySalaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserFindAllService userFindAllService;

	@Autowired
	private UserFindAllPagedService userFindAllPagedService;

	@Autowired
	private UserFindBySalaryService userFindBySalaryService;

	@GetMapping(value = "/")
	public ResponseEntity<List<UserEntity>> findAll() {
		List<UserEntity> users = userFindAllService.execute();
		return ResponseEntity.ok(users);
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<UserEntity>> findAllPaged(Pageable pageable) {
		Page<UserEntity> users = userFindAllPagedService.execute(pageable);
		return ResponseEntity.ok(users);
	}

	@GetMapping(value = "/search-salary")
	public ResponseEntity<Page<UserEntity>> findBySalary(@RequestBody UserSalaryDAO userSalaryDAO , Pageable pageable) {
		Page<UserEntity> users = userFindBySalaryService.execute(userSalaryDAO, pageable);
		return ResponseEntity.ok(users);
	}
}
