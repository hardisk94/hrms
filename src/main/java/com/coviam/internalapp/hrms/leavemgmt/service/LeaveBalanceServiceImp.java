package com.coviam.internalapp.hrms.leavemgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coviam.internalapp.hrms.leavemgmt.dao.LeaveBalanceRepository;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveBalance;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveType;

	@Component
	public class LeaveBalanceServiceImp implements LeaveBalanceService {
	
	@Autowired
	private LeaveBalanceRepository leaveBalanceRepository;
	
	@Autowired
	private LeaveTypeService leaveTypeService;
	
	@Override
	public List<LeaveBalance> getAllRecords(String empID, String customerId) {
		List<LeaveBalance> leaveBalanceList = new ArrayList<>();
		leaveBalanceRepository.findByEmployeeIdAndCustomerId(empID, customerId).forEach(leaveBalanceList::add);
		return leaveBalanceList;
	}

	@Override
	public LeaveBalance getRecordsByType(String empID, String customerId, String leaveType) {
		LeaveType leaveTypeObj  = leaveTypeService.getLeaveTypeId(leaveType, customerId);
		int leaveTypeId  = leaveTypeObj.getLeaveTypeId();
		return leaveBalanceRepository.findByEmployeeIdAndCustomerIdAndLeaveType(empID, customerId, leaveTypeId);

	}

	@Override
	public LeaveBalance updateRecordForDeduct(String empID,  String customerId, String leaveType, int leaveCount) {
		LeaveType leaveTypeObj  = leaveTypeService.getLeaveTypeId(leaveType, customerId);
		int leaveTypeId  = 0;
		if(leaveTypeObj != null) {
			leaveTypeId  = leaveTypeObj.getLeaveTypeId();
		}
		LeaveBalance leaveBalance = leaveBalanceRepository.findByEmployeeIdAndCustomerIdAndLeaveType(empID, customerId, leaveTypeId);
		if (leaveBalance != null) {
			leaveBalance.setLeaveBalance(leaveBalance.getLeaveBalance() - leaveCount);
		}
		leaveBalanceRepository.save(leaveBalance);
		return leaveBalance;
	}

	@Override
	public LeaveBalance updateRecordForAdd(String empID, String customerId, String leaveType, int leaveCount) {
		LeaveType leaveTypeObj  = leaveTypeService.getLeaveTypeId(leaveType, customerId);
		int leaveTypeId  = 0;
		if(leaveTypeObj != null) {
			leaveTypeId = 	leaveTypeObj.getLeaveTypeId();
		}
		LeaveBalance leaveBalance = leaveBalanceRepository.findByEmployeeIdAndCustomerIdAndLeaveType(empID, customerId, leaveTypeId);
		if(leaveBalance != null) {
			leaveBalance.setLeaveBalance(leaveBalance.getLeaveBalance() + leaveCount);
			leaveBalanceRepository.save(leaveBalance);
		}
		return leaveBalance;
	}
	
	@Override
	public void addLeaveBalanceForFirstTime(String empId, String customerId) {
		List<LeaveType> leaveTypeList =  leaveTypeService.getAllLeaveType(customerId);
		if(leaveTypeList != null) {
			for(LeaveType leaveType: leaveTypeList) {
				LeaveBalance leaveBalance = new LeaveBalance(empId, customerId, leaveType.getLeaveTypeId(), leaveType.getMaxLeave());
				leaveBalanceRepository.save(leaveBalance);
			}
		}
	}

}
