package com.TL.repository;

import org.springframework.data.repository.CrudRepository;

import com.TL.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee,Integer> {
	

}
