package com.coviam.internalapp.hrms.skills.services;

import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.skills.entity.Skills;

import java.util.List;
public interface SkillServices {

    //Lists all the skills of a particular employee searched by sending the employee object.
    public List<Skills> getByObject(Employee employee);


    //Lists all the skills of a particular employee searched by sending the employee id.
    public List<Skills> getByEmpidAndCustId(String empid, String custId);


    //Inserts into the table the sets of skills inserted
    public Skills insertBySkillTypeAndSkillName(String skillType, String EmployeeID, String description, String customerId, String SkillName, String proficiency);


    //Lists the employees who have a particular skill type.
    public List<Skills> getEmployeesByCustomerIdAndSkillName(String customerId, String skillName);


    //deletes the skill type of a particular employee.
    public Skills deleteSkillByEmployeeIdAndSkillName(String employeeId, String custId, String skillName);


    //updates the skill type from a previous skill type.
    public Skills updateSkillNameByEmployeeId(String employeeID,String custId, String originalSkillName, String newSkillName);


    //Lists the skills of an employee based on the skilltype and employee and customer id
    public List<Skills> listSkillsByEmployeeIdAndSkillType(String employeeId, String custId, String skillType);


    //Update profeciency of a skill of an employee
    public Skills updateSkillProficiencyByNameAndType(String employeeId, String skillName, String skillType, String proficiency);
}