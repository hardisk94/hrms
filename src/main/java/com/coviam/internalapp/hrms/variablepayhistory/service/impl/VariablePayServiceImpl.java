package com.coviam.internalapp.hrms.variablepayhistory.service.impl;

import com.coviam.internalapp.hrms.variablepayhistory.dao.VariablePayDao;
import com.coviam.internalapp.hrms.variablepayhistory.dto.VariablePayDTO;
import com.coviam.internalapp.hrms.variablepayhistory.entity.VariablePay;
import com.coviam.internalapp.hrms.variablepayhistory.service.VariablePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

import static java.lang.Math.ceil;


/**
 * Created by JahnaviSuthar on 24/01/17.
 */
@Component
public class VariablePayServiceImpl implements VariablePayService {

    @Autowired
    VariablePayDao variablePayDao;

    @Transactional
    @Override
    public boolean addVariablePay(VariablePayDTO variablePayDTO) {

        String customerId = variablePayDTO.getCustomerId();
        String employeeId = variablePayDTO.getEmployeeId();
        String dateOfPayment = variablePayDTO.getDateOfPayment();
        String variablePayment = variablePayDTO.getVariablePayment();
        String percentagePaid = variablePayDTO.getPercentagePaid();


        if(customerId != null && employeeId != null && dateOfPayment != null
                && variablePayment != null && percentagePaid != null){

            Date date = Date.valueOf(dateOfPayment);
            long varpay = Long.parseLong(variablePayment);
            int percentage = Integer.parseInt(percentagePaid);
            long actualPayment = (long)(ceil(percentage*varpay/100.0));

            VariablePay vp = variablePayDao.findByCustomerIdAndEmployeeIdAndDateOfPaymentAndIsActive(customerId,
                    employeeId,date,true);


            if(vp == null){
                vp = variablePayDao.findByCustomerIdAndEmployeeIdAndDateOfPaymentAndIsActive(customerId,
                        employeeId,date,false);
                if(vp != null){
                    vp.setVariablePayment(varpay);
                    vp.setPercentagePaid(percentage);
                    vp.setActualPayment(actualPayment);
                    vp.setActive(true);
                    variablePayDao.save(vp);
                }
                else {
                    variablePayDao.save(new VariablePay(customerId, employeeId, date,
                            varpay, percentage, actualPayment));
                }
                return true;
            }
        }
        return false;
    }




    @Transactional
    @Override
    public boolean addVariablePay(String customerId, String employeeId, Date dateOfPayment,
                                  long variablePayment, int percentagePaid)/* throws Exception */{


        if(variablePayDao.findByCustomerIdAndEmployeeIdAndDateOfPaymentAndIsActive(customerId,
                employeeId,dateOfPayment,true) == null) {

            VariablePay vp = variablePayDao.findByCustomerIdAndEmployeeIdAndDateOfPaymentAndIsActive(customerId,
                    employeeId,dateOfPayment,false);
            long actualPayment = (long)(ceil(percentagePaid*variablePayment/100.0));
            if(vp != null){
                vp.setVariablePayment(variablePayment);
                vp.setPercentagePaid(percentagePaid);
                vp.setActualPayment(actualPayment);
                vp.setActive(true);
            }
            else {
                variablePayDao.save(new VariablePay(customerId, employeeId, dateOfPayment,
                        variablePayment, percentagePaid, actualPayment));
            }
            return true;
        }
        //throw new Exception("Record already exists.Try to update it.");
        return false;
    }


    @Transactional
    @Override
    public boolean removeVariablePay(String customerId, String employeeId, Date dateOfPayment) /*throws Exception*/ {

        VariablePay vp = variablePayDao.findByCustomerIdAndEmployeeIdAndDateOfPaymentAndIsActive(customerId,
                employeeId,dateOfPayment,true);
        if(vp != null) {
            vp.setActive(false);
            return true;
        }
        //throw new Exception("No such record found");
        return false;
    }



    @Transactional
    @Override
    public boolean updateVariablePay(VariablePayDTO variablePayDTO) /*throws Exception*/ {

        String customerId = variablePayDTO.getCustomerId();
        String employeeId = variablePayDTO.getEmployeeId();
        String dateOfPayment = variablePayDTO.getDateOfPayment();
        String variablePayment = variablePayDTO.getVariablePayment();
        String percentagePaid = variablePayDTO.getPercentagePaid();


        if(customerId != null && employeeId != null && dateOfPayment != null
                && variablePayment != null && percentagePaid != null){

            Date date = Date.valueOf(dateOfPayment);
            long varpay = Long.parseLong(variablePayment);
            int percentage = Integer.parseInt(percentagePaid);
            long actualPayment = (long)(ceil(percentage*varpay/100.0));

            VariablePay vp = variablePayDao.findByCustomerIdAndEmployeeIdAndDateOfPaymentAndIsActive(customerId,
                    employeeId,date,true);

            if(vp != null){
                vp.setVariablePayment(varpay);
                vp.setPercentagePaid(percentage);
                vp.setActualPayment(actualPayment);
                variablePayDao.save(vp);
                return true;
            }
        }
        return false;

    }


    @Transactional
    @Override
    public boolean updateVariablePay(String customerId, String employeeId, Date dateOfPayment,
                                     long variablePayment, int percentagePaid) /*throws Exception*/ {

        VariablePay vp = variablePayDao.findByCustomerIdAndEmployeeIdAndDateOfPaymentAndIsActive(customerId,
                employeeId,dateOfPayment,true);
        if(vp != null) {
            vp.setVariablePayment(variablePayment);
            vp.setPercentagePaid(percentagePaid);
            vp.setActualPayment((long)(ceil((variablePayment * percentagePaid) / 100.0)));
            variablePayDao.save(vp);
            return true;
        }
       // throw new Exception("No such record found");
        return false;
    }

    /*@Transactional
    @Override
    public VariablePay getVariablePay(String employeeId, Date dateOfPayment) {
        return variablePayDao.findByEmployeeIdAndDateOfPayment(employeeId,dateOfPayment);
    }*/

    @Transactional
    @Override
    public List<VariablePay> getByEmployeeId(String customerId, String employeeId) {
        return variablePayDao.findByCustomerIdAndEmployeeIdAndIsActive(customerId,employeeId,true);
    }

    /*@Transactional
    @Override
    public List<VariablePay> getByDateOfPayment(Date dateOfPayment) {
        return variablePayDao.findByDateOfPayment(dateOfPayment);
    }*/
}
