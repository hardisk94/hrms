package com.coviam.internalapp.hrms.skills.dao;

import com.coviam.internalapp.hrms.skills.entity.Skills;

import java.util.List;

/**
 * Created by coviam on 25/01/17.
 */
public interface CustomeSkillRepository {
    //Find the list of skills by employee id.
    public List<Skills> findByEmployeeIdAndCustomerId(String employeeId, String customerId);

    //Find the list of employee names by skill type.
    public List<Skills> findByCustomerIdAndSkillName(String customerId,String skillName);

    //Find the list of skills of the employee by skill type.
    public List<Skills> findBySkillTypeAndEmployeeId(String skillType, String employeeId);
}
