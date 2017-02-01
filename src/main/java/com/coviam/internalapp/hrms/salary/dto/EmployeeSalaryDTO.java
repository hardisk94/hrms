package com.coviam.internalapp.hrms.salary.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by coviam on 27/01/17.
 */
public class EmployeeSalaryDTO implements Serializable {
    private String employeeId;

    private String currentFixedSalary;
    private String currentVariableSalary;
    private String previousFixedSalary;
    private String previousVariableSalary;

    private List<VariablePayHistory> variablePayHistories;

    public EmployeeSalaryDTO() {
    }

    public EmployeeSalaryDTO(String employeeId, String currentFixedSalary, String currentVariableSalary, String previousFixedSalary, String previousVariableSalary, List<VariablePayHistory> variablePayHistories) {
        this.employeeId = employeeId;
        this.currentFixedSalary = currentFixedSalary;
        this.currentVariableSalary = currentVariableSalary;
        this.previousFixedSalary = previousFixedSalary;
        this.previousVariableSalary = previousVariableSalary;
        this.variablePayHistories = variablePayHistories;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCurrentFixedSalary() {
        return currentFixedSalary;
    }

    public void setCurrentFixedSalary(String currentFixedSalary) {
        this.currentFixedSalary = currentFixedSalary;
    }

    public String getCurrentVariableSalary() {
        return currentVariableSalary;
    }

    public void setCurrentVariableSalary(String currentVariableSalary) {
        this.currentVariableSalary = currentVariableSalary;
    }

    public String getPreviousFixedSalary() {
        return previousFixedSalary;
    }

    public void setPreviousFixedSalary(String previousFixedSalary) {
        this.previousFixedSalary = previousFixedSalary;
    }

    public String getPreviousVariableSalary() {
        return previousVariableSalary;
    }

    public void setPreviousVariableSalary(String previousVariableSalary) {
        this.previousVariableSalary = previousVariableSalary;
    }

    public List<VariablePayHistory> getVariablePayHistories() {
        return variablePayHistories;
    }

    public void setVariablePayHistories(List<VariablePayHistory> variablePayHistories) {
        this.variablePayHistories = variablePayHistories;
    }
}
