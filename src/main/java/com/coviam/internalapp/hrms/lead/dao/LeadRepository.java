package com.coviam.internalapp.hrms.lead.dao;

import com.coviam.internalapp.hrms.lead.entity.Lead;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@author Jyothi Prakash
 */

@Repository
public interface LeadRepository extends CrudRepository<Lead,String>{
    //List<Lead> findByemployeeId(String employeeId);
    //List<Lead> findBydepartmentId(String departmentId);
    //Lead findByemployeeIdAndDepartmentId(String employeeId, String departmentId);
}
