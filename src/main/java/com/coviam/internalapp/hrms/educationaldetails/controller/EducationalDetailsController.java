package com.coviam.internalapp.hrms.educationaldetails.controller;

import com.coviam.internalapp.hrms.educationaldetails.AllEmployeeAdapter;
import com.coviam.internalapp.hrms.educationaldetails.EduDetailAdapter;
import com.coviam.internalapp.hrms.educationaldetails.dao.EducationalDetailsRepository;
import com.coviam.internalapp.hrms.educationaldetails.dto.AllEmployeeIdDto;
import com.coviam.internalapp.hrms.educationaldetails.dto.EduDetailsDto;
import com.coviam.internalapp.hrms.educationaldetails.dto.InsertDto;
import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import com.coviam.internalapp.hrms.educationaldetails.service.AllEmployeeId;
import com.coviam.internalapp.hrms.educationaldetails.service.EducationalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by karan on 25/01/17.
 */

@RestController
public class EducationalDetailsController {

    @Autowired
    EducationalDetailsService eduDetailService;

    @Autowired
    EduDetailAdapter eduDetailAdapter;

    @Autowired
    AllEmployeeId allEmployeeId;

    @Autowired
    AllEmployeeAdapter allEmployeeAdapter;

    /*@RequestMapping("/")
    public void index(){
        System.out.println("Hello");
    }

    @RequestMapping("/addEduDetails")
    public void addEducationDetails(@RequestParam(value="employeeId", defaultValue="") String employeeId, @RequestParam (value="degree", defaultValue="") String degree,
                                    @RequestParam (value="dateOfJoining", defaultValue="") Date dateOfJoining, @RequestParam (value="graduationDate", defaultValue="") Date graduationDate,
                                    @RequestParam (value="grade", defaultValue="") float grade, @RequestParam (value="gradeTypeId", defaultValue="") String gradeTypeId){

        EducationalDetails educationalDetails = new EducationalDetails();
        educationalDetails.setEmployeeId(employeeId);
        educationalDetails.setDegree(degree);
        educationalDetails.setDateOfJoining(dateOfJoining);
        educationalDetails.setGraduationDate(graduationDate);
        educationalDetails.setGrade(grade);
        educationalDetails.setGradeTypeId(gradeTypeId);
        eduDetailService.addEducationDetails(educationalDetails);
    }*/

    /*@RequestMapping(value = "/getEduDetails", method = RequestMethod.GET)
    public List<EducationalDetails> getEduDetails(){
        return eduDetailService.getEducationDetails();
    }*/

    @RequestMapping(value = "/addEduDetails/{employeeId}", method = RequestMethod.POST)
    public void addEducationDetails(@PathVariable String employeeId,@RequestBody EduDetailsDto eduDetailsDto) {
        //Date date = educationalDetails.getDateOfJoining();
        //if(educationalDetails.getEmployeeId())
        //EducationalDetails educationalDetails1 = eduDetailService.getByEmployeeIdAndDegree(insertDto.getEmployeeId(), insertDto.getDegree());
        //if (educationalDetails1 == null) {
        //EducationalDetails educationalDetails = eduDetailService.getByEmployeeIdAndDegree(employeeId);
        EducationalDetails educationalDetails = eduDetailAdapter.convertToEntity(eduDetailsDto);
        educationalDetails.setEmployeeId(employeeId);
        eduDetailService.addEducationDetails(educationalDetails);
        //} else {
        //  return "Employee already exists";
        //}
        //return "Detail Added";
        //System.out.println(educationalDetails.getId());
    }

    @RequestMapping(value = "/getEduDetails/{customerId}/{employeeId}", method = RequestMethod.GET)
    public List<EduDetailsDto> getEduDetailsSingle(@PathVariable("customerId") String customerId,
                                                   @PathVariable("employeeId") String employeeId) {
        List<EducationalDetails> educationalDetails = eduDetailService.getEducationDetailsSingle(customerId,employeeId);
        return educationalDetails.stream().map(EducationalDetails -> eduDetailAdapter.convertToDto(EducationalDetails)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/deleteEduDetails/{customerId}/{employeeId}/{degree}", method = RequestMethod.POST)
    public String deleteEduDetailsSingle(@PathVariable String customerId,@PathVariable String employeeId, @PathVariable String degree) {
        EducationalDetails educationalDetails = eduDetailService.getByEmployeeIdAndDegree(customerId,employeeId, degree);
        if (educationalDetails == null) {
            return "not found";
        } else {
            educationalDetails.setIsAcvtive("false");
            eduDetailService.updateEducationDetails(educationalDetails);
        }
        return "record deleted";
    }

    @RequestMapping(value = "/updateEduDetails/{customerId}/{employeeId}/{degree}", method = RequestMethod.POST)
    public void updateEduDetails(@PathVariable String customerId,@PathVariable String employeeId, @PathVariable String degree, @RequestBody EducationalDetails educationalDetails) {
        EducationalDetails educationalDetails_existing = eduDetailService.getByEmployeeIdAndDegree(customerId,employeeId, degree);
        educationalDetails_existing.setGrade(educationalDetails.getGrade());
        educationalDetails_existing.setDateOfJoining(educationalDetails.getDateOfJoining().toString());
        educationalDetails_existing.setGraduationDate(educationalDetails.getGraduationDate().toString());
        educationalDetails_existing.setGradeTypeId(educationalDetails.getGradeTypeId());
        educationalDetails_existing.setInstitute(educationalDetails.getInstitute());
        educationalDetails_existing.setEducationType(educationalDetails.getEducationType());
        //educationalDetails_existing
        eduDetailService.deleteByEduDetailAndDegree(customerId,employeeId, degree);
        eduDetailService.updateEducationDetails(educationalDetails_existing);
    }

    @RequestMapping(value = "/getAllEmplyeeId/{customerId}", method = RequestMethod.GET)
    public List<AllEmployeeIdDto> getAllEmployeeId(@PathVariable String customerId){
        List<EducationalDetails> educationalDetails = allEmployeeId.getAllEmployeeId(customerId);
        return educationalDetails.stream().map(EducationalDetails -> allEmployeeAdapter.convertToDto(EducationalDetails)).collect(Collectors.toList());

    }

}
