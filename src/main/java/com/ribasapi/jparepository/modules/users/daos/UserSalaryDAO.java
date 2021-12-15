package com.ribasapi.jparepository.modules.users.daos;

import java.util.Optional;

import lombok.Data;

@Data
public class UserSalaryDAO {
	Optional<Double> minSalary;
	Optional<Double> maxSalary;
}