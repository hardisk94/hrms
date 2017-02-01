package com.coviam.internalapp.hrms.dependent.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by coviam on 27/01/17.
 */
public class EmpDependantDTO implements Serializable {

    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private String dependentRelation;
    private String gender;

    public EmpDependantDTO() {
    }

    public EmpDependantDTO(String firstName, String middleName, String lastName, Date dateOfBirth, String dependantRelation, String gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dependentRelation = dependantRelation;
        this.gender = gender;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDependentRelation() {
        return dependentRelation;
    }

    public void setDependentRelation(String dependantRelation) {
        this.dependentRelation = dependantRelation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
