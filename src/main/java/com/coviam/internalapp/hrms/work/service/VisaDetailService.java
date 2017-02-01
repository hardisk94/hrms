package com.coviam.internalapp.hrms.work.service;

import com.coviam.internalapp.hrms.work.entity.VisaDetail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by coviam on 24/01/17.
 */
@Service
public interface VisaDetailService {
    VisaDetail getVisaById(String visaId);
    VisaDetail addVisaDetail(VisaDetail visaDetailObj);
    List<VisaDetail> getVisaByEmployeeId(String customerId, String employeeId);
}
