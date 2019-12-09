package com.erp.core;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.erp.core.model.Department;
import com.erp.core.model.Employee;
import com.erp.core.model.Employee.EmployeeContractTypeEnum;
import com.erp.core.model.Leave;
import com.erp.core.model.Leave.LeaveDurationEnum;
import com.erp.core.model.Leave.LeaveTypeEnum;
import com.erp.core.service.DepartmentService;
import com.erp.core.service.EmployeeService;
import com.erp.core.service.LeaveService;

@SpringBootApplication
public class ErpSystemApplication {
	@Autowired
	LeaveService leaveService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;

	public static void main(String[] args) {
		SpringApplication.run(ErpSystemApplication.class, args);

		ErpSystemApplication erpApplication = new ErpSystemApplication();
		erpApplication.persistenceMethod();
	}

	private void persistenceMethod() {
		Department boardDepartment = new Department(/* null, */ Department.Title.BOARD);
		departmentService.saveDepartment(boardDepartment);

		Employee hrDeptHead = new Employee("hrHeadFname", "hrHeadLname", EmployeeContractTypeEnum.PERMANENT, 100001,
				"Manager", boardDepartment);
		// Saving Department Head
		employeeService.saveEmployee(hrDeptHead);

		Department hrDepartment = new Department(/* hrDeptHead, */ Department.Title.HR);

		Employee hrEmpOne = new Employee("Akila", "Supun", EmployeeContractTypeEnum.PERMANENT, 100002, "Accountant",
				hrDepartment);
		Employee hrEmpTwo = new Employee("Gayan", "Perera", EmployeeContractTypeEnum.PROBATION, 100003, "Clerk",
				hrDepartment);

		Leave hrEmpOneLeave = new Leave(LocalDate.of(2019, Month.DECEMBER, 10), LocalDate.of(2019, Month.DECEMBER, 10),
				LeaveDurationEnum.FULL_DAY, LeaveTypeEnum.CASUAL, hrEmpOne);

		// leaveService.saveLeave(hrEmpOneLeave);
	}

}
