package com.coviam.internalapp.hrms.designation.controller;

import com.coviam.internalapp.hrms.designation.DesignationAdaptor;
import com.coviam.internalapp.hrms.designation.dto.DesignationDto;
import com.coviam.internalapp.hrms.designation.entity.Designation;
import com.coviam.internalapp.hrms.designation.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by coviam on 25/01/17.
 */
@RestController
public class DesignationController {
    @Autowired
    DesignationService designationservice;

    @Autowired
    DesignationAdaptor designationAdaptor;

   @RequestMapping(value="designation/{customerId}",method = RequestMethod.GET)
   public ResponseEntity getAlldesignation(@PathVariable String customerId){
        return new ResponseEntity(designationservice.getAlldesignation(customerId), HttpStatus.OK);
   }

    @RequestMapping(value="designation/add/{customerId}",method= RequestMethod.POST)
    public ResponseEntity addDesignation(@PathVariable String customerId, @RequestBody Designation designation)throws Exception{
        return  new ResponseEntity(designationservice.addDesignation(designation), HttpStatus.OK);
    }

    @RequestMapping(value="designation/delete/{customerId}/{designationId}",method= RequestMethod.PUT)
    public ResponseEntity deleteDesignation(@PathVariable String customerId,@PathVariable String designationId){
        return  new ResponseEntity(designationservice.deleteDesignation(customerId, designationId), HttpStatus.OK);
    }

    @RequestMapping(value="designation/update/{designationId}",method= RequestMethod.PUT)
    public ResponseEntity updateDesignation(@PathVariable String designationId, @RequestBody Designation designation)throws Exception{
        return  new ResponseEntity(designationservice.updateDesignation(designation), HttpStatus.OK);
    }


    @RequestMapping(value="designation/getById/{customerId}/{designationId}",method= RequestMethod.GET)
    public DesignationDto getDesignation(@PathVariable String customerId, @PathVariable String designationId){
        Designation designation =  designationservice.getDesignation(customerId,designationId);
        DesignationDto designationDto = designationAdaptor.convertToDto(designation);
        return designationDto;
    }

    @RequestMapping(value="designation/getByCode/{customerId}/{designationCode}",method= RequestMethod.GET)
    public ResponseEntity getDesignationByDesignationCode(@PathVariable String customerId, @PathVariable String designationCode){
        return  new ResponseEntity(designationservice.getDesignationByDesignationCode(customerId,designationCode), HttpStatus.OK);
    }


}
