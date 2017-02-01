package com.coviam.internalapp.hrms.salary.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by coviam on 27/01/17.
 */
public class VariablePayHistory implements Serializable {
    private Date dateOfPayment;
    private String variablePayment;
    private String percentagePayout;
    private String actualPaymentBeforeTax;

    public VariablePayHistory() {
    }

    public VariablePayHistory(Date dateOfPayment, String variablePayment, String percentagePayout, String actualPaymentBeforeTax) {
        this.dateOfPayment = dateOfPayment;
        this.variablePayment = variablePayment;
        this.percentagePayout = percentagePayout;
        this.actualPaymentBeforeTax = actualPaymentBeforeTax;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getVariablePayment() {
        return variablePayment;
    }

    public void setVariablePayment(String variablePayment) {
        this.variablePayment = variablePayment;
    }

    public String getPercentagePayout() {
        return percentagePayout;
    }

    public void setPercentagePayout(String percentagePayout) {
        this.percentagePayout = percentagePayout;
    }

    public String getActualPaymentBeforeTax() {
        return actualPaymentBeforeTax;
    }

    public void setActualPaymentBeforeTax(String actualPaymentBeforeTax) {
        this.actualPaymentBeforeTax = actualPaymentBeforeTax;
    }
}
