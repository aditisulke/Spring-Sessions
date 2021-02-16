package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaDemoApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository er;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		List<String> phones = new ArrayList<>();
		phones.add("90111");
		phones.add("90112");
		phones.add("90113");
		phones.add("90114");
		phones.add("90115");
		er.save(new Employee("Neeraj", phones));
		System.out.println("---------------------------");
		er.findAll();
		System.out.println("---------------------------");
	}

}
