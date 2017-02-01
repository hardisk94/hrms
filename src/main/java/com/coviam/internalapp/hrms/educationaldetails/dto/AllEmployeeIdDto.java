package com.coviam.internalapp.hrms.educationaldetails.dto;

import java.io.Serializable;

/**
 * Created by karan on 30/01/17.
 */
public class AllEmployeeIdDto implements Serializable{

    private String employeeId;

    public AllEmployeeIdDto(){

    }

    public AllEmployeeIdDto(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
