package com.coviam.internalapp.hrms.employee.dto;

import com.coviam.internalapp.hrms.project.dto.ProjectDTO;
import com.coviam.internalapp.hrms.project.entity.Project;

import java.io.Serializable;
import java.util.List;

/**
 * Created by coviam on 27/01/17.
 */
public class EmployeeProjectDTO implements Serializable {

    private String employeeId;

    private List<ProjectDTO> projects;

    public EmployeeProjectDTO() {
    }

    public EmployeeProjectDTO(String employeeId, List<ProjectDTO> projects) {
        this.employeeId = employeeId;
        this.projects = projects;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }
}
