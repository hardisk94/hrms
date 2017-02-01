package com.coviam.internalapp.hrms.location.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = TableUtils.LOCATION_TABLE)
public class Location implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.LOCATION_ID, unique = true)
    private String locationId;

    @Column(name = ColumnUtils.CUSTOMER_ID)
    private String customerId;

    @Column(name = ColumnUtils.LOCATION_SHORTNAME)
    private String locationShortName;

    @Column(name = ColumnUtils.LOCATION_ADDRESS)
    private String locationAddress;

    @Column(name = ColumnUtils.LOCATION_PHONE)
    private String locationPhone;

    @Column(name = ColumnUtils.LOCATION_DESKNO)
    private String locationDeskNo;

    @Column(name = ColumnUtils.LOCATION_LATLONG)
    private String locationLatLong;

    @Column(name=ColumnUtils.EMPLOYEE_ID)
    private String employeeId;

    @Column(name = ColumnUtils.LOCATION_ISACTIVE)
    private boolean locationIsActive;

    public Location() {
    }

    public Location(String customerId, String locationShortName, String locationAddress, String locationPhone, String locationDeskNo, String locationLatLong) {
        this.customerId = customerId;
        this.locationShortName = locationShortName;
        this.locationAddress = locationAddress;
        this.locationPhone = locationPhone;
        this.locationDeskNo = locationDeskNo;
        this.locationLatLong = locationLatLong;
        this.locationIsActive = true;
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

    public String getLocationLatLong() {
        return locationLatLong;
    }

    public void setLocationLatLong(String locationLatLong) {
        this.locationLatLong = locationLatLong;
    }

    public boolean isLocationIsActive() {
        return locationIsActive;
    }

    public void setLocationIsActive(boolean locationIsActive) {
        this.locationIsActive = locationIsActive;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
