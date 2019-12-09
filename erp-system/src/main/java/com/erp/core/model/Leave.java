package com.erp.core.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVES")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveId;

	private LocalDate startDate;
	private LocalDate endDate;
	private LeaveDurationEnum leaveDuration;
	private LeaveTypeEnum leaveType;
	private LeaveStatusEnum status;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "applicant_id_fk", referencedColumnName = "empId")
	// @MapsId("empId")
	private Employee applicant;

	public Leave(LocalDate startDate, LocalDate endDate, LeaveDurationEnum leaveDuration, LeaveTypeEnum leaveType,
			Employee applicant) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaveDuration = leaveDuration;
		this.leaveType = leaveType;
		this.status = LeaveStatusEnum.WAITING;
		this.applicant = applicant;
	}

	public LocalDate getDate() {
		return startDate;
	}

	public void setDate(LocalDate date) {
		this.startDate = date;
	}

	public Employee getApplicant() {
		return applicant;
	}

	public void setApplicant(Employee applicant) {
		this.applicant = applicant;
	}

	public enum LeaveStatusEnum {
		WAITING, APPROVED, REJECTED;
	}

	public enum LeaveTypeEnum {
		ANNUAL, CASUAL, SICK, AUTHORIZED_NOPAY, NOPAY;
	}

	public enum LeaveDurationEnum {
		FULL_DAY, HALF_DAY, SHORT_LEAVE;
	}

}
