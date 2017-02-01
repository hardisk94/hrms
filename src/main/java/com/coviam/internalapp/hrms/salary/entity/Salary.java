package com.coviam.internalapp.hrms.salary.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/*
 * Created by coviam on 23/01/17.
 */
@Entity
@Table(name = TableUtils.SALARY_TABLE)
public class Salary implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.SALARY_ID)
    private String salaryId;

    @Column(name = ColumnUtils.CUSTOMER_ID)
    private String customerId;

    @Column(name = ColumnUtils.EMPLOYEE_ID)
    private String employeeId;

    @Column(name = ColumnUtils.SALARY_FIXED_SALARY)
    private long fixedSalary;

    @Column(name = ColumnUtils.SALARY_VARIABLE_SALARY)
    private long variableSalary;

    @Column(name = ColumnUtils.SALARY_DATE_OF_CHANGE)
    private Date dateOfChange;

    @Column(name = ColumnUtils.SALARY_PERCENTAGE_CHANGE_IN_FIXED_SALARY)
    private double percentageChange;

    @Column(name = ColumnUtils.SALARY_ABSOLUTE_CHANGE_IN_FIXED_SALARY)
    private long absoluteChange;

    @Column(name = ColumnUtils.SALARY_NOTES)
    private String notes;

    @Column(name = ColumnUtils.SALARY_IS_CURRENT)
    private boolean isCurrent;

    @Column(name = ColumnUtils.SALARY_IS_ACTIVE)
    private boolean isActive;


    public Salary() {

    }

    public Salary(String customerId, String employeeId, long fixedSalary,
                  long variableSalary, Date dateOfChange, double percentageChange,
                  long absoluteChange, String notes) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.fixedSalary = fixedSalary;
        this.variableSalary = variableSalary;
        this.dateOfChange = dateOfChange;
        this.percentageChange = percentageChange;
        this.absoluteChange = absoluteChange;
        this.notes = notes;
        this.isCurrent = true;
        this.isActive = true;
    }


    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
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

    public double getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(double percentageChange) {
        this.percentageChange = percentageChange;
    }

    public long getAbsoluteChange() {
        return absoluteChange;
    }

    public void setAbsoluteChange(long absoluteChange) {
        this.absoluteChange = absoluteChange;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
