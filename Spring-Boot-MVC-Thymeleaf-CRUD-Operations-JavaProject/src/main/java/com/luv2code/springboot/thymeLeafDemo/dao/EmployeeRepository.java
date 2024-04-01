package com.luv2code.springboot.thymeLeafDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeLeafDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
	
	//Write a custom method to sort the data by last name in ascending order
	List<Employee> findAllByOrderByLastNameAsc();

}
