package com.coviam.internalapp.hrms.work.service.impl;

import com.coviam.internalapp.hrms.work.dao.VisaRepository;
import com.coviam.internalapp.hrms.work.entity.VisaDetail;
import com.coviam.internalapp.hrms.work.service.VisaDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by coviam on 24/01/17.
 */
@Component
public class VisaDetailServiceImpl implements VisaDetailService {
    @Autowired
    VisaRepository visaRepository;

    @Override
    public List<VisaDetail> getVisaByEmployeeId(String customerId, String employeeId) {
        return visaRepository.findByCustomerIdAndEmployeeId(customerId, employeeId);
    }

    @Override
    public VisaDetail getVisaById(String visaId)
    {
        return visaRepository.findOne(visaId);
    }

    @Override
    public VisaDetail addVisaDetail(VisaDetail visaDetailObj) {
        return visaRepository.save(visaDetailObj);

    }
}
