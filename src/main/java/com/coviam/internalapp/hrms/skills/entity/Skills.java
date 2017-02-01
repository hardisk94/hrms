package com.coviam.internalapp.hrms.skills.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = TableUtils.SKILLS)
public class Skills{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.SKILLS_ID)
    private String skillsId;

    @Column(name = ColumnUtils.EMPLOYEE_ID)
    private String employeeId;

    @Column(name = ColumnUtils.SKILL_TYPE)
    private String skillType;
    @Column(name = ColumnUtils.DESCRIPTION)
    private String description;

    @Column (name = ColumnUtils.CUSTOMER_ID)
    private String customerId;

    @Column (name = ColumnUtils.SKILL_NAME)
    private String skillName;

    @Column(name = ColumnUtils.SKILL_PROFICIENCY)
    private String proficiency;

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }



    public String getEmployeeId() {
        return employeeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Skills(){

    }

    public Skills(String EmployeeId, String SkillType, String Description, String customerId, String skillName, String proficiency){
        this.employeeId = EmployeeId;
        this.skillType = SkillType;
        this.description = Description;
        this.customerId = customerId;
        this.skillName = skillName;
        this.proficiency = proficiency;
    }

    public String getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(String skillsId) {
        this.skillsId = skillsId;
    }
}