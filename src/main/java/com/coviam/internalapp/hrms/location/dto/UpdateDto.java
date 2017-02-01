package com.coviam.internalapp.hrms.location.dto;

import com.coviam.internalapp.hrms.utils.ColumnUtils;

import javax.persistence.Column;

/**
 * Created by Hardik on 29/01/17.
 */
public class UpdateDto {
    private String locationId;
    private String customerId;
    private String locationShortName;
    private String locationAddress;
    private String locationPhone;
    private String locationDeskNo;

    public UpdateDto() {
    }

    public UpdateDto(String locationId, String customerId, String locationShortName, String locationAddress, String locationPhone, String locationDeskNo) {
        this.locationId = locationId;
        this.customerId = customerId;
        this.locationShortName = locationShortName;
        this.locationAddress = locationAddress;
        this.locationPhone = locationPhone;
        this.locationDeskNo = locationDeskNo;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
}
