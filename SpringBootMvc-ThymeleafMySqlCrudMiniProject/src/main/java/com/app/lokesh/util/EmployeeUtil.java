package com.app.lokesh.util;

import com.app.lokesh.entity.Employee;


/**
 * JDK 8 Feature
 */
public interface EmployeeUtil {

	public static void hraAndTaCalculations(Employee employee) {
		Double ta = employee.getEmpSalary() * 12 /100;
		Double hra = employee.getEmpSalary() * 5 /100;
		employee.setTa(ta);
		employee.setHra(hra);
	}
}
