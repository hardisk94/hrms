package com.coviam.internalapp.hrms.work.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by coviam on 23/01/17.
 */
@Entity
@Table(name = TableUtils.WORK_TABLE)
public class WorkExperience {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.WORK_ID)
    private String id;

    @Column(name = ColumnUtils.WORK_CUSTOMER_ID)
    private String customerId ;

    @Column(name = ColumnUtils.WORK_ORG_NAME)
    private String organizationName;

    @Column(name = ColumnUtils.WORK_EMPLOYEE_ID)
    private String employeeId;

    //link visa details as a different entity with employee
    //@Column(name = ColumnUtils.WORK_VISA_ID)
    //private String visaDetailId;

    @Column(name = ColumnUtils.WORK_OFFICE_LOC_ID)
    private String locationId;

    @Column(name = ColumnUtils.WORK_EMP_STATUS_ID)
    private String statusId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = ColumnUtils.WORK_START_DATE)
    private Date startDate ;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = ColumnUtils.WORK_END_DATE)
    private Date endDate ;

    @Column(name = ColumnUtils.WORK_DESIGNATION)
    private String designation ;



    public WorkExperience() {
    }

    public WorkExperience(String customerId, String organizationName, String employeeId, String locationId, String statusId, Date startDate, Date endDate, String designation) {

        this.customerId = customerId;
        this.organizationName = organizationName;
        this.employeeId = employeeId;
        this.locationId = locationId;
        this.statusId = statusId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.designation = designation;
    }

    public WorkExperience(String id,String customerId, String organizationName, String employeeId, String locationId, String statusId, String designation) {
        this.id = id;
        this.customerId = customerId;
        this.organizationName = organizationName;
        this.employeeId = employeeId;
        this.locationId = locationId;
        this.statusId = statusId;
        this.designation = designation;
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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
