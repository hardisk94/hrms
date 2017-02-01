package com.coviam.internalapp.hrms.leavemgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveBalance;

@Service
public interface LeaveBalanceService {

	public List<LeaveBalance> getAllRecords(String empID, String customerId);

	public LeaveBalance getRecordsByType(String empID, String customerId, String leaveType);

	public LeaveBalance updateRecordForDeduct(String empID, String customerId, String leaveType, int leaveCount);
	
	public LeaveBalance updateRecordForAdd(String empID, String customerId, String leaveType, int leaveCount);
	
	public void addLeaveBalanceForFirstTime(String empId, String customerId);

}
