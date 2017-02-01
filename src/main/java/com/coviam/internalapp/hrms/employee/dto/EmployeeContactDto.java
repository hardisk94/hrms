package com.coviam.internalapp.hrms.employee.dto;

/**
 * Created by Hardik on 29/01/17.
 */
public class EmployeeContactDto {
    private String employeeId;

    //Office Address details...
    private String locationShortName;
    private String locationAddress;
    private String locationPhone;
    private String locationDeskNo;

    //Permanent Address detail...
    private String permanentAddress;

    //Emergency Contact details...
    private String emergencyName;
    private String emergencyRelation;
    private String emergencyAddress;
    private String getEmergencyContact;

    //Social Media details...
    private String phoneNumber;
    private String emailId;
    private String facebookId;
    private String twitterId;
    private String skypeId;

    public EmployeeContactDto() {
    }

    public EmployeeContactDto(String employeeId, String locationShortName, String locationAddress, String locationPhone, String locationDeskNo, String permanentAddress, String emergencyName, String emergencyRelation, String emergencyAddress, String getEmergencyContact, String phoneNumber, String emailId, String facebookId, String twitterId, String skypeId) {
        this.employeeId = employeeId;
        this.locationShortName = locationShortName;
        this.locationAddress = locationAddress;
        this.locationPhone = locationPhone;
        this.locationDeskNo = locationDeskNo;
        this.permanentAddress = permanentAddress;
        this.emergencyName = emergencyName;
        this.emergencyRelation = emergencyRelation;
        this.emergencyAddress = emergencyAddress;
        this.getEmergencyContact = getEmergencyContact;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.facebookId = facebookId;
        this.twitterId = twitterId;
        this.skypeId = skypeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLocationShortName() {
        return locationShortName;
    }

    public void setLocationShortName(String locationShortName) {
        this.locationShortName = locationShortName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationPhone() {
        return locationPhone;
    }

    public void setLocationPhone(String locationPhone) {
        this.locationPhone = locationPhone;
    }

    public String getLocationDeskNo() {
        return locationDeskNo;
    }

    public void setLocationDeskNo(String locationDeskNo) {
        this.locationDeskNo = locationDeskNo;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyRelation() {
        return emergencyRelation;
    }

    public void setEmergencyRelation(String emergencyRelation) {
        this.emergencyRelation = emergencyRelation;
    }

    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    public void setEmergencyAddress(String emergencyAddress) {
        this.emergencyAddress = emergencyAddress;
    }

    public String getGetEmergencyContact() {
        return getEmergencyContact;
    }

    public void setGetEmergencyContact(String getEmergencyContact) {
        this.getEmergencyContact = getEmergencyContact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getSkypeId() {
        return skypeId;
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }
}
