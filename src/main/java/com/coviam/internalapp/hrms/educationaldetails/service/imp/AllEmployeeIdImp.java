package com.coviam.internalapp.hrms.educationaldetails.service.imp;

import com.coviam.internalapp.hrms.educationaldetails.dao.EducationalDetailsRepository;
import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import com.coviam.internalapp.hrms.educationaldetails.service.AllEmployeeId;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by karan on 30/01/17.
 */

@Component
public class AllEmployeeIdImp implements AllEmployeeId{

    @Autowired
    EducationalDetailsRepository eduDetailsDao;

    @Override
    public List<EducationalDetails> getAllEmployeeId(String customerId) {

        return Lists.newArrayList(eduDetailsDao.findByCustomerId(customerId));
    }
}