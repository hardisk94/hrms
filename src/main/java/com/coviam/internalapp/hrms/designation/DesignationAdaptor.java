package com.coviam.internalapp.hrms.designation;

import com.coviam.internalapp.hrms.designation.dto.DesignationDto;
import com.coviam.internalapp.hrms.designation.entity.Designation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Coviam on 27/01/17.
 */
@Service
public class DesignationAdaptor {
    @Autowired
    private ModelMapper modelMapper;

    public DesignationDto convertToDto(Designation designation) {
        DesignationDto designationDto = modelMapper.map(designation, DesignationDto.class);
        return designationDto;
    }
}
