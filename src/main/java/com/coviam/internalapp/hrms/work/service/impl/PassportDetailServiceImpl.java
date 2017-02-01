package com.coviam.internalapp.hrms.work.service.impl;

import com.coviam.internalapp.hrms.work.dao.PassportRepository;
import com.coviam.internalapp.hrms.work.entity.PassportDetails;
import com.coviam.internalapp.hrms.work.service.PassportDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by coviam on 24/01/17.
 */
@Component
public class PassportDetailServiceImpl implements PassportDetailService {

    @Autowired
    PassportRepository passportRepository;

    @Override
    public PassportDetails getPassportById(String passportId) {
        return passportRepository.findOne(passportId);
    }

    @Override
    public PassportDetails addPassportDetails(PassportDetails passportDetail) {
        return passportRepository.save(passportDetail);

    }

    @Override
    public PassportDetails updatePassport(PassportDetails passportDetailsObj) throws  Exception {
        if(passportDetailsObj==null)
            throw new Exception("Passport object is empty");
        else{
            passportDetailsObj.setActive(true);
            return passportRepository.save(passportDetailsObj);}
    }
}
