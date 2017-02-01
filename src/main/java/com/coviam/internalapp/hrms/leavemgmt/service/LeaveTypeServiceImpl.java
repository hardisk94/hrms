package com.coviam.internalapp.hrms.leavemgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coviam.internalapp.hrms.leavemgmt.dao.LeaveTypeRepository;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveType;

@Component
public class LeaveTypeServiceImpl implements LeaveTypeService {

	@Autowired	
	LeaveTypeRepository leaveTypeRepository;
	
	@Override
	public LeaveType addNewLeaveType(String customerId,String leaveType, int maxLeave) {
		LeaveType leaveTypeObj = new LeaveType(leaveType,maxLeave,0,0, customerId);
		return leaveTypeRepository.save(leaveTypeObj);
	}

	@Override
	public List<LeaveType> getAllLeaveType(String customerId) {
		List<LeaveType> leaveTypeList = new ArrayList<>();
		leaveTypeRepository.findByCustomerId(customerId).forEach(leaveTypeList::add);
		return leaveTypeList;
	}

	@Override
	public List<String> getLeaveTypeByName(String customerId) {
		List<LeaveType> leaveTypeList = new ArrayList<>();
		List<String> leaveTypeNameList = new ArrayList<>();
		leaveTypeRepository.findByCustomerId(customerId).forEach(leaveTypeList::add);
		for(LeaveType leaveType : leaveTypeList) {
			leaveTypeNameList.add(leaveType.getLeaveType());
		}
		return leaveTypeNameList;
	}

	@Override
	public LeaveType getLeaveTypeId(String leaveType, String customerId) {
		return leaveTypeRepository.findByLeaveTypeAndCustomerId(leaveType, customerId);
	}

	
	

}
