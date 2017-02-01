package com.coviam.internalapp.hrms.employee.dto;

import com.coviam.internalapp.hrms.dependent.entity.Dependent;

import java.util.List;

/**
 * Created by Hardik on 29/01/17.
 */

// DTO for Employee Dependent Details...

public class EmployeeDependentDto {
    private String employeeId;
    private Integer noOfMember;
    private List<Dependent> dependentsList;

    public EmployeeDependentDto() {
    }

    public EmployeeDependentDto(String employeeId, List<Dependent> dependentsList) {
        this.employeeId = employeeId;
        this.dependentsList = dependentsList;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Integer getNoOfMember() {
        return noOfMember;
    }

    public void setNoOfMember(Integer noOfMember) {
        this.noOfMember = noOfMember;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<Dependent> getDependentsList() {
        return dependentsList;
    }

    public void setDependentsList(List<Dependent> dependentsList) {
        this.dependentsList = dependentsList;
    }
}
