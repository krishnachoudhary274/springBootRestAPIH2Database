package com.krishna.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.rest.model.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findAllByName(String name);
}
