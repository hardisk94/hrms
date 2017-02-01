package com.coviam.internalapp.hrms.variablepayhistory.dao;

import com.coviam.internalapp.hrms.variablepayhistory.entity.VariablePay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by JahnaviSuthar on 24/01/17.
 */
@Repository
public interface VariablePayDao extends JpaRepository<VariablePay,String>{

    public List<VariablePay> findByCustomerIdAndEmployeeIdAndIsActive(String customerId,
                                                                      String employeeId, boolean isActive);

    public List<VariablePay> findByCustomerIdAndDateOfPaymentAndIsActive(String customerId,
                                                                         Date dateOfPayment, boolean isActive);

    public VariablePay findByCustomerIdAndEmployeeIdAndDateOfPaymentAndIsActive(String customerId,
                                                                     String employeeId, Date dateOfPayment, boolean isActive);

    public VariablePay findByCustomerIdAndEmployeeIdAndDateOfPayment(String customerId,
                                                                                String employeeId, Date dateOfPayment);

}


