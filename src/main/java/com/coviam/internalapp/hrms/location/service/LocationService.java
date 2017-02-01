package com.coviam.internalapp.hrms.location.service;

import com.coviam.internalapp.hrms.location.entity.Location;
import com.coviam.internalapp.hrms.utils.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {

    //load only active locations
    List<Location> getAllLocations(String customerId);

    //load only active locations
    Location getByLocationId(String customerId, String locationId);

    Location getByEmployeeId(String employeeId);

    //delete marks the location as inactive ... is a soft delete
    ResponseDto deleteLocation(String customerId, String locationId);

    //this is by default active
    ResponseDto createLocation(String customerId, Location locationObject) throws Exception;

    //update always does the entire object
    ResponseDto updateLocation(String customerId, String locationId, Location locationObject) throws Exception;

}
