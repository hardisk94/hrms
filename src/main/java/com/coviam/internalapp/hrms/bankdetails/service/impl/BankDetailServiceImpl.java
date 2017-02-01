package com.coviam.internalapp.hrms.bankdetails.service.impl;

import com.coviam.internalapp.hrms.bankdetails.dao.BankDetailRepository;
import com.coviam.internalapp.hrms.bankdetails.entity.BankDetail;
import com.coviam.internalapp.hrms.bankdetails.service.BankDetailService;


import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by ashwini on 24/01/17.
 */
@Service
public class BankDetailServiceImpl implements BankDetailService {
    @Autowired
    BankDetailRepository bankDetailRepository;


    @Transactional
    @Override
    public BankDetail addBankDetail(BankDetail bankDetail) {
        bankDetail.setActive(true);
        return bankDetailRepository.save(bankDetail);
    }
    @Transactional
    @Override
    public List<BankDetail> showBankDetail(String customerId, String employeeId) {

        return Lists.newArrayList(bankDetailRepository.findByCustomerIdAndEmployeeId(customerId, employeeId));

    }

    @Transactional
    @Override
    public BankDetail getById(String employeeId)
    {
        return bankDetailRepository.findOne(employeeId);
    }

    @Transactional
    @Override
    public BankDetail deleteBankDetail(String customerId, String bankDetailId) throws Exception {

        BankDetail bankDetail = new BankDetail();
        if(bankDetailId !=null) {
            bankDetail.setActive(false);
            return bankDetailRepository.save(bankDetail);
        }
        throw new Exception("There Are No Details To Delete");

    }
    @Transactional
    @Override
    public BankDetail updateBankDetail(BankDetail bankDetail) throws Exception {
        if (bankDetail != null)
        {
             bankDetail.setActive(true);
            return bankDetailRepository.save(bankDetail);
        }
        throw new Exception("There Are No Records to Update");
    }

    @Override
    public BankDetail getByEmployeeIdAndCustomerId(String employeeId, String customerId) {
        return bankDetailRepository.findByCustomerIdAndEmployeeId(employeeId, customerId);
    }
}






// delete should always be soft .. mark isactive to false
    // all select should always be active records
     //all service apis should have customerId as an input
