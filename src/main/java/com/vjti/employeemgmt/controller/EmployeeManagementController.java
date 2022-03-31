package com.vjti.employeemgmt.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vjti.employeemgmt.bean.Employee;
import com.vjti.employeemgmt.service.EmployeeService;

@RestController
public class EmployeeManagementController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee/{empId}")
	public ResponseEntity searchEmployee(@PathVariable Integer empId) {
		Employee searchEmployee = employeeService.searchEmployee(empId);
		if (Objects.nonNull(searchEmployee))
			return ResponseEntity.ok(searchEmployee);
		else
			return ResponseEntity.ok(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@PutMapping("/employee/{empId}")
	public Employee editEmployee(@RequestBody Employee employee, @PathVariable Integer empId) {
		// TODO Auto-generated method stub
		return employeeService.editEmployee(employee, empId);
	}

	@DeleteMapping("/employee/{empId}")
	public ResponseEntity deleteEmployee(@PathVariable Integer empId) {
		employeeService.deleteEmployee(empId);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@GetMapping("/employeeList")
	public List<Employee> getEmployeeList() {
		return employeeService.getEmployeeList();
	}

}
