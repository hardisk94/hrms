package com.coviam.internalapp.hrms.educationaldetails.dto;

import com.coviam.internalapp.hrms.skills.DTO.SkillDto;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by karan on 27/01/17.
 */
public class QualificationDto implements Serializable{

    private String degree;
    private String institute;
    private Date dateOfJoining;
    private Date graduationDate;
    private float grade;
    private String educationType;
    private String employeeId;

    private String name;
    private String proficiency;
    private String description;
    private String type;

    public QualificationDto() {
    }

    public QualificationDto(String degree, String institute, Date dateOfJoining, Date graduationDate, float grade, String educationType, String employeeId, String name, String proficiency, String description, String type) {
        this.degree = degree;
        this.institute = institute;
        this.dateOfJoining = dateOfJoining;
        this.graduationDate = graduationDate;
        this.grade = grade;
        this.educationType = educationType;
        this.employeeId = employeeId;
        this.name = name;
        this.proficiency = proficiency;
        this.description = description;
        this.type = type;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
