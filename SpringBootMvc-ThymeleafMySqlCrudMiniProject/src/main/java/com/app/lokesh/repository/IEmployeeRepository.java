package com.app.lokesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.lokesh.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

}
