package com.coviam.internalapp.hrms.leavemgmt.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveBalance;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;

@Repository
public interface LeaveHostoryRepository extends CrudRepository<LeaveHistory, Integer>{
	public List<LeaveHistory> findByEmployeeIdAndCustomerId(String employeeId, String customerId);
	public LeaveHistory findByLeaveHistoryId(int leaveHistoryId);
	public List<LeaveHistory> findByCustomerIdAndApprovedByAndLeaveStatus(String customerID, String approvedBy, String leaveStatus);
}
