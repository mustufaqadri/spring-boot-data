package com.company.springboot.springbootcrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.springboot.springbootcrm.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// no need to write CRUD methods
}
