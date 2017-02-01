package com.coviam.internalapp.hrms.generalutil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coviam.internalapp.hrms.generalutil.dao.GeneralUtilDAO;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;

@Component
public class GeneralUtilServiceImpl implements GeneralUtilService{

	@Autowired
	private GeneralUtilDAO leadUtilDAO;

	@Override
	public List<LeaveHistory> getAllSubordinates() {
		return leadUtilDAO.findAll();
	}
	
	
}
