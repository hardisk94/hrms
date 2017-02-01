package com.coviam.internalapp.hrms.salary.dto;

import java.sql.Date;

/**
 * Created by JahnaviSuthar on 30/01/17.
 */
public class SalaryGetDTO {
    private long fixedSalary;
    private long variableSalary;
    private Date dateOfChange;

    public SalaryGetDTO() {
    }

    public SalaryGetDTO(long fixedSalary, long variableSalary, Date dateOfChange) {
        this.fixedSalary = fixedSalary;
        this.variableSalary = variableSalary;
        this.dateOfChange = dateOfChange;
    }

    public long getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(long fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public long getVariableSalary() {
        return variableSalary;
    }

    public void setVariableSalary(long variableSalary) {
        this.variableSalary = variableSalary;
    }

    public Date getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        this.dateOfChange = dateOfChange;
    }
}
