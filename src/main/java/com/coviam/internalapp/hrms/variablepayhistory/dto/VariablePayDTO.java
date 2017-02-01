package com.coviam.internalapp.hrms.variablepayhistory.dto;

import java.io.Serializable;

/**
 * Created by JahnaviSuthar on 26/01/17.
 */
public class VariablePayDTO implements Serializable {

    private String customerId;
    private String employeeId;
    private String dateOfPayment;
    private String variablePayment;
    private String percentagePaid;

    public String getCustomerId() {
        return customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public String getVariablePayment() {
        return variablePayment;
    }

    public String getPercentagePaid() {
        return percentagePaid;
    }
}
