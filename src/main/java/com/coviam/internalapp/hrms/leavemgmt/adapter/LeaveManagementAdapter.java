package com.coviam.internalapp.hrms.leavemgmt.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;
import com.coviam.internalapp.hrms.leavemgmt.view.entity.LeaveHistoryDto;


@Service
public class LeaveManagementAdapter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public  LeaveHistoryDto convertToDto(LeaveHistory leaveHistory) {
		LeaveHistoryDto leaveHistoryDto = modelMapper.map(leaveHistory, LeaveHistoryDto.class);
	//	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	//	leaveHistoryDto.setStartDate(df.format(leaveHistory.getFromDate()));
	//	leaveHistoryDto.setEndDate(df.format(leaveHistory.getToDate()));
	//	leaveHistoryDto.setApprovedDate(df.format(leaveHistory.getApprovedDate()));
		leaveHistoryDto.setApprovedBy(leaveHistory.getAprovedBy());
		return leaveHistoryDto;
	}
	
	
	public LeaveHistory convertToEntity(LeaveHistoryDto leaveHistoryDto) throws ParseException  {
		LeaveHistory leaveHistory = modelMapper.map(leaveHistoryDto, LeaveHistory.class);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		leaveHistory.setFromDate((Date)df.parse(leaveHistoryDto.getStartDate()));
		leaveHistory.setToDate((Date)df.parse(leaveHistoryDto.getEndDate()));
		
		leaveHistory.setCancelled(false);
		leaveHistory.setLeaveStatus("pending");
		leaveHistory.setAppliedDate(new Date());
		leaveHistory.setAprovedBy("Not Assigned");
			
		return leaveHistory;
	}

/*throws ParseException


*/
}

