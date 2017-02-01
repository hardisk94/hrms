package com.coviam.internalapp.hrms.skills.DTO;

/**
 * Created by coviam on 27/01/17.
 */
public class InsertDto {

    private String employeeId;
    private String skillType;
    private String description;
    private String customerId;
    private String skillName;
    private String proficiency;

    public InsertDto() {
    }

    public InsertDto(String employeeId, String skillType, String description, String customerId, String skillName, String proficiency) {
        this.employeeId = employeeId;
        this.skillType = skillType;
        this.description = description;
        this.customerId = customerId;
        this.skillName = skillName;
        this.proficiency = proficiency;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
