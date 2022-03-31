package com.vjti.employeemgmt.utils;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vjti.employeemgmt.bean.Employee;
import com.vjti.employeemgmt.entity.EmployeeEntity;

@Component
public class EmployeeMapper {
	@Autowired
	private ModelMapper modelMapper;

	public Employee convertToDto(EmployeeEntity employeeEntity) {
		return modelMapper.map(employeeEntity, Employee.class);
	}

	public EmployeeEntity convertToEntity(Employee employee)  {
		return modelMapper.map(employee, EmployeeEntity.class);

	}

}
