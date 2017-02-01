package com.coviam.internalapp.hrms.salary.dto;

import java.io.Serializable;

/**
 * Created by JahnaviSuthar on 27/01/17.
 */
public class SalaryDTO implements Serializable {


    private String customerId;
    private String employeeId;
    private String dateOfChange;
    private String fixedSalary;
    private String variableSalary;
    private String notes;

    public String getCustomerId() {
        return customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDateOfChange() {
        return dateOfChange;
    }

    public String getFixedSalary() {
        return fixedSalary;
    }

    public String getVariableSalary() {
        return variableSalary;
    }

    public String getNotes() {
        return notes;
    }
}
