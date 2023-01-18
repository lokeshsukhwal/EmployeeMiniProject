package com.app.lokesh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.lokesh.entity.Employee;
import com.app.lokesh.exception.EmployeeNotFoundException;
import com.app.lokesh.repository.IEmployeeRepository;
import com.app.lokesh.service.IEmployeeService;
import com.app.lokesh.util.EmployeeUtil;

@Service // createObject,TxManagement,BusinessLogic
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository repository;
	
	@Override
	public Integer saveEmployee(Employee employee) {
		EmployeeUtil.hraAndTaCalculations(employee);
		Employee emp = repository.save(employee);
		return emp.getEmpId();
	}

	@Override
	public void updateEmployee(Employee employee) {
		EmployeeUtil.hraAndTaCalculations(employee);
		repository.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
		repository.delete(this.getOneEmployee(id));
	}

	@Override
	public Employee getOneEmployee(Integer id)throws EmployeeNotFoundException {
		return repository.findById(id).
				orElseThrow(()-> new EmployeeNotFoundException("Employee '"+id+"'Not Found"));
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = repository.findAll();
		return list;
	}
	
	@Override
	public Page<Employee> getEmployeePage(Pageable pageable) {
	Page<Employee>empPages=	repository.findAll(pageable);
		return empPages;
	}

}
