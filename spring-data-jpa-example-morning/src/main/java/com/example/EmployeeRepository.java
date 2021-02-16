package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//spring data jpa will implement all method related employee entity
	//crud --> create (save), findAll(), delete, update
	//25
	public List<Employee> findByName(String nm);
	//	select id, name from employee where name = ?
}

//public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer>{
//	//spring data jpa will implement all method related employee entity
//	//crud --> create (save), findAll(), delete, update
//	//13
//}

//public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
//	//spring data jpa will implement all method related employee entity
//	//crud --> create (save), findAll(), delete, update
//	//10
//}

//public interface EmployeeRepository extends Repository<Employee, Integer>{
//	//spring data jpa will implement all method related employee entity
//	//crud --> create (save), findAll(), delete, update
//	
//}
