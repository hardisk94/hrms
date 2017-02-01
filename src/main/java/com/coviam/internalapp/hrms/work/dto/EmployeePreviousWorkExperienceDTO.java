package com.coviam.internalapp.hrms.work.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by coviam on 27/01/17.
 */
public class EmployeePreviousWorkExperienceDTO implements Serializable {

    private String employeeId;
    private List<PreviousExperienceDTO> previousExperienceDTOS;

    public EmployeePreviousWorkExperienceDTO() {

    }

    public EmployeePreviousWorkExperienceDTO(String employeeId, List<PreviousExperienceDTO> previousExperienceDTOS) {
        this.employeeId = employeeId;
        this.previousExperienceDTOS = previousExperienceDTOS;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<PreviousExperienceDTO> getPreviousExperienceDTOS() {
        return previousExperienceDTOS;
    }

    public void setPreviousExperienceDTOS(List<PreviousExperienceDTO> previousExperienceDTOS) {
        this.previousExperienceDTOS = previousExperienceDTOS;
    }
}
