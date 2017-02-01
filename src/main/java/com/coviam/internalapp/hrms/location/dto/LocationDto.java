package com.coviam.internalapp.hrms.location.dto;

import java.io.Serializable;

/**
 * Created by Hardik on 27/01/17.
 */
public class LocationDto implements Serializable {
    private String locationShortName;
    private String locationAddress;
    private String locationPhone;
    private String locationDeskNo;

    public LocationDto() {
    }

    public LocationDto(String locationShortName, String locationAddress, String locationPhone, String locationDeskNo) {
        this.locationShortName = locationShortName;
        this.locationAddress = locationAddress;
        this.locationPhone = locationPhone;
        this.locationDeskNo = locationDeskNo;
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
