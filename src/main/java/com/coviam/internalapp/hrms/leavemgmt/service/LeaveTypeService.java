package com.coviam.internalapp.hrms.leavemgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveType;

@Service
public interface LeaveTypeService {
	
	LeaveType addNewLeaveType(String customerId, String leaveType, int maxLeave);
	List<LeaveType> getAllLeaveType(String customerId);
	List<String> getLeaveTypeByName(String customerId);
	LeaveType getLeaveTypeId(String leaveType, String customerId);
}
