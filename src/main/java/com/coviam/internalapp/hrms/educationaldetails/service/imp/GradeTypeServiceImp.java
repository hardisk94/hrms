package com.coviam.internalapp.hrms.educationaldetails.service.imp;

import com.coviam.internalapp.hrms.educationaldetails.dao.GradeTypeRepository;
import com.coviam.internalapp.hrms.educationaldetails.entity.GradeType;
import com.coviam.internalapp.hrms.educationaldetails.service.GradeTypeService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by karan on 24/01/17.
 */
@Component
public class GradeTypeServiceImp implements GradeTypeService {

    @Autowired
    GradeTypeRepository gradeTypeDao;

    @Override
    public void addGradeTypeDetails(GradeType gradeType) {
        gradeTypeDao.save(gradeType);
    }

    @Override
    public void deleteGradeTypeDetails(String gradeTypeId) {
        gradeTypeDao.delete(gradeTypeId);
    }

    @Override
    public void updateGradeTypeDetails(GradeType gradeType) {
        gradeTypeDao.save(gradeType);
    }

    @Override
    public List<GradeType> getGradeTypeDetails() {          //done
        return Lists.newArrayList(gradeTypeDao.findAll());
    }

    @Override
    public List<GradeType> getGradeTypeDetailsSingle(String gradeTypeId) {              //done
        return Lists.newArrayList(gradeTypeDao.findById(gradeTypeId));
    }

    @Override
    public GradeType getByGradeTypeId(String gradeTypeId) {
        return gradeTypeDao.findById(gradeTypeId);
    }

}
