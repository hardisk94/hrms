package com.coviam.internalapp.hrms.leavemgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coviam.internalapp.hrms.leavemgmt.dao.LeaveRenewalRepository;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveRenewal;

@Component
public class LeaveRenewalServiceImpl implements LeaveRenewalService {

	@Autowired
	private LeaveRenewalRepository leaverenewalRepository;
	
	
	@Override
	public LeaveRenewal getLeaveRenewal(String customerId) {
		return leaverenewalRepository.findByCustomerId(customerId);
	}

	
	@Override
	public void addLeaveRenewal(String customerId, String leaveRenewalMonth) {
		LeaveRenewal leaveRenewal = leaverenewalRepository.findByCustomerId(customerId);
		if(leaveRenewal != null) {
			leaveRenewal.setRenewalMonth(leaveRenewalMonth);;
		} else {
			leaveRenewal = new LeaveRenewal(customerId, leaveRenewalMonth);
		}
		leaverenewalRepository.save(leaveRenewal);
	}
	
}
