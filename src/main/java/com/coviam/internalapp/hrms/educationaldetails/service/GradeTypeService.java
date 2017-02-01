package com.coviam.internalapp.hrms.educationaldetails.service;

import com.coviam.internalapp.hrms.educationaldetails.entity.GradeType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by karan on 24/01/17.
 */

@Service
public interface GradeTypeService {

    public void addGradeTypeDetails(GradeType gradeType);
    public void deleteGradeTypeDetails(String gradeTypeId);
    public void updateGradeTypeDetails(GradeType gradeType);
    public List<GradeType> getGradeTypeDetails();
    public List<GradeType> getGradeTypeDetailsSingle(String gradeTypeId);
    GradeType getByGradeTypeId(String gradeTypeId);
}
