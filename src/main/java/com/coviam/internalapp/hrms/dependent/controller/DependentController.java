package com.coviam.internalapp.hrms.dependent.controller;

import com.coviam.internalapp.hrms.dependent.dto.DependentDTO;
import com.coviam.internalapp.hrms.dependent.service.DependentService;
import com.coviam.internalapp.hrms.salary.dto.SalaryDTO;
import com.coviam.internalapp.hrms.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

/**
 * Created by JahnaviSuthar on 27/01/17.
 */

@RestController
@RequestMapping("/dependent")
public class DependentController {

    @Autowired
    DependentService dependentService;

    @RequestMapping(value="/add/{customerId}/{employeeId}/{firstname}/{middlename}/{lastname}/{date}/{gender}/{relation}", method= RequestMethod.PUT)
    public ResponseEntity addDependent(@PathVariable("customerId") String customerId,
                                    @PathVariable("employeeId") String employeeId,
                                    @PathVariable("firstname") String firstName,
                                    @PathVariable("middlename") String middleName,
                                    @PathVariable("lastname") String lastName,
                                    @PathVariable("date") String date,
                                    @PathVariable("gender") String gender,
                                    @PathVariable("relation") String relation){

        boolean res = dependentService.addDependent(customerId,
                employeeId, firstName, middleName, lastName, Date.valueOf(date), gender, relation);

        return new ResponseEntity(res, HttpStatus.OK);

    }

    @RequestMapping(value="/adddependent", method= RequestMethod.POST)
    public ResponseEntity addDependent(@RequestBody DependentDTO dependentDTO){

        boolean res = dependentService.addDependent(dependentDTO);

        return new ResponseEntity(res, HttpStatus.OK);

    }

    @RequestMapping(value="get/{customerId}/{employeeId}", method= RequestMethod.GET)
    public ResponseEntity getDependent(@PathVariable("customerId") String customerId,
                                    @PathVariable("employeeId") String employeeId){
        return new ResponseEntity(dependentService.getDependents(customerId,employeeId),HttpStatus.OK);
    }


    @RequestMapping(value="/delete/{customerId}/{employeeId}/{firstname}", method= RequestMethod.DELETE)
    public ResponseEntity deleteDependent(@PathVariable("customerId") String customerId,
                                       @PathVariable("employeeId") String employeeId,
                                       @PathVariable("firstname") String firstName){

        boolean res = dependentService.deleteDependent(customerId,employeeId,firstName);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    @RequestMapping(value="/deleteall/{customerId}/{employeeId}", method= RequestMethod.DELETE)
    public ResponseEntity deleteDependent(@PathVariable("customerId") String customerId,
                                       @PathVariable("employeeId") String employeeId){

        boolean res = dependentService.deleteAllDependents(customerId,employeeId);
        return new ResponseEntity(res,HttpStatus.OK);
    }


    @RequestMapping(value="/update/{customerId}/{employeeId}/{firstname}", method= RequestMethod.PUT)
    public ResponseEntity updateDependent(@PathVariable("customerId") String customerId,
                                       @PathVariable("employeeId") String employeeId,
                                       @PathVariable("firstname") String firstName,
                                       @PathVariable("middlename") String middleName,
                                       @PathVariable("lastname") String lastName,
                                       @PathVariable("date") String date,
                                       @PathVariable("gender") String gender,
                                       @PathVariable("relation") String relation){

        boolean res = dependentService.updateDependent(customerId,employeeId,firstName,
                middleName,lastName,Date.valueOf(date), gender,relation);

        return new ResponseEntity(res, HttpStatus.OK);

    }

    @RequestMapping(value="/updatedependent/{customerId}/{employeeId}", method= RequestMethod.PUT)
    public ResponseEntity updateDependent(@RequestBody DependentDTO dependentDTO){

        boolean res = dependentService.updateDependent(dependentDTO);

        return new ResponseEntity(res, HttpStatus.OK);

    }

}
