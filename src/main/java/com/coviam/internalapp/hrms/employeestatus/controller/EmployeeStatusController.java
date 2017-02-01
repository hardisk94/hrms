package com.coviam.internalapp.hrms.employeestatus.controller;

import com.coviam.internalapp.hrms.employeestatus.entity.EmployeeStatusType;
import com.coviam.internalapp.hrms.employeestatus.service.EmployeeStatusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by coviam on 27/01/17.
 */
@RestController
@RequestMapping(value = "/employeeStatus")
public class EmployeeStatusController {
    @Autowired
    EmployeeStatusTypeService employeeStatusTypeService;

    @RequestMapping(value = "/getEmployeeStatusById/{id}",method= RequestMethod.GET)
    public EmployeeStatusType getEmployeeStatusTypeById(@PathVariable("id") String employeeStatustId) {
        return employeeStatusTypeService.getEmployeeStatusTypeById(employeeStatustId);
    }
    @RequestMapping(value = "/addEmployeeStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addEmployeeStatusType(@RequestBody  EmployeeStatusType employeeStatusTypeObj) throws Exception {
         EmployeeStatusType employeeStatusTypeObj1=employeeStatusTypeService.addEmployeeStatusType(employeeStatusTypeObj);
        return new ResponseEntity(employeeStatusTypeObj1, HttpStatus.OK);
    }

}
