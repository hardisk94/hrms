package com.coviam.internalapp.hrms.work.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by coviam on 27/01/17.
 */
public class PreviousExperienceDTO implements Serializable {

    private String organizationName;
    private String designation;
    private Date startDate;
    private Date endDate;

    public PreviousExperienceDTO() {
    }

    public PreviousExperienceDTO(String organizationName, String designation, Date startDate, Date endDate) {
        this.organizationName = organizationName;
        this.designation = designation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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
