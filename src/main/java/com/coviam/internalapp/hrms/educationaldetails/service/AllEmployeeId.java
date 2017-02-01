package com.coviam.internalapp.hrms.educationaldetails.service;

import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by karan on 30/01/17.
 */

@Service
public interface AllEmployeeId {

    public List<EducationalDetails> getAllEmployeeId(String customerId);
}
