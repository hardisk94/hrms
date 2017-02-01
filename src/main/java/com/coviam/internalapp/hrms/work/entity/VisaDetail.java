package com.coviam.internalapp.hrms.work.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.sql.Date;

/**
 * Created by coviam on 23/01/17.
 */
@Entity
@Table(name = TableUtils.VISA_TABLE)
public class VisaDetail {

    @Id

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.WORK_VISA_ID)
    private String visaId;

    @Column(name = ColumnUtils.WORK_VISA_COUNTRY_NAME)
    private String countryName;

    @Column(name = ColumnUtils.WORK_VISA_VALID_FROM)
    private Date validFrom ;

    @Column(name = ColumnUtils.WORK_VISA_EXPIRY_DATE)
    private Date expiryDate;

    @Column(name = ColumnUtils.WORK_VISA_ISSUE_DATE)
    private Date issueDate ;

    @Column(name = ColumnUtils.WORK_VISA_CUST_ID)
    private String customerId;

    @Column(name = ColumnUtils.EMPLOYEE_ID)
    private String employeeId;

    @Column(name = ColumnUtils.WORK_VISA_PASSPORT_ID)
    private String passportId;

    public VisaDetail() {
    }

    public VisaDetail( String employeeId, String countryName, Date validFrom, Date expiryDate, Date issueDate, String customerId, String passportId) {
        this.employeeId = employeeId;
        this.countryName = countryName;
        this.validFrom = validFrom;
        this.expiryDate = expiryDate;
        this.issueDate = issueDate;
        this.customerId = customerId;
        this.passportId = passportId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getVisaIdisaIdId() {
        return visaId;
    }

    public void setVisaIdd(String id) {
        this.visaId = visaId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }
}
