package com.coviam.internalapp.hrms.educationaldetails.controller;

import com.coviam.internalapp.hrms.educationaldetails.entity.GradeType;
import com.coviam.internalapp.hrms.educationaldetails.service.GradeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by karan on 25/01/17.
 */

@RestController
public class GradeTypeController {

    @Autowired
    GradeTypeService gradeTypeService;

    @RequestMapping(value = "/getGradeTypeDetails", method = RequestMethod.GET)
    public List<GradeType> getGradeTypeDetails(){
        return gradeTypeService.getGradeTypeDetails();
    }

    @RequestMapping(value = "/getGradeTypeDetailsSingle/{gradeTypeId}", method = RequestMethod.GET)
    public List<GradeType> getGradeTypeDetailsSingle(@PathVariable String gradeTypeId){
        return gradeTypeService.getGradeTypeDetailsSingle(gradeTypeId);
    }

    @RequestMapping(value = "/addGradeTypeDetails", method = RequestMethod.POST)
    public void addGradeTypeDetails(@RequestBody GradeType gradeType){
        gradeTypeService.addGradeTypeDetails(gradeType);
    }

    @RequestMapping(value = "/deleteGradeTypeDetails/{gradeTypeId}", method = RequestMethod.POST)
    public void deleteGradeTypeDetails(@PathVariable String gradeTypeId){
        gradeTypeService.deleteGradeTypeDetails(gradeTypeId);
    }

    @RequestMapping(value = "/updateGradeTypeDetails/{gradeTypeId}", method = RequestMethod.POST)
    public void updateGradeTypeDetails(@PathVariable String gradeTypeId, @RequestBody GradeType gradeType){
        GradeType gradeType_existing = gradeTypeService.getByGradeTypeId(gradeTypeId);
        gradeType_existing.setType(gradeType.getType());
        gradeType_existing.setScale(gradeType.getScale());

        gradeTypeService.deleteGradeTypeDetails(gradeTypeId);
        gradeTypeService.updateGradeTypeDetails(gradeType_existing);
    }
}