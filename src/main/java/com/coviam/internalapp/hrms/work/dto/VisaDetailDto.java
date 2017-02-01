package com.coviam.internalapp.hrms.work.dto;

/**
 * Created by Coviam on 27/01/17.
 */
public class VisaDetailDto {
    private String passportId;
    private String countryName;
    private String validFrom;
    private String expiryDate;
    private String issueDate;

    public VisaDetailDto() {
    }

    public VisaDetailDto(String passportId, String countryName, String validFrom, String expiryDate, String issueDate) {
        this.passportId = passportId;
        this.countryName = countryName;
        this.validFrom = validFrom;
        this.expiryDate = expiryDate;
        this.issueDate = issueDate;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
}
