package com.coviam.internalapp.hrms.educationaldetails.service;

import com.coviam.internalapp.hrms.educationaldetails.dto.InsertDto;
import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by coviam on 23/01/17.
 */

@Service
public interface EducationalDetailsService {

    //void addEducationDetails(String degree, String educationType, String endDate, float grade, String institute, String startDate, String gradeTypeId);
    public void addEducationDetails(EducationalDetails educationalDetails);

    public void updateEducationDetails(EducationalDetails educationalDetails);

    public List<EducationalDetails> getEducationDetails();

    public List<EducationalDetails> getEducationDetailsSingle(String customerId, String employeeId);

    public void deleteEducationDetailsSingle(String customerId, String employeeId);

    public void deleteByEduDetailAndDegree(String customerId, String employeeId, String degree);

    EducationalDetails getByEmployeeIdAndDegree(String customerId, String employeeId, String degree);

    //EducationalDetails getByEmployeeId(String employeeId);

    List<EducationalDetails> getHigherStudy(String customerId, String employeeId);
}
