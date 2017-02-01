package com.coviam.internalapp.hrms.variablepayhistory.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Saurabh on 23/01/17.
 */

@Entity
@Table(name = TableUtils.VARIABLE_PAY_HISTORY_TABLE)
public class VariablePay implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.VARIABLE_PAY_ID)
    private String variablePayId;

    @Column(name = ColumnUtils.CUSTOMER_ID)
    private String customerId;

    @Column(name = ColumnUtils.EMPLOYEE_ID)
    private String employeeId;

    @Column(name = ColumnUtils.VARIABLE_PAY_HISTORY_DATE_OF_PAYMENT)
    private Date dateOfPayment;

    @Column(name = ColumnUtils.VARIABLE_PAY_HISTORY_VARIABLE_PAYMENT)
    private long variablePayment;

    @Column(name = ColumnUtils.VARIABLE_PAY_HISTORY_PERCENTAGE_PAID)
    private int percentagePaid;

    @Column(name = ColumnUtils.VARIABLE_PAY_HISTORY_ACTUAL_PAYMENT)
    private long actualPayment;

    @Column(name = ColumnUtils.VARIABLE_PAY_HISTORY_IS_ACTIVE)
    private boolean isActive;

    public VariablePay() {
    }

    public VariablePay(String customerId, String employeeId,
                       Date dateOfPayment, long variablePayment, int percentagePaid, long actualPayment) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.dateOfPayment = dateOfPayment;
        this.variablePayment = variablePayment;
        this.percentagePaid = percentagePaid;
        this.actualPayment = actualPayment;
        this.isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getVariablePayId() {
        return variablePayId;
    }

    public void setVariablePayId(String variablePayId) {
        this.variablePayId = variablePayId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
