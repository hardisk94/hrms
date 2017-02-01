package com.coviam.internalapp.hrms.project.dto;

import java.io.Serializable;

/**
 * Created by coviam on 30/01/17.
 */
public class UpdateProjectDTO implements Serializable {
    private String id;

    private String name;

    private String type;

    private String startDate;

    private String endDate;


    public UpdateProjectDTO() {
    }

    public UpdateProjectDTO(String id, String name, String type, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}