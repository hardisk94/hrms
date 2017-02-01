package com.coviam.internalapp.hrms.lead.controller;

import com.coviam.internalapp.hrms.educationaldetails.dto.EduDetailsDto;
import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import com.coviam.internalapp.hrms.lead.LeadAdapter;
import com.coviam.internalapp.hrms.lead.dto.LeadDto;
import com.coviam.internalapp.hrms.lead.entity.Lead;
import com.coviam.internalapp.hrms.lead.service.LeadService;
import com.coviam.internalapp.hrms.location.entity.Location;
import com.coviam.internalapp.hrms.salary.entity.Salary;
import com.coviam.internalapp.hrms.utils.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("leads")
public class LeadController {

    @Autowired
    LeadService leadService;
    @Autowired
    LeadAdapter leadAdapter;

    @RequestMapping(value = "/getAllLeads", method = RequestMethod.GET)
    public List<LeadDto> getAll(){
        List<Lead> leadDetails =  leadService.getAllLeads();
        return leadDetails.stream().map(Lead -> leadAdapter.convertToDto(Lead)).collect(Collectors.toList());
    }

}
