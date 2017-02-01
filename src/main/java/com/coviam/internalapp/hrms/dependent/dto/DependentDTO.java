package com.coviam.internalapp.hrms.dependent.dto;

import java.io.Serializable;

/**
 * Created by JahnaviSuthar on 27/01/17.
 */
public class DependentDTO implements Serializable{

    private String customerId;
    private String employeeId;
    private String dependentFirstName;
    private String dependentMiddleName;
    private String dependentLastName;
    private String dateOfBirth;
    private String dependentGender;
    private String dependentRelation;

    public String getCustomerId() {
        return customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDependentFirstName() {
        return dependentFirstName;
    }

    public String getDependentMiddleName() {
        return dependentMiddleName;
    }

    public String getDependentLastName() {
        return dependentLastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDependentGender() {
        return dependentGender;
    }

    public String getDependentRelation() {
        return dependentRelation;
    }
}
