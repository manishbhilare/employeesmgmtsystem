package com.vjti.employeemgmt.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vjti.employeemgmt.bean.Employee;
import com.vjti.employeemgmt.entity.EmployeeEntity;
import com.vjti.employeemgmt.repository.EmployeeRepository;
import com.vjti.employeemgmt.service.EmployeeService;
import com.vjti.employeemgmt.utils.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public Employee searchEmployee(Integer empId) {
		EmployeeEntity employee = employeeRepository.getById(empId);
		if (Objects.nonNull(employee))
			return employeeMapper.convertToDto(employee);
		else
			return null;

	}

	@Override
	public Employee addEmployee(Employee employee) {
		EmployeeEntity employeeEntity = employeeMapper.convertToEntity(employee);
		EmployeeEntity emp = employeeRepository.save(employeeEntity);
		return employeeMapper.convertToDto(emp);
	}

	@Override
	public Employee editEmployee(Employee employee, Integer empId) {
		EmployeeEntity emp = employeeRepository.getById(empId);
		if (Objects.nonNull(emp)) {
			EmployeeEntity employeeEntity = employeeMapper.convertToEntity(employee);
			employeeEntity.setEmpid(empId);
			EmployeeEntity savedEmp = employeeRepository.save(employeeEntity);
			return employeeMapper.convertToDto(emp);
		}
		// throw Data not found Exception
		return null;
	}

	@Override
	public String deleteEmployee(Integer empId) {
		employeeRepository.deleteById(empId);
		return "success";
	}

	@Override
	public List<Employee> getEmployeeList() {
		List<Employee> empList = employeeRepository.findAll().stream()
				.map(empEntity -> employeeMapper.convertToDto(empEntity)).collect(Collectors.toList());
		return empList;
	}

}
