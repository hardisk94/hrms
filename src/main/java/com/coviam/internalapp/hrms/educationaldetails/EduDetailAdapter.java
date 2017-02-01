package com.coviam.internalapp.hrms.educationaldetails;

import com.coviam.internalapp.hrms.educationaldetails.dto.EduDetailsDto;
import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by karan on 27/01/17.
 */

@Service
public class EduDetailAdapter {

    @Autowired
    private ModelMapper modelMapper;

    public EduDetailsDto convertToDto(EducationalDetails educationalDetails) {
        EduDetailsDto eduDetailsDto = modelMapper.map(educationalDetails, EduDetailsDto.class);
        return eduDetailsDto;
    }

    public EducationalDetails convertToEntity(EduDetailsDto eduDetailsDto){
        EducationalDetails educationalDetails = modelMapper.map(eduDetailsDto, EducationalDetails.class);
        return educationalDetails;
    }
}
