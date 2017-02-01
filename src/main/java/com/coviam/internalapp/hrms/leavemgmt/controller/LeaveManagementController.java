package com.coviam.internalapp.hrms.leavemgmt.controller;


import java.text.ParseException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coviam.internalapp.hrms.generalutil.service.GeneralUtilService;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveBalance;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveRenewal;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveType;
import com.coviam.internalapp.hrms.leavemgmt.service.LeaveBalanceService;
import com.coviam.internalapp.hrms.leavemgmt.service.LeaveHistoryService;
import com.coviam.internalapp.hrms.leavemgmt.service.LeaveRenewalService;
import com.coviam.internalapp.hrms.leavemgmt.service.LeaveTypeService;
import com.coviam.internalapp.hrms.leavemgmt.view.entity.LeaveHistoryDto;
import com.coviam.internalapp.hrms.leavemgmt.adapter.LeaveManagementAdapter;


@CrossOrigin
@RestController
public class LeaveManagementController {
	
	
	@Autowired
	private LeaveBalanceService leaveBalanceService;
	
	@Autowired
	private LeaveHistoryService leaveHistoryService;
	
	@Autowired
	private LeaveRenewalService leaveRenewalService;
	
	@Autowired
	private LeaveTypeService leaveTypeService;
	
	@Autowired
	private GeneralUtilService leadUtilService;
	
	@Autowired
	private LeaveManagementAdapter leaveManagementAdapter;
	
	
	
	@RequestMapping("/getAllLeaveHistory") 
	public void getAllLeaveHistory() {
		List<LeaveHistory> list  = leadUtilService.getAllSubordinates();
		System.out.println(list.size());
		
	}
	
	
	@RequestMapping("/newEmployee/{employeeId}/{customerId}")
	public void addLeaveBalanceForFirstTime(@PathVariable String employeeId, @PathVariable String customerId){
		leaveBalanceService.addLeaveBalanceForFirstTime(employeeId, customerId);
	}
	
	
	@RequestMapping("/checkSpecificLeaveBalance/{employeeId}/{customerId}/{leaveType}") 
	public LeaveBalance getAllLeaveBalance(@PathVariable String employeeId, @PathVariable String customerId, @PathVariable String leaveType) {
		return leaveBalanceService.getRecordsByType(employeeId, customerId, leaveType);
	}
	
	
	@RequestMapping("/applyLeave/{employeeId}/{customerId}") 
	public List<LeaveBalance> getAllLeaveBalance(@PathVariable String employeeId, @PathVariable String customerId) {
		return leaveBalanceService.getAllRecords(employeeId, customerId);
	}
	
	@RequestMapping("/applyForLeave/{employeeId}/{customerId}/{fromdate}/{todate}/{daycount}/{leaveType}/{leaveReason}") 
	public void  addLeaveHistory(@PathVariable String employeeId, @PathVariable String customerId,  @PathVariable String fromdate,
			@PathVariable String todate, @PathVariable Integer daycount, @PathVariable String leaveType, @PathVariable String leaveReason) {
			leaveHistoryService.addLeaveHistory(employeeId, customerId, fromdate, todate, daycount, leaveType, leaveReason);
	}
	
	
	@RequestMapping(value= "/applyLeave" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public String applyLeave(LeaveHistoryDto leaveHistoryDto) throws ParseException {
		LeaveHistory leaveHistory  = leaveManagementAdapter.convertToEntity(leaveHistoryDto);
		return leaveHistoryService.addNewLeave(leaveHistory);
	}
	
	
	@RequestMapping("/getAllLeaveHistory/{employeeId}/{customerId}") 
	public List<LeaveHistoryDto> getAllLeaveHistoryForEmployee(@PathVariable String employeeId, @PathVariable String customerId) {
		List<LeaveHistory> leaveHistoryList = leaveHistoryService.getAllLeaveHistoryForEmployee(employeeId, customerId);
		List<LeaveHistoryDto> list =  leaveHistoryList.stream().map(LeaveHistory -> leaveManagementAdapter.convertToDto(LeaveHistory)).collect(Collectors.toList());
		return list;
	}
	
	@RequestMapping("/cancelingLeave/{leaveHistoryId}") 
	public void updateLeaveHistoryForCancel(@PathVariable Integer leaveHistoryId) {
		leaveHistoryService.updateLeaveHistoryForCancel(leaveHistoryId);
	}	
	
	@RequestMapping("/approvalLeave/{leaveHistoryId}/{approved_by}/{leaveStatus}/{statusReason}") 
	public void leaveApproval(@PathVariable int leaveHistoryId, @PathVariable String approved_by, @PathVariable String leaveStatus, @PathVariable String statusReason) {
		leaveHistoryService.updateLeaveHistoryBySupervisor(leaveHistoryId, approved_by, leaveStatus, statusReason);
	}
	
	@RequestMapping("/getAllLeaveforLead/{employeeId}/{customerId}") 
	public void getAllLeaveHistoryForLead(@PathVariable String employeeId, @PathVariable String customerId) {
		leaveHistoryService.getAllLeaveHistoryForLead(customerId, employeeId);
	}
	
	
	@RequestMapping("/getAllLeaveType/{customerId}")
    public List<LeaveType> getAllLeaveType(@PathVariable String customerId){
        return leaveTypeService.getAllLeaveType(customerId);
    }
	
	
	@RequestMapping("/getAllLeaveTypeName/{customerId}")
    public List<String> getLeaveTypeByName(@PathVariable String customerId){
        return leaveTypeService.getLeaveTypeByName(customerId);
    }
	
	/*
	 * Admin chceking renewal month
	 */
	@RequestMapping("/checkRenewalMonth/{customerId}")
	public LeaveRenewal getLeaveRenewal(@PathVariable String customerId) {
		return leaveRenewalService.getLeaveRenewal(customerId);
	}
	
	/*
	 * Admin adding renewal month
	 */
	@RequestMapping("/addRenewalMonth/{customerId}/{renewalMonth}")
	public void  addLeaveRenewal(@PathVariable String customerId, @PathVariable String renewalMonth) {
		leaveRenewalService.addLeaveRenewal(customerId, renewalMonth);
	}
	
}
