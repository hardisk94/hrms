package com.coviam.internalapp.hrms.location;

import com.coviam.internalapp.hrms.location.dto.LocationDto;
import com.coviam.internalapp.hrms.location.dto.UpdateDto;
import com.coviam.internalapp.hrms.location.entity.Location;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hardik on 27/01/17.
 */
@Service
public class LocationAdaptor {
    @Autowired
    private ModelMapper modelMapper;

    public LocationDto convertToDto(Location location) {
        return modelMapper.map(location, LocationDto.class);
    }

    public Location convertToInsertEntity(LocationDto locationDto) {
        return modelMapper.map(locationDto, Location.class);
    }

    public Location convertToUpdateEntity(UpdateDto updateDto) {
        return modelMapper.map(updateDto, Location.class);
    }
}
