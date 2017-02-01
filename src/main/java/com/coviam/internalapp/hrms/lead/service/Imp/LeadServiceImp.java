package com.coviam.internalapp.hrms.lead.service.Imp;

import com.coviam.internalapp.hrms.lead.dao.LeadRepository;
import com.coviam.internalapp.hrms.lead.entity.Lead;
import com.coviam.internalapp.hrms.lead.service.LeadService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *@author Jyothi Prakash
 */
@Service
public class LeadServiceImp implements LeadService{

    @Autowired
    LeadRepository leadRepository;

    @Override
    public void createLead(Lead lead) {
        leadRepository.save(lead);
    }

    @Override
    public void updateLead(Lead lead){
        leadRepository.save(lead);
    }

    @Override
    public List<Lead> getAllLeads(){
        return Lists.newArrayList(leadRepository.findAll());
    }

    /*@Override //to get all employees leading a department
    public List<Lead> getByDeptId(String deptId){
            return Lists.newArrayList(leadRepository.findBydepartmentId(deptId));
    }

    @Override //to fetch all departments lead by an employee
    public List<Lead> getByEmpId(String empId){
        return Lists.newArrayList(
                leadRepository.findByemployeeId(empId));
    }

    @Override //to fetch record by empId and deptId
    public Lead getByEmpIdAndDeptId(String empId, String deptId)
    {
        return leadRepository.findByemployeeIdAndDepartmentId(empId, deptId);
    }*/


}
