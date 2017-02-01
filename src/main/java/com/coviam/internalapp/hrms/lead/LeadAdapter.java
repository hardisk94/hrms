package com.coviam.internalapp.hrms.lead;

import com.coviam.internalapp.hrms.lead.dto.LeadDto;
import com.coviam.internalapp.hrms.lead.entity.Lead;
import com.coviam.internalapp.hrms.lead.dto.LeadDto;
import com.coviam.internalapp.hrms.lead.entity.Lead;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ashwini on 30/01/17.
**/

@Service
public class LeadAdapter {

    @Autowired
    private ModelMapper modelMapper;


    public LeadDto convertToDto(Lead lead) {
        LeadDto leadDto = modelMapper.map(lead, LeadDto.class);
        return leadDto;
    }

    public Lead convertToEntity(LeadDto leadDto){
        Lead lead = modelMapper.map(leadDto, Lead.class);
        return lead;
    }

    
}
