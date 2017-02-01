package com.coviam.internalapp.hrms.educationaldetails.service.imp;

import com.coviam.internalapp.hrms.educationaldetails.dao.EducationalDetailsRepository;
import com.coviam.internalapp.hrms.educationaldetails.dto.InsertDto;
import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import com.coviam.internalapp.hrms.educationaldetails.service.EducationalDetailsService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * Created by karan on 24/01/17.
 */
@Component
public class EducationDetailsServiceImp implements EducationalDetailsService{

    @Autowired
    EducationalDetailsRepository eduDetailsDao;

    /*@Override
    public void addEducationDetails(InsertDto insertDto) {            //done
        eduDetailsDao.save(insertDto);
    }*/

    /*@Override
    public void addEducationDetails(String degree, String educationType, String endDate, float grade, String institute, String startDate, String gradeTypeId) {
        EducationalDetails educationalDetails = new EducationalDetails();
        educationalDetails.setDegree(degree);
        educationalDetails.setEducationType(educationType);
        educationalDetails.setGraduationDate(endDate);
        educationalDetails.setGrade(grade);
        educationalDetails.setInstitute(institute);
        educationalDetails.setDateOfJoining(startDate);
        educationalDetails.setGradeTypeId(gradeTypeId);
        eduDetailsDao.save(educationalDetails);
    }*/


    @Override
    public void addEducationDetails(EducationalDetails educationalDetails) {
        eduDetailsDao.save(educationalDetails);
    }

    @Override
    public void updateEducationDetails(EducationalDetails educationalDetails) {

        eduDetailsDao.save(educationalDetails);
    }

    @Override
    public void deleteEducationDetailsSingle(String customerId,String employeeId) {                   //done
        eduDetailsDao.delete(eduDetailsDao.findByCustomerIdAndEmployeeId(customerId,employeeId));
    }

    @Override
    public void deleteByEduDetailAndDegree(String customerId,String employeeId, String degree) {                  //done
        eduDetailsDao.delete(eduDetailsDao.findByCustomerIdAndEmployeeIdAndDegree(customerId,employeeId, degree));
    }

    @Override
    public EducationalDetails getByEmployeeIdAndDegree(String customerId,String employeeId, String degree) {
        return eduDetailsDao.findByCustomerIdAndEmployeeIdAndDegree(customerId, employeeId, degree);
    }



    /*@Override
    public EducationalDetails getByEmployeeId(String employeeId) {
        return eduDetailsDao.findByEmployeeId1(employeeId);
    }*/

    @Override
    public List<EducationalDetails> getHigherStudy(String customerId, String employeeId) {
        return eduDetailsDao.findByCustomerIdAndEmployeeIdOrderByGraduationDateDesc(customerId, employeeId);
    }

    @Override
    public List<EducationalDetails> getEducationDetails() {             //done
        return Lists.newArrayList(eduDetailsDao.findAll());
    }

    @Override
    public List<EducationalDetails> getEducationDetailsSingle(String customerId,String employeeId) {              //done
        return Lists.newArrayList(eduDetailsDao.findByCustomerIdAndEmployeeId(customerId,employeeId));
    }


}
