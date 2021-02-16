package com.example;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity				//This will be table in database
@Table(name = "employee")
//@NamedQuery(name="Employee.findEmployeeByName" , query = "select e from Employee e where e.name = ?1")		//JPQL syntax:jpa query language.1is for first placeholder.
//@NamedNativeQuery(name="employee.findEmployeeByName" , query = "select * from employee where emp_name = ?1", resultClass = Employee.class)	
public class Employee {
	
	@Id				//This will be primary key in database
	@GeneratedValue(strategy = GenerationType.AUTO)		//This is for autogeneration of id.
	@Column(name = "emp_id")
	private int id;
	
	@Column(name = "emp_name")
	private String name;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "emp_phone", joinColumns = @JoinColumn(name = "emp_id"))
	private List<String> phone;
	
	public Employee(String name, List<String> phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	public Employee() {
		super();
	}
	
	public Employee(int id, String name, List<String> phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public Employee(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getPhone() {
		return phone;
	}
	public void setPhone(List<String> phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
