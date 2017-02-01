package com.coviam.internalapp.hrms.work.controller;



import com.coviam.internalapp.hrms.work.VisaAdapter;
import com.coviam.internalapp.hrms.work.dto.VisaDetailDto;
import com.coviam.internalapp.hrms.work.entity.WorkExperience;
import com.coviam.internalapp.hrms.work.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.coviam.internalapp.hrms.bankdetails.entity.BankDetail;
import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.skills.entity.Skills;
import com.coviam.internalapp.hrms.work.entity.PassportDetails;
import com.coviam.internalapp.hrms.work.entity.VisaDetail;
import com.coviam.internalapp.hrms.work.service.PassportDetailService;
import com.coviam.internalapp.hrms.work.service.VisaDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.stream.Collectors;


/**
 * Created by coviam on 25/01/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/work")
public class WorkController {
    @Autowired
    PassportDetailService passportDetailService;

    @Autowired
    VisaAdapter visaAdapter;

    @RequestMapping(value = "/getPassById/{id}",method= RequestMethod.GET)
    public PassportDetails getPassportById(@PathVariable ("id") String passportId) {
        return passportDetailService.getPassportById(passportId);
    }


   // @RequestMapping(value = "/abc", headers = {"applicatino/json", "app/xml"})
    //@ResponseBody
    //public Skills doSomething(@RequestBody Employee employee){

      //  return new skills;
    //}

    @RequestMapping(value = "/addPassportDetails", method = RequestMethod.POST)
    public ResponseEntity createPassportDetail(@RequestBody PassportDetails passportDetails) throws Exception {
       PassportDetails passportDetails1=passportDetailService.addPassportDetails(passportDetails);
        return new ResponseEntity(passportDetails1, HttpStatus.OK);
    }


    @RequestMapping(value="updatePassport/{passportId}",method= RequestMethod.PUT)
    public ResponseEntity updatePassport(@PathVariable String passportd, @RequestBody PassportDetails passportDetails)throws Exception{
        return  new ResponseEntity(passportDetailService.updatePassport(passportDetails), HttpStatus.OK);
    }


    @Autowired
    WorkService workService;

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public List<WorkExperience> getWorkExperienceOfEmployee(@PathVariable("employeeId") String empId){
        return workService.getAllWorkExperienceOfEmployee(empId);
    }

    @RequestMapping(value = "/addWork", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addWorkExperienceOfEmployee(@RequestBody WorkExperience workExperience){

        workService.addNewWorkExperienceOfEmployee(workExperience.getEmployeeId(),workExperience.getDesignation(),workExperience.getOrganizationName(),workExperience.getLocationId(),workExperience.getStatusId(),workExperience.getStartDate(),workExperience.getEndDate());

        return "Work Experience Added";
    }

    @RequestMapping(value = "/currentWorkExperience/{employeeId}")
    public WorkExperience getCurrentWorkExperience(@PathVariable("employeeId") String employeeId){
        return workService.getCurrentWorkExperienceOfEmployee(employeeId);
    }

    @RequestMapping(value = "/currentWorkExperience/designation/{employeeId}")
    public String getCurrentWorkExperienceDesignation(@PathVariable("employeeId") String employeeId){
        return workService.getCurrentWorkExperienceOfEmployeeDesignation(employeeId);
    }


    @RequestMapping(value = "/getPastWorkExperience/{employeeId}")
    public List<WorkExperience> getPastWorkExperience(@PathVariable("employeeId") String employeeId){
        return workService.getPastWorkExperienceOfEmployee(employeeId);
    }

    @RequestMapping(value = "/getWorkById/{workId}")
    public WorkExperience getWorkById(@PathVariable("workId") String workId) {
        return workService.getWorkExperienceById(workId);
    }

        @Autowired
        VisaDetailService visaDetailService;
    @RequestMapping(value = "/getVisaById/{id}",method= RequestMethod.GET)
    public VisaDetail getVisaById(@PathVariable("id") String visaId)
        {
        return visaDetailService.getVisaById(visaId);

    }

    @RequestMapping(value = "/addVisaDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createVisaDetail(@RequestBody VisaDetail visaDetailObj) throws Exception {
        VisaDetail visaDetail1=visaDetailService.addVisaDetail(visaDetailObj);
        return new ResponseEntity(visaDetail1, HttpStatus.OK);
    }

    @RequestMapping(value="/viewVisa/{customerID}/{employeeId}",method=RequestMethod.GET)
    public ResponseEntity showVisa(@PathVariable("customerID") String customerId, @PathVariable("employeeId") String employeeId)
    {
        List<VisaDetail> visaDetail;
        visaDetail = visaDetailService.getVisaByEmployeeId(customerId,employeeId);
        return new ResponseEntity(visaDetail.stream()
                .map(VisaDetail-> visaAdapter.convertToDto(VisaDetail))
                .collect(Collectors.toList()), HttpStatus.OK);

    }




}
