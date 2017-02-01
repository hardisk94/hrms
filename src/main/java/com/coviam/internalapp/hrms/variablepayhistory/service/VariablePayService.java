package com.coviam.internalapp.hrms.variablepayhistory.service;

import com.coviam.internalapp.hrms.variablepayhistory.dto.VariablePayDTO;
import com.coviam.internalapp.hrms.variablepayhistory.entity.VariablePay;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by JahnaviSuthar on 24/01/17.
 */
@Service
public interface VariablePayService {
    //all the interface have customerId as an additional argument

    public boolean addVariablePay(VariablePayDTO variablePayDTO);

    public boolean addVariablePay(String customerId, String employeeId, Date dateOfPayment,
                                  long variablePayment, int percentagePaid); //throws Exception;

    public boolean removeVariablePay(String customerId, String employeeId, Date dateOfPayment);// throws Exception;

    //remove this
//    public VariablePay getVariablePay(String employeeId, Date dateOfPayment);

    public boolean updateVariablePay(String customerId, String employeeId, Date dateOfPayment,
                                     long variablePayment, int percentagePaid);// throws Exception;

    public List<VariablePay> getByEmployeeId(String customerId, String employeeId);

    public boolean updateVariablePay(VariablePayDTO variablePayDTO);

    //remove
  //  public List<VariablePay> getByDateOfPayment(Date dateOfPayment);

}
