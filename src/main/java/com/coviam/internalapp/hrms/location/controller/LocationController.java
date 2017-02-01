package com.coviam.internalapp.hrms.location.controller;

import com.coviam.internalapp.hrms.location.LocationAdaptor;
import com.coviam.internalapp.hrms.location.dto.LocationDto;
import com.coviam.internalapp.hrms.location.dto.UpdateDto;
import com.coviam.internalapp.hrms.location.service.impl.LocationServiceImpl;
import com.coviam.internalapp.hrms.location.entity.Location;
import com.coviam.internalapp.hrms.utils.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hardik on 24/01/17.
 */
@RestController
public class LocationController {

    @Autowired
    LocationServiceImpl locationServiceImpl;

    @Autowired
    LocationAdaptor locationAdaptor;


    @RequestMapping("/")
    public String index() {
        return "Hello";
    }

    @RequestMapping("/location/getById/{customerId}/{locationId}")
    public ResponseDto getLocationById(@PathVariable String customerId, @PathVariable String locationId) {
        Location location = locationServiceImpl.getByLocationId(customerId, locationId);
        return new ResponseDto(200, locationAdaptor.convertToDto(location));
    }

    @RequestMapping("/location/{customerId}")
    public ResponseDto getAllLocations(@PathVariable String customerId){
        List<Location> locationList = locationServiceImpl.getAllLocations(customerId);
        List<LocationDto> locationDtoList = locationList.stream().map(Location -> locationAdaptor.convertToDto(Location)).collect(Collectors.toList());
        return new ResponseDto(200, locationDtoList);
    }

    @RequestMapping(value = "/location/add/{customerId}", method = RequestMethod.POST)
    public ResponseDto createLocation(@PathVariable String customerId, @RequestBody LocationDto locationDto) {
        Location location = locationAdaptor.convertToInsertEntity(locationDto);
        return locationServiceImpl.createLocation(customerId, location);
    }

    @RequestMapping(value = "/location/update/{customerId}/{locationId}", method = RequestMethod.PUT)
    public ResponseDto updateLocation(@RequestBody UpdateDto updateDto, @PathVariable String locationId, @PathVariable String customerId) {
        Location location = locationAdaptor.convertToUpdateEntity(updateDto);
        return locationServiceImpl.updateLocation(customerId, locationId, location);
    }

    @RequestMapping(value = "/location/delete/{customerId}/{locationId}", method = RequestMethod.PUT)
    public ResponseDto deleteLocation(@PathVariable String customerId, @PathVariable String locationId) {
        return locationServiceImpl.deleteLocation(customerId, locationId);
    }
//    @RequestMapping(value="/location/showId/{employeeId}",method=RequestMethod.GET)
//    public ResponseEntity showId(@PathVariable String employeeId)
//    {
//        ResponseEntity re=new ResponseEntity(locationServiceImpl.getByEmployeeId(employeeId),HttpStatus.OK);
//        return re;
//    }
}
