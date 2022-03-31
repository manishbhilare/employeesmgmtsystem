package com.vjti.employeemgmt.service;

import java.util.List;

import com.vjti.employeemgmt.bean.Employee;

public interface EmployeeService {

	public Employee searchEmployee(Integer empId);
	
	public Employee addEmployee(Employee employee);
	
	public Employee editEmployee(Employee employee, Integer empId);
	
	public String deleteEmployee(Integer empId);
	
	public List<Employee>getEmployeeList();
	
	
	
}
