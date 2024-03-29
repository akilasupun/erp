package com.erp.core.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String firstName;
	private String lastName;
	private EmployeeContractTypeEnum contractType;
	private Integer epfNo;
	private String jobTitle;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id_fk", referencedColumnName = "deptId")
	// @MapsId("id")
	private Department department;
	private String email;

	public Employee(String firstName, String lastName, EmployeeContractTypeEnum contractType, Integer epfNo,
			String jobTitle, Department department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contractType = contractType;
		this.epfNo = epfNo;
		this.jobTitle = jobTitle;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EmployeeContractTypeEnum getContractType() {
		return contractType;
	}

	public void setContractType(EmployeeContractTypeEnum contractType) {
		this.contractType = contractType;
	}

	public Integer getEpfNo() {
		return epfNo;
	}

	public void setEpfNo(int epfNo) {
		this.epfNo = epfNo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getEmpId() {
		return empId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public enum EmployeeContractTypeEnum {
		PERMANENT, TEMPORARY, PROBATION;
	}
}