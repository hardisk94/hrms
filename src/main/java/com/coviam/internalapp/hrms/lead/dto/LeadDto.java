package com.coviam.internalapp.hrms.lead.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by ashwini on 30/01/17.
 */
public class LeadDto implements Serializable{

    private String id;
    private String employeeId;
    private String departmentId;
    private boolean isActive = true;
    private Date startDate;
    private Date endDate = null;


    public LeadDto() {
    }

    public LeadDto(String id, String employeeId, String departmentId, boolean isActive, Date startDate, Date endDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.departmentId = departmentId;
        this.isActive = isActive;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}


