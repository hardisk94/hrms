package com.coviam.internalapp.hrms.employee.dto;

import java.io.Serializable;

/**
 * Created by Hardik on 27/01/17.
 */

// DTO for employee basic details...

public class EmployeeBasicDto implements Serializable {
    private String employeeId;
    private String customerId;
    private String employeeName;
    private String dateOfJoining;
    private byte[] image;
    private String bloodGroup;
    private String phoneNumber;
    private String emailId;
    private String type;
    private String departmentName;
    private String designationName;
    private String designationDesc;
    private String roleResponsibilities;
    private String criteriaForNextPromotion;
    private String higherStudy;

    public EmployeeBasicDto() {
    }

    public EmployeeBasicDto(String employeeId, String customerId, String employeeName, String dateOfJoining, byte[] image, String bloodGroup, String phoneNumber, String emailId, String type, String departmentName, String designationName, String designationDesc, String roleResponsibilities, String criteriaForNextPromotion, String higherStudy) {
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.employeeName = employeeName;
        this.dateOfJoining = dateOfJoining;
        this.image = image;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.type = type;
        this.departmentName = departmentName;
        this.designationName = designationName;
        this.designationDesc = designationDesc;
        this.roleResponsibilities = roleResponsibilities;
        this.criteriaForNextPromotion = criteriaForNextPromotion;
        this.higherStudy = higherStudy;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getDesignationDesc() {
        return designationDesc;
    }

    public void setDesignationDesc(String designationDesc) {
        this.designationDesc = designationDesc;
    }

    public String getRoleResponsibilities() {
        return roleResponsibilities;
    }

    public void setRoleResponsibilities(String roleResponsibilities) {
        this.roleResponsibilities = roleResponsibilities;
    }

    public String getCriteriaForNextPromotion() {
        return criteriaForNextPromotion;
    }

    public void setCriteriaForNextPromotion(String criteriaForNextPromotion) {
        this.criteriaForNextPromotion = criteriaForNextPromotion;
    }

    public String getHigherStudy() {
        return higherStudy;
    }

    public void setHigherStudy(String higherStudy) {
        this.higherStudy = higherStudy;
    }
}