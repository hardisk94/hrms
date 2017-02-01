package com.coviam.internalapp.hrms.bankdetails.service;

import com.coviam.internalapp.hrms.bankdetails.entity.BankDetail;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by ashwini on 24/01/17.
 */


public interface BankDetailService
{   public BankDetail getById(String employeeId);
    public BankDetail addBankDetail(BankDetail bankDetail);
    public List<BankDetail> showBankDetail(String customerId, String employeeId);
    public BankDetail deleteBankDetail(String customerId,String bankDetailId) throws Exception;
    public BankDetail updateBankDetail(BankDetail bankDetail) throws Exception;
    public BankDetail getByEmployeeIdAndCustomerId(String employeeId, String customerId);

}


