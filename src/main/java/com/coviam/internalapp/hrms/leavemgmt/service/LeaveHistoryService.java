package com.coviam.internalapp.hrms.leavemgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;

@Service
public interface LeaveHistoryService {
	
	public List<LeaveHistory> getAllLeaveHistoryForEmployee(String empId, String customerId);
	public void addLeaveHistory(String empId, String customerId, String fromDate, String toDate, int dayCount, String leaveType, String leaveReason);
	public void updateLeaveHistory(String leaveHistoryId);
	public void  updateLeaveHistoryForCancel(int leaveHistoryId);
	public void updateLeaveHistoryBySupervisor(int leaveHistoryId, String approvedBy, String status, String statusReason);
	public List<LeaveHistory> getAllLeaveHistoryForLead(String customerId, String employeeId);
	public String addNewLeave(LeaveHistory leaveHistory);
	
}
