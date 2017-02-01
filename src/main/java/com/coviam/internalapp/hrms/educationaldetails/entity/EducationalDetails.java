package com.coviam.internalapp.hrms.educationaldetails.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.sql.Date;
import java.util.Set;

/**
 * Created by coviam on 23/01/17.
 */

@Entity
@Table(name = TableUtils.EDUCATIONAL_DETAIL)
public class EducationalDetails implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.EDUCATION_DETAILS_ID)
    private String id;

    @Column(name = ColumnUtils.EDUCATION_DETAILS_CUSTOMER_ID)
    private String customerId ;

    @Column(name = ColumnUtils.EDUCATION_DETAILS_EDUCATIONTYPE)
    private String educationType;
    @Column(name = ColumnUtils.EMPLOYEE_ID)
    private String employeeId;

    @Column(name = ColumnUtils.EDUCATION_DETAILS_INSTITUTE)
    private String institute;

    @Column(name = ColumnUtils.EDUCATION_DETAILS_ISACTIVE)
    private String isAcvtive;

    @Column(name = ColumnUtils.EDUCATION_DETAILS_DEGREE)
    private String degree;
    @Column(name = ColumnUtils.EDUCATION_DETAILS_DATEOFJOINING)
    private Date dateOfJoining;
    @Column(name = ColumnUtils.EDUCATION_DETAILS_PASSOUTDATE)
    private Date graduationDate;
    @Column(name = ColumnUtils.EDUCATION_DETAILS_GRADE)
    private float grade;
    @Column(name = ColumnUtils.GRADETYPE_ID)
    private String gradeTypeId;

    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getIsAcvtive() {
        return isAcvtive;
    }

    public void setIsAcvtive(String isAcvtive) {
        this.isAcvtive = isAcvtive;
    }

    public EducationalDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDateOfJoining() {
        return dateOfJoining.toString();
    }

    public void setDateOfJoining(String dateOfJoining) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(dateOfJoining);
        //this.setStartDate(sqlDate);

        this.dateOfJoining = sqlDate;
    }

    public String getGraduationDate() {
        return graduationDate.toString();
    }

    public void setGraduationDate(String graduationDate) {
        java.sql.Date sqlDate1 = java.sql.Date.valueOf(graduationDate);
        //tempLead.setStartDate(sqlDate);
        this.graduationDate = sqlDate1;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getGradeTypeId() {
        return gradeTypeId;
    }

    public void setGradeTypeId(String gradeTypeId) {
        this.gradeTypeId = gradeTypeId;
    }



    //private Employee employee;


    /*@ManyToOne
    @JoinColumn(name = ColumnUtils.EMPLOYEE_ID)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }*/

    @ManyToOne
    @JoinColumn(name = ColumnUtils.GRADETYPE_ID, insertable = false, updatable = false)
    GradeType gradeType;

}