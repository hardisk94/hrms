package com.coviam.internalapp.hrms.work.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by coviam on 24/01/17.
 */
@Entity
@Table(name = TableUtils.PASSPORT_TABLE)
public class PassportDetails {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.PASSPORT_ID)
    private String id;

    @Column(name =ColumnUtils.PASSPORT_CUS_ID)
    private String cusId;

    @Column(name =ColumnUtils.PASSPORT_TYPE)
    private String passType;

    @Column(name =ColumnUtils.PASSPORT_COUNTRY_CODE)
    private String countryCode;

    @Column(name =ColumnUtils.PASSPORT_NUMBER)
    private String passportNumber;

    @Column(name =ColumnUtils.PASSPORT_PERSON_NAME)
    private String citizenName;

    @Column(name =ColumnUtils.PASSPORT_NATIONALITY)
    private String nationality;

    @Column(name =ColumnUtils.PASSPORT_SEX)
    private String sex;

    @Column(name =ColumnUtils.PASSPORT_DOB)
    private Date dob;

    @Column(name =ColumnUtils.PASSPORT_ISSUE_PLACE)
    private String  placeOfIssue;

    @Column(name =ColumnUtils.PASSPORT_ISSUE_DATE)
    private Date dateOfIssue;

    @Column(name =ColumnUtils.PASSPORT_EXPIRY_DATE)
    private Date dateOfExpiry;

    @Column(name=ColumnUtils.PASSPORT_IS_ACTIVE)
    private boolean isActive;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = ColumnUtils.WORK_VISA_PASSPORT_ID)
    private List<VisaDetail> visaDetails;

    public PassportDetails() {
    }

    public PassportDetails(String id, String cusId, String passType, String countryCode, String passportNumber, String citizenName, String nationality, String sex, Date dob, String placeOfIssue, Date dateOfIssue, Date dateOfExpiry, boolean isActive, List<VisaDetail> visaDetails) {
        this.id = id;
        this.cusId = cusId;
        this.passType = passType;
        this.countryCode = countryCode;
        this.passportNumber = passportNumber;
        this.citizenName = citizenName;
        this.nationality = nationality;
        this.sex = sex;
        this.dob = dob;
        this.placeOfIssue = placeOfIssue;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpiry = dateOfExpiry;
        this.isActive = isActive;
        this.visaDetails = visaDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCitizenName() {
        return citizenName;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<VisaDetail> getVisaDetails() {
        return visaDetails;
    }

    public void setVisaDetails(List<VisaDetail> visaDetails) {
        this.visaDetails = visaDetails;
    }
}
