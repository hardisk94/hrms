package com.coviam.internalapp.hrms.work.service.impl;

import com.coviam.internalapp.hrms.employee.dao.EmployeeRepository;
import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.work.dao.WorkRepository;
import com.coviam.internalapp.hrms.work.entity.WorkExperience;
import com.coviam.internalapp.hrms.work.service.WorkService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * Created by coviam on 24/01/17.
 */
@Component
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkRepository workRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<WorkExperience> getAllWorkExperienceOfEmployee(String empId) {
        return workRepository.findByEmployeeId(empId);
    }

    @Override
    public WorkExperience getCurrentWorkExperienceOfEmployee(String empId) {
        List<WorkExperience> workExperiences = workRepository.findByEmployeeIdOrderByStartDateDesc(empId);

        Employee employee = employeeRepository.findOne(empId);



        return workExperiences.get(0);
    }

    @Override
    public String getCurrentWorkExperienceOfEmployeeDesignation(String empId) {
        List<WorkExperience> workExperiences = workRepository.findByEmployeeIdOrderByStartDateDesc(empId);

        WorkExperience workExperience = workExperiences.get(0);

        return workExperience.getDesignation();
    }

    @Override
    public List<WorkExperience> getPastWorkExperienceOfEmployee(String empId) {
        List<WorkExperience> workExperiences = workRepository.findByEmployeeIdOrderByStartDateDesc(empId);
        //workExperiences.remove(0);
        return workExperiences;
    }

    @Override
    public Boolean addNewWorkExperienceOfEmployee(String empId, String designation,String organizationName,String locationId, String statusId, Date startDate, Date endDate) {
        WorkExperience workExperience = new WorkExperience("0",organizationName,empId,locationId,statusId,startDate,endDate,designation);
        workRepository.save(workExperience);

        return true;
    }

    @Override
    public Boolean updateWorkExperienceOfEmployee(String workExperienceId, String designation, String organizationName, String locationId, String statusId, Date startDate, Date endDate) {
        WorkExperience workExperience = workRepository.findOne(workExperienceId);
        workExperience.setDesignation(designation);
        workExperience.setOrganizationName(organizationName);
        workExperience.setLocationId(locationId);
        workExperience.setStatusId(statusId);
        workExperience.setStartDate(startDate);
        workExperience.setEndDate(endDate);

        workRepository.save(workExperience);
        return true;
    }

    @Override
    public WorkExperience getWorkExperienceById(String workId) {
        return workRepository.findOne(workId);
    }
}
