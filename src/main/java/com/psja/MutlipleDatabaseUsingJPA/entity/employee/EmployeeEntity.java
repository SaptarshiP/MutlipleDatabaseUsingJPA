package com.psja.MutlipleDatabaseUsingJPA.entity.employee;

import java.io.Serializable;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "EMPLOYEE_TABLE")
public class EmployeeEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	@Column(name = "EMPLOYEE_ADDRESS")
	private String employeeAddress;
	
	public Integer getEmpId() {
		return this.empId;
	}
	public void setEmpId( Integer empId ) {
		this.empId = empId;
	}
	
	public String getEmployeeName() {
		return this.employeeName;
	}
	public void setEmployeeName( String employeeName ) {
		this.employeeName = employeeName;
	}
	
	public String getEmployeeAddress() {
		return this.employeeAddress;
	}
	public void setEmployeeAddress( String employeeAddress ) {
		this.employeeAddress = employeeAddress;
	}
}
