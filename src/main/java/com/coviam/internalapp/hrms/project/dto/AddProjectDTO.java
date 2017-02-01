package com.coviam.internalapp.hrms.project.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by coviam on 30/01/17.
 */
public class AddProjectDTO implements Serializable {

    private String name;
    private String projectTypeName;
    private String projectDesc;
    private String startDate;
    private String endDate;
    private String customerId;
    private String employeeId;

    public AddProjectDTO() {
    }

    public AddProjectDTO(String name, String projectTypeName, String projectDesc, String startDate, String endDate, String customerId, String employeeId) {
        this.name = name;
        this.projectTypeName = projectTypeName;
        this.projectDesc = projectDesc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
}
