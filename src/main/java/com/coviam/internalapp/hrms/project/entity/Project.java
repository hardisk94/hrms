package com.coviam.internalapp.hrms.project.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = TableUtils.PROJECT_TABLE)
public class Project {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.PROJECT_ID)
    private String id;
    @Column(name = ColumnUtils.PROJECT_NAME)
    private String name;

    @Column(name = ColumnUtils.PROJECT_DESC)
    private String projectDesc;

    @Column(name = ColumnUtils.PROJECT_OWNER)
    private String projectOwner;

    @Column(name = ColumnUtils.PROJECT_START_DATE)
    private Date startDate;

    @Column(name = ColumnUtils.PROJECT_END_DATE)
    private Date endDate;

    @Column(name = ColumnUtils.PROJECT_IS_ACTIVE)
    private boolean isActive ;

    @ManyToOne(optional = false)
    @JoinColumn(name = ColumnUtils.PROJECT_TYPE)
    private ProjectType projectTypeObj;

    @Column(name = ColumnUtils.PROJECT_CUST_ID)
    private String customerId;

    public Project() {
    }

    public Project(String name, String projectDesc, String projectOwner,Date startDate,Date endDate, boolean isActive, ProjectType projectTypeObj, String customerId) {
        this.name = name;
        this.projectDesc = projectDesc;
        this.projectOwner = projectOwner;
        this.isActive = isActive;
        this.projectTypeObj = projectTypeObj;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Project(String name, String projectDesc, Date startDate, Date endDate, ProjectType projectTypeObj, String customerId) {
        this.name = name;
        this.projectDesc = projectDesc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectTypeObj = projectTypeObj;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(String projectOwner) {
        this.projectOwner = projectOwner;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ProjectType getProjectTypeObj() {
        return projectTypeObj;
    }

    public void setProjectTypeObj(ProjectType projectTypeObj) {
        this.projectTypeObj = projectTypeObj;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
