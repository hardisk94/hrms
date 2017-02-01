package com.coviam.internalapp.hrms.generalutil.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;

@Service
public interface GeneralUtilService {

	public List<LeaveHistory> getAllSubordinates();
		
}
