package com.coviam.internalapp.hrms.work.service;

import com.coviam.internalapp.hrms.work.entity.WorkExperience;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by coviam on 23/01/17.
 */
@Service
public interface WorkService {
    List<WorkExperience> getAllWorkExperienceOfEmployee(String empId);
    WorkExperience getCurrentWorkExperienceOfEmployee(String empId);
    String getCurrentWorkExperienceOfEmployeeDesignation(String empId);
    List<WorkExperience> getPastWorkExperienceOfEmployee(String empId);
    Boolean addNewWorkExperienceOfEmployee(String empId, String designation,String organizationName,String locationId, String statusId, Date startDate, Date endDate);
    Boolean updateWorkExperienceOfEmployee(String workExperienceId, String designation,String organizationName,String locationId, String statusId, Date startDate, Date endDate);
    WorkExperience getWorkExperienceById(String workId);
}
