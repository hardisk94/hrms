package com.coviam.internalapp.hrms.bankdetails.entity;


import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ashwini on 1/23/17.
 */
@Entity
@Table(name = TableUtils.BANK_DETAIL)

public class BankDetail implements Serializable {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name= ColumnUtils.BANKDETAIL_ID)
    private String bankDetailId;
    @Column(name = ColumnUtils.EMPLOYEE_ID)
    private String employeeId;
    @Column(name = ColumnUtils.CUSTOMER_ID)
    private String customerId;
    @Column(name = ColumnUtils.BANK_NAME)
    private String bankName;
    @Column(name = ColumnUtils.BRANCH_NAME)
    private String branchName;
    @Column(name = ColumnUtils.IFSCCODE)
    private String ifscCode;
    @Column(name = ColumnUtils.ACCOUNT_NUMBER)
    private String accountNumber;
    @Column(name = ColumnUtils.ACCOUNT_TYPE)
    private String accountType;
    @Column(name=ColumnUtils.IS_ACTIVE)
    private boolean isActive;

    public BankDetail() {
    }

    public String getBankDetailId() {
        return bankDetailId;
    }

    public void setBankDetailId(String bankDetailId) {
        this.bankDetailId = bankDetailId;
    }

    public boolean isActive() {
        return isActive;
    }



    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getemployeeId() {
        return employeeId;
    }

    public void setemployeeId(String employeeId) {
        this.employeeId = employeeId;
    }



    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


    @Override
    public String toString() {
        return "BankDetail{" +
                "bankDetailId='" + bankDetailId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}