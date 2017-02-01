package com.coviam.internalapp.hrms.dependent.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ashwini on 23/01/17.
 */
@Entity
@Table(name = TableUtils.DEPENDENT_TABLE)
public class Dependent {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.DEPENDENT_DEPENDENT_ID)
    private String dependentId;

    @Column(name = ColumnUtils.EMPLOYEE_ID)
    private String employeeId;

    @Column(name = ColumnUtils.CUSTOMER_ID)
    private String customerId;

    @Column(name = ColumnUtils.DEPENDENT_FIRST_NAME)
    private String firstName;

    @Column(name = ColumnUtils.DEPENDENT_MIDDLE_NAME)
    private String middleName;

    @Column(name = ColumnUtils.DEPENDENT_LAST_NAME)
    private String lastName;


    @Column(name = ColumnUtils.DEPENDENT_DATE_OF_BIRTH)
    private Date dateofBirth;

    @Column(name = ColumnUtils.DEPENDENT_DEPENDENT_GENDER)
    private String dependentGender;

    @Column(name = ColumnUtils.DEPENDENT_DEPENDENT_RELATION)
    private String dependentRelation;

    @Column(name = ColumnUtils.DEPENDENT_IS_ACTIVE)
    private boolean isActive;

    public Dependent() {
    }

    public Dependent(String employeeId, String customerId, String firstName, String middleName,
                     String lastName, Date dateofBirth, String dependentGender, String dependentRelation) {
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;
        this.dependentGender = dependentGender;
        this.dependentRelation = dependentRelation;
        this.isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDependentId() {
        return dependentId;
    }

    public void setDependentId(String dependentId) {
        this.dependentId = dependentId;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getDependentGender() {
        return dependentGender;
    }

    public void setDependentGender(String dependentGender) {
        this.dependentGender = dependentGender;
    }

    public String getDependentRelation() {
        return dependentRelation;
    }

    public void setDependentRelation(String dependentRelation) {
        this.dependentRelation = dependentRelation;
    }
}