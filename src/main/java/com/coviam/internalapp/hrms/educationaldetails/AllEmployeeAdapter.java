package com.coviam.internalapp.hrms.educationaldetails;

import com.coviam.internalapp.hrms.educationaldetails.dto.AllEmployeeIdDto;
import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import com.coviam.internalapp.hrms.educationaldetails.service.AllEmployeeId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by karan on 30/01/17.
 */

@Service
public class AllEmployeeAdapter {

    @Autowired
    private ModelMapper modelMapper;

    public AllEmployeeIdDto convertToDto(EducationalDetails educationalDetails) {
        AllEmployeeIdDto allEmployeeIdDto = modelMapper.map(educationalDetails, AllEmployeeIdDto.class);
        return allEmployeeIdDto;
    }
}
