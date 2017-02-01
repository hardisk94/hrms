package com.coviam.internalapp.hrms.educationaldetails.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by karan on 27/01/17.
 */
public class InsertDto implements Serializable {

    private String degree;
    private String institute;
    private Date startDate;
    private Date endDate;
    private float grade;
    private String educationType;
    private String document;
    private String employeeId;
    private String gradeTypeId;

    public String getGradeTypeId() {
        return gradeTypeId;
    }

    public void setGradeTypeId(String gradeTypeId) {
        this.gradeTypeId = gradeTypeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public InsertDto(){

    }

    public InsertDto(String employeeId, String degree, String institute, Date startDate, Date endDate, float grade, String educationType, String document){
        this.degree=degree;
        this.employeeId=employeeId;
        this.institute=institute;
        this.startDate=startDate;
        this.endDate=endDate;
        this.grade=grade;
        this.educationType=educationType;
        this.document=document;
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

    public String getStartDate() {
        return startDate.toString();
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate.toString();
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
