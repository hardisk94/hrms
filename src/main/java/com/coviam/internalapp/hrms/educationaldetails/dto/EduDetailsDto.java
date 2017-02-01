package com.coviam.internalapp.hrms.educationaldetails.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by karan on 27/01/17.
 */
public class EduDetailsDto implements Serializable{

    private String degree;
    private String institute;
    private Date dateOfJoining;
    private Date graduationDate;
    private float grade;
    private String educationType;
    private String employeeId;
    private String customerId;
    //private String document;

    EduDetailsDto(){

    }

    public EduDetailsDto(String degree, String institute, Date dateOfJoining,
                         Date graduationDate, float grade, String educationType, String employeeId, String customerId) {
        this.degree = degree;
        this.institute = institute;
        this.dateOfJoining = dateOfJoining;
        this.graduationDate = graduationDate;
        this.grade = grade;
        this.educationType = educationType;
        this.employeeId = employeeId;
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    /*public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }*/
}
