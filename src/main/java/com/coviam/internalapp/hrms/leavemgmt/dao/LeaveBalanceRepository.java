package com.coviam.internalapp.hrms.leavemgmt.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveBalance;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveType;

@Repository
public interface LeaveBalanceRepository extends CrudRepository<LeaveBalance,Integer>{
	
	public List<LeaveBalance> findByEmployeeIdAndCustomerId(String employeeId, String customerId);
	public LeaveBalance findByEmployeeIdAndCustomerIdAndLeaveType(String employeeId, String customerId, int leaveType);
}
