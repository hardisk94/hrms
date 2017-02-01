package com.coviam.internalapp.hrms.variablepayhistory.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by JahnaviSuthar on 30/01/17.
 */
public class VariablePayGetDTO implements Serializable {

    private Date dateOfPayment;
    private long variablePayment;
    private int percentagePaid;
    private long actualPayment;

    public VariablePayGetDTO() {
    }

    public VariablePayGetDTO(Date dateOfPayment, long variablePayment, int percentagePaid, long actualPayment) {
        this.dateOfPayment = dateOfPayment;
        this.variablePayment = variablePayment;
        this.percentagePaid = percentagePaid;
        this.actualPayment = actualPayment;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public long getVariablePayment() {
        return variablePayment;
    }

    public void setVariablePayment(long variablePayment) {
        this.variablePayment = variablePayment;
    }

    public int getPercentagePaid() {
        return percentagePaid;
    }

    public void setPercentagePaid(int percentagePaid) {
        this.percentagePaid = percentagePaid;
    }

    public long getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(long actualPayment) {
        this.actualPayment = actualPayment;
    }
}
