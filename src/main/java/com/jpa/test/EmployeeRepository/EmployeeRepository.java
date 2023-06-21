package com.jpa.test.EmployeeRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa.test.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
