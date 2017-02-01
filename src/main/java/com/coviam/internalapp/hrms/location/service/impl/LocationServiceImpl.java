package com.coviam.internalapp.hrms.location.service.impl;

import com.coviam.internalapp.hrms.location.dao.LocationRepository;
import com.coviam.internalapp.hrms.location.entity.Location;
import com.coviam.internalapp.hrms.location.service.LocationService;
import com.coviam.internalapp.hrms.utils.ResponseDto;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Coviam on 24/01/17.
 */

@Component
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    //load active locations

    public List<Location> getAllLocations(String customerId) {

        List<Location> locationList = Lists.newArrayList(locationRepository.findByCustomerIdAndLocationIsActive(customerId, true));
        return locationList;
    }

    //load active location by id
    @Override
    public Location getByLocationId(String customerId, String locationId) {
        Location location = locationRepository.findOneByCustomerIdAndLocationIdAndLocationIsActive(customerId, locationId, true);
        return location;
    }

    //change active status to false
    @Override
    public ResponseDto deleteLocation(String customerId, String locationId) {
        ResponseDto responseDto;
        Location location = locationRepository.findOneByCustomerIdAndLocationIdAndLocationIsActive(customerId, locationId, true);
        if(location != null) {
            location.setLocationIsActive(false);
            responseDto = new ResponseDto(200, locationRepository.save(location));
        }
        else {
            responseDto = new ResponseDto(500, "location not exists.");
        }
        return responseDto;
    }

    // create new location with by default active=true
    @Override
    public ResponseDto createLocation(String customerId, Location locationObject){
        ResponseDto responseDto;
        if(locationObject != null) {
            locationObject.setCustomerId(customerId);
            locationObject.setLocationIsActive(true);
            responseDto = new ResponseDto(200, locationRepository.save(locationObject));
        }
        else {
            responseDto = new ResponseDto(500, "Provide all the mendatory details.");
        }
        return responseDto;
    }

    // can update only active locations
    @Override
    public ResponseDto updateLocation(String customerId, String locationId, Location locationObject){
        ResponseDto responseDto;
        if(locationObject != null) {
            locationObject.setLocationId(locationId);
            locationObject.setCustomerId(customerId);
            responseDto = new ResponseDto(200, locationRepository.save(locationObject));
        }
        else {
            responseDto = new ResponseDto(500, "Provide all the mendatory details.");
        }
        return responseDto;
    }
    public Location getByEmployeeId(String employeeId)
    {
        Location location=locationRepository.findOne(employeeId);
        return location;
    }


}
