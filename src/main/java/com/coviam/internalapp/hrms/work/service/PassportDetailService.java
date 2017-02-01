package com.coviam.internalapp.hrms.work.service;

import com.coviam.internalapp.hrms.work.entity.PassportDetails;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * Created by coviam on 24/01/17.
 */
@Service
public interface PassportDetailService {
    PassportDetails getPassportById(String passportId);
    PassportDetails addPassportDetails(PassportDetails passportDetails);
    PassportDetails updatePassport(PassportDetails passportDetailsObj) throws Exception;

}
