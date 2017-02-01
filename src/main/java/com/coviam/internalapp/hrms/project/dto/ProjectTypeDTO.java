package com.coviam.internalapp.hrms.project.dto;

import java.io.Serializable;

/**
 * Created by coviam on 29/01/17.
 */
public class ProjectTypeDTO implements Serializable{

    private String name;

    private String id;

    public ProjectTypeDTO() {
    }

    public ProjectTypeDTO(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
