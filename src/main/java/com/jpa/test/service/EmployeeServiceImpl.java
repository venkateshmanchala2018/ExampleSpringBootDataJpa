package com.jpa.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.EmployeeRepository.EmployeeRepository;
import com.jpa.test.model.Employee;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) repository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.repository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee>optional=repository.findById(id);
		Employee employee=null;
		if(optional.isPresent()) {
			employee=optional.get();
		}
		else {
			throw new RuntimeException("Employee Not found by id::" + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		this.repository.deleteById(id);
		
	}

}
