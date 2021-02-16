package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//Spring data jpa will implement all methods related to employee entity.
	//crud --> create(save), display(find all), delete, update.
	
	/*
	 * @Query("select e from employee e where e.name = ?1") //jpql(* is not allowed
	 * in jpql) public List<Employee> findEmployeeByName(String name);
	 */
	
	@Query(value = "select * from employee where emp_name = ?1", nativeQuery = true)	//like sql
	public List<Employee> findEmployeeByName(String name);
}
