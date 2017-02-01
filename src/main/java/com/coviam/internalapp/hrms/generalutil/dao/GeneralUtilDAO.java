package com.coviam.internalapp.hrms.generalutil.dao;

import java.util.List;

import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;

public interface GeneralUtilDAO {
	
	public List<LeaveHistory> findAll();
}
