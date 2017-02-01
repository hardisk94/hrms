package com.coviam.internalapp.hrms.leavemgmt.service;

import org.springframework.stereotype.Service;

import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveRenewal;

@Service
public interface LeaveRenewalService {
	public LeaveRenewal getLeaveRenewal(String customerId);
	public void addLeaveRenewal(String cutomerId, String leaveRenewalMonth);
}
