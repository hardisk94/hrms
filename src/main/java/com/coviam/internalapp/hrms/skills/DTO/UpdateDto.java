package com.coviam.internalapp.hrms.skills.DTO;

/**
 * Created by HARSHIL on 27/01/17.
 */
public class UpdateDto {
    private String employeeId;
    private String customerId;
    private String oldSkillName;
    private String newSkillName;

    public UpdateDto() {
    }

    public UpdateDto(String employeeId, String customerId, String oldSkillName, String newSkillName) {
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.oldSkillName = oldSkillName;
        this.newSkillName = newSkillName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOldSkillName() {
        return oldSkillName;
    }

    public void setOldSkillName(String oldSkillName) {
        this.oldSkillName = oldSkillName;
    }

    public String getNewSkillName() {
        return newSkillName;
    }

    public void setNewSkillName(String newSkillName) {
        this.newSkillName = newSkillName;
    }
}
