package com.coviam.internalapp.hrms.skills.services;

import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.skills.dao.SkillsRepository;
import com.coviam.internalapp.hrms.skills.entity.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SkillServiceImpl implements SkillServices {
    @Autowired
    SkillsRepository SkillsRep;


    @Override
    public List<Skills> getByEmpidAndCustId(String empId, String custId) {

        if (empId == null) {
            return null;
        }

        List<Skills> skillsList = SkillsRep.findByEmployeeIdAndCustomerId(empId, custId);
        return skillsList;
    }


    @Override
    public List<Skills> getByObject(Employee employee) {
        if (employee == null) {
            return null;
        }

        List<Skills> skillsList = SkillsRep.findByEmployeeIdAndCustomerId(employee.getEmployeeId(), employee.getCustomerId());
        return skillsList;
    }


    @Override
    public Skills insertBySkillTypeAndSkillName(String skillType, String employeeId, String description, String customerId, String skillName, String proficiency) {
        Skills skill = new Skills(employeeId, skillType, description, customerId, skillName, proficiency);
        return SkillsRep.save(skill);
    }

    @Override
    public List<Skills> getEmployeesByCustomerIdAndSkillName(String customerId, String skillName) {
        if (skillName == null) {
            return null;
        }
        List<Skills> listEmployee = SkillsRep.findByCustomerIdAndSkillName(customerId,skillName);
        return listEmployee;
    }

    @Override
    public Skills deleteSkillByEmployeeIdAndSkillName(String employeeId, String customerId, String skillName) {
        List<Skills> skillsList = SkillsRep.findByEmployeeIdAndCustomerId(employeeId, customerId);
        if(skillsList == null){
            return new Skills("2","1","1","1","1","1");
        }
        for (int i = 0; i < skillsList.size(); i++) {
            if (skillsList.get(i).getSkillName() == skillName) {
                SkillsRep.delete(skillsList.get(i));
                return skillsList.get(i);
            }
        }
        return new Skills("1","1","1","1","1","1");
    }

    @Override
    public Skills updateSkillNameByEmployeeId(String employeeID, String customerId, String originalSkillName, String newSkillName) {
        List<Skills> skillsList = SkillsRep.findByEmployeeIdAndCustomerId(employeeID, customerId);
        for (int i = 0; i < skillsList.size(); i++) {
            if (skillsList.get(i).getSkillName().equals(originalSkillName)) {
                Skills skill =skillsList.get(i);
                skill.setSkillName(newSkillName);
                return SkillsRep.save(skill);
            }
        }
        return null;
    }


    @Override
    public List<Skills> listSkillsByEmployeeIdAndSkillType(String employeeId, String custId, String skillType) {
        List<Skills> skillsList = SkillsRep.findBySkillTypeAndEmployeeId(skillType, employeeId);
        return skillsList;
    }

    @Override
    public Skills updateSkillProficiencyByNameAndType(String empId, String skillName, String skillType, String proficiency){
        List<Skills> skillsList = SkillsRep.findBySkillTypeAndEmployeeId(skillType, empId);
        if(skillsList.size()== 0){
            return new Skills("0","0","0","0","0","0");
        }
        for (int i = 0; i <skillsList.size() ; i++) {
            if(skillsList.get(i).getSkillName() == skillName){
                skillsList.get(i).setProficiency(proficiency);
                SkillsRep.save(skillsList.get(i));
                return skillsList.get(i);
            }
        }
        return new Skills("1","1", "1","1","1","1");

    }

}
