package com.erp.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.core.PendingLeaveException;
import com.erp.core.model.Leave;
import com.erp.core.model.Leave.LeaveStatusEnum;
import com.erp.core.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	LeaveRepository leaveRepository;

	@Override
	public void applyLeave(Leave newLeave) {
		if (leaveRepository.countByApplicantAndStatus(newLeave.getApplicant(), LeaveStatusEnum.WAITING) != 0)
			throw new PendingLeaveException("You already have a Pending Leave");

		// Logic if No pending leaves }

	}

	@Override
	public void saveLeave(Leave leaveToSave) {
		leaveRepository.save(leaveToSave);
	}
}