package com.coviam.internalapp.hrms.leavemgmt.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveType;


@Repository
public interface LeaveTypeRepository extends CrudRepository<LeaveType,Integer>{
	LeaveType findByLeaveTypeAndCustomerId(String leaveType, String customerId);
	List<LeaveType> findByCustomerId(String customerId);
}
