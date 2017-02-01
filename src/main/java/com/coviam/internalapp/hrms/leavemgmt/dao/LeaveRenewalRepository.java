package com.coviam.internalapp.hrms.leavemgmt.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveRenewal;

@Repository
public interface LeaveRenewalRepository extends CrudRepository<LeaveRenewal, Integer> {
	public LeaveRenewal findByCustomerId(String customerId);
}
