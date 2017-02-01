package com.coviam.internalapp.hrms.lead.service;

import com.coviam.internalapp.hrms.lead.entity.Lead;

import java.util.List;

/**
 *@author Jyothi Prakash
 */
public interface LeadService {

    List<Lead> getAllLeads();
    //List<Lead> getByEmpId(String empId);
    //List<Lead> getByDeptId(String deptId);
    //Lead getByEmpIdAndDeptId(String empId, String deptId);
    void updateLead(Lead lead);
    void createLead(Lead lead);


}
