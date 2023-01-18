package com.app.lokesh.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.lokesh.entity.Employee;
import com.app.lokesh.exception.EmployeeNotFoundException;

public interface IEmployeeService {
	
	Integer saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(Integer id) throws EmployeeNotFoundException;

	Employee getOneEmployee(Integer id) throws EmployeeNotFoundException;

	List<Employee> getAllEmployees();
	
	Page<Employee> getEmployeePage(Pageable pageable);
}
