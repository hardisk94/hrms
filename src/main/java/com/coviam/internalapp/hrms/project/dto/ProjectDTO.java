package com.coviam.internalapp.hrms.project.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by coviam on 27/01/17.
 */
public class ProjectDTO implements Serializable {
    private String id;
    private String name;
    private ProjectTypeDTO projectTypeObj;
    private String projectDesc;
    private Date startDate;
    private Date endDate;


    public ProjectDTO() {
    }

    public ProjectDTO(String id, String name, ProjectTypeDTO projectTypeObj, String projectDesc, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.projectTypeObj = projectTypeObj;
        this.projectDesc = projectDesc;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectTypeDTO getProjectTypeObj() {
        return projectTypeObj;
    }

    public void setProjectTypeObj(ProjectTypeDTO projectTypeObj) {
        this.projectTypeObj = projectTypeObj;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
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
