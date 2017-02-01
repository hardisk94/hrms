package com.coviam.internalapp.hrms.leavemgmt.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coviam.internalapp.hrms.leavemgmt.dao.LeaveHostoryRepository;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveBalance;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;

@Component
public class LeaveHistoryServiceImpl implements LeaveHistoryService {

	@Autowired
	private LeaveHostoryRepository leaveHostoryRepository;
	
	
	@Autowired
	private LeaveBalanceService LeavebalanceService;
	
	@Override
	public List<LeaveHistory> getAllLeaveHistoryForEmployee(String empId, String customerId) {
		List<LeaveHistory> list  = new ArrayList<>();
		leaveHostoryRepository.findByEmployeeIdAndCustomerId(empId, customerId).forEach(list::add);
		return list;
	}

	@Override
	public void addLeaveHistory(String empId, String customerId, String fromDate, String toDate, int dayCount, String leaveType, String leaveReason) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		/*DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String cunvertCurrentDate="06/09/2015";
		Date date = new Date();
		date = df.parse(cunvertCurrentDate);*/
		try {
			Date convertedFromDate = simpleDateFormat.parse(fromDate);
			Date convertedToDate = simpleDateFormat.parse(toDate);
			System.out.println(convertedFromDate+"****************************");
			LeaveHistory leaveHistory = new LeaveHistory(empId, customerId, convertedFromDate, convertedToDate, dayCount, leaveType, leaveReason);
			leaveHostoryRepository.save(leaveHistory);
		} catch (ParseException e) {
			System.out.println("Error****************************");
			e.printStackTrace();
		}
	}

	@Override
	public void updateLeaveHistoryForCancel(int leaveHistoryId) {
		LeaveHistory leaveHistory = leaveHostoryRepository.findByLeaveHistoryId(leaveHistoryId);
		if(leaveHistory != null && !leaveHistory.getLeaveStatus().equalsIgnoreCase("rejected") && !leaveHistory.isCancelled()) {
			leaveHistory.setCancelled(true);
			if(leaveHistory.getLeaveStatus().equalsIgnoreCase("approved")) {
				LeavebalanceService.updateRecordForAdd(leaveHistory.getEmployeeId(), leaveHistory.getCustomerId(), leaveHistory.getLeaveType(), leaveHistory.getDayCount());
			}
			leaveHistory.setLeaveStatus("canceled");
			leaveHostoryRepository.save(leaveHistory);
		}
	}
	
	
	@Override
	public void updateLeaveHistoryBySupervisor(int leaveHistoryId, String approval_id, String leaveStatus, String statusReason) {
		LeaveHistory leaveHistory = leaveHostoryRepository.findOne(leaveHistoryId);
		if(leaveHistory != null) {
			Date currentDate = new Date();
			leaveHistory.setApprovedDate(currentDate);
			leaveHistory.setLeaveReason(statusReason);
			leaveHistory.setLeaveStatus(leaveStatus);
			leaveHistory.setAprovedBy(approval_id);
			
			if(leaveStatus.equals("approved")) {
				LeavebalanceService.updateRecordForDeduct(leaveHistory.getEmployeeId(), leaveHistory.getCustomerId(), leaveHistory.getLeaveType(), leaveHistory.getDayCount());
			} 
			leaveHostoryRepository.save(leaveHistory);
		}
	}

	@Override
	public List<LeaveHistory> getAllLeaveHistoryForLead(String customerId, String employeeID) {
		return leaveHostoryRepository.findByCustomerIdAndApprovedByAndLeaveStatus(customerId, employeeID, "pending");
	}

	@Override
	public void updateLeaveHistory(String leaveHistoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String addNewLeave(LeaveHistory leaveHistory) {
		LeaveBalance leaveBalance = LeavebalanceService.getRecordsByType(leaveHistory.getEmployeeId(), leaveHistory.getCustomerId(), leaveHistory.getLeaveType());
		if(leaveBalance != null) {
			if(leaveBalance.getLeaveBalance() < leaveHistory.getDayCount()) {
				return "Not Sufficient leave balance left for this catagory";
			}
		}
		LeaveHistory newObj = leaveHostoryRepository.save(leaveHistory);
		if(newObj != null) {
				return "Your leave approval request has been placed successfully";
		} else {
			return "Something went wrong";
		}
	}
	

}
