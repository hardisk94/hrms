package com.coviam.internalapp.hrms.bankdetails.dto;

/**
 * Created by Hardik on 27/01/17.
 */

// DTO for employee bank details...


public class BankDetailsDto {
    private String bankName;
    private String branchName;
    private String ifscCode;
    private String accountNumber;
    private String accountType;
    private String bankDetailId;
    private String customerId;
    private String employeeId;

    public BankDetailsDto() {
    }

    public BankDetailsDto(String bankName, String branchName, String ifscCode, String accountNumber, String accountType, String bankDetailId, String customerId, String employeeId) {
        this.bankName = bankName;
        this.branchName = branchName;
        this.ifscCode = ifscCode;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.bankDetailId = bankDetailId;
        this.customerId = customerId;
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

    public String getBankDetailId() {
        return bankDetailId;
    }

    public void setBankDetailId(String bankDetailId) {
        this.bankDetailId = bankDetailId;
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
}
