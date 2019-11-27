package com.erp.core.model;

import java.time.LocalDate;

public class Leave {
	private Long leaveId;

	private LocalDate startDate;
	private LocalDate endDate;
	private LeaveDurationEnum leaveDuration;
	private LeaveTypeEnum leaveType;
	private LeaveStatusEnum status;
	private Employee applicant;

	public Leave() {
		this.status = LeaveStatusEnum.WAITING;
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
		ANNUAL, CASUAL, SICK, APPROVED_NOPAY, NOPAY;
	}

	public enum LeaveDurationEnum {
		FULL_DAY, HALF_DAY, SHORT_LEAVE;
	}

}
