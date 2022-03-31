package com.vjti.employeemgmt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author manis
 *
 */
@Entity
public class EmployeeEntity {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer empid;
private String name;
private String department;
private String city;
private String state;
private String country;
private Integer pinCode;
public Integer getEmpid() {
	return empid;
}
public void setEmpid(Integer empid) {
	this.empid = empid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public Integer getPinCode() {
	return pinCode;
}
public void setPinCode(Integer pinCode) {
	this.pinCode = pinCode;
}

}
