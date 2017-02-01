package com.coviam.internalapp.hrms.reporting_contact;

/**
 * Created by shailaja on 31/01/17.
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="reporting_contact_detail")
public class Reporting_Contact_Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")
    @Column(name="report_contact_id")
    private String rcId;
    @Column(name="report_person_fullname")
    private String rpName;
    @Column(name="report_person_designation")
    private String rpDesignation;
    @Column(name="report_person_email")
    private String rpEmail;
    @Column(name="report_person_phone")
    private String rpPhone;

    @Column(name="contact_person_fullname")
    private String cpName;
    @Column(name="contact_person_designation")
    private String cpDesignation;
    @Column(name="contact_person_email")
    private String cpEmail;
    @Column(name="contact_person_phone")
    private String cpPhone;

    @Column(name="sign_authority_fullname")
    private String saName;
    @Column(name="sign_authority_designation")
    private String saDesignation;
    @Column(name="sign_authority_email")
    private String saEmail;
    @Column(name="sign_authority_phone")
    private String saPhone;

    @Column(name="reporting_time")
    private String reportTime;

    public Reporting_Contact_Detail(){

    }

    public Reporting_Contact_Detail(String rcId, String rpName, String rpDesignation, String rpEmail, String rpPhone,
                                    String cpName, String cpDesignation, String cpEmail, String cpPhone, String saName, String saDesignation,
                                    String saEmail, String saPhone, String reportTime) {
        super();
        this.rcId = rcId;
        this.rpName = rpName;
        this.rpDesignation = rpDesignation;
        this.rpEmail = rpEmail;
        this.rpPhone = rpPhone;
        this.cpName = cpName;
        this.cpDesignation = cpDesignation;
        this.cpEmail = cpEmail;
        this.cpPhone = cpPhone;
        this.saName = saName;
        this.saDesignation = saDesignation;
        this.saEmail = saEmail;
        this.saPhone = saPhone;
        this.reportTime = reportTime;
    }

    public String getRcId() {
        return rcId;
    }

    public void setRcId(String rcId) {
        this.rcId = rcId;
    }

    public String getRpName() {
        return rpName;
    }

    public void setRpName(String rpName) {
        this.rpName = rpName;
    }

    public String getRpDesignation() {
        return rpDesignation;
    }

    public void setRpDesignation(String rpDesignation) {
        this.rpDesignation = rpDesignation;
    }

    public String getRpEmail() {
        return rpEmail;
    }

    public void setRpEmail(String rpEmail) {
        this.rpEmail = rpEmail;
    }

    public String getRpPhone() {
        return rpPhone;
    }

    public void setRpPhone(String rpPhone) {
        this.rpPhone = rpPhone;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getCpDesignation() {
        return cpDesignation;
    }

    public void setCpDesignation(String cpDesignation) {
        this.cpDesignation = cpDesignation;
    }

    public String getCpEmail() {
        return cpEmail;
    }

    public void setCpEmail(String cpEmail) {
        this.cpEmail = cpEmail;
    }

    public String getCpPhone() {
        return cpPhone;
    }

    public void setCpPhone(String cpPhone) {
        this.cpPhone = cpPhone;
    }

    public String getSaName() {
        return saName;
    }

    public void setSaName(String saName) {
        this.saName = saName;
    }

    public String getSaDesignation() {
        return saDesignation;
    }

    public void setSaDesignation(String saDesignation) {
        this.saDesignation = saDesignation;
    }

    public String getSaEmail() {
        return saEmail;
    }

    public void setSaEmail(String saEmail) {
        this.saEmail = saEmail;
    }

    public String getSaPhone() {
        return saPhone;
    }

    public void setSaPhone(String saPhone) {
        this.saPhone = saPhone;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
