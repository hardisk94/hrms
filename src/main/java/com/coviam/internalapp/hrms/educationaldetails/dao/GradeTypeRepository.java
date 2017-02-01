package com.coviam.internalapp.hrms.educationaldetails.dao;

import com.coviam.internalapp.hrms.educationaldetails.entity.GradeType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by karan on 24/01/17.
 */
public interface GradeTypeRepository extends CrudRepository<GradeType, String>{

    GradeType findById(String gradeTypeId);
}
