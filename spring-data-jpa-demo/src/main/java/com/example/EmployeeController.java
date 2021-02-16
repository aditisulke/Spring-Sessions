package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepository er;

	// add employee
	@RequestMapping(path = "/employee/{name}", method = RequestMethod.POST)
	@ResponseBody
	public String addEmployee(@PathVariable String name) {
		er.save(new Employee(name));
		return name + " added successfully";
	}

	// For getting all employee
	@RequestMapping(path = "/employee", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> displayEmployee() {
		return er.findAll();
	}

	// For getting employee by id
	@RequestMapping(path = "/employee/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Employee> displayEmployeeById() {
		return er.findById(1);
	}

	// For deleting employee by id
	@RequestMapping(path = "/employee/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteEmployeeById(@PathVariable int id) {
		er.deleteById(id);
		return "Employee deleted with id: " + id;
	}

	// For updating employee by id
	@RequestMapping(path = "/employee/{id}/{name}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateEmployeeById(@PathVariable int id, @PathVariable String name) {
		er.save(new Employee(id, name));
		return "Employee updated with id: " + id;
	}

	// For getting employee by name using named query.
	@RequestMapping(path = "/employee/name/{name}", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> findEmployeeByName(@PathVariable String name) {
		return er.findEmployeeByName(name);
	}
}
