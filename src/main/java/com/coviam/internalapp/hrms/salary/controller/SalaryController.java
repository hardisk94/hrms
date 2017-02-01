package com.coviam.internalapp.hrms.salary.controller;

/**
 * Created by JahnaviSuthar on 25/01/17.
 */

import com.coviam.internalapp.hrms.dependent.dto.DependentDTO;
import com.coviam.internalapp.hrms.salary.SalaryAdapter;
import com.coviam.internalapp.hrms.salary.dto.SalaryDTO;
import com.coviam.internalapp.hrms.salary.entity.Salary;
import com.coviam.internalapp.hrms.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @Autowired
    SalaryAdapter salaryAdapter;

    @RequestMapping(value="/add/{customerId}/{employeeId}/{date}/{fixedSalary}/{variableSalary}/{notes}", method= RequestMethod.PUT)
    public ResponseEntity addSalary(@PathVariable("customerId") String customerId,
                                         @PathVariable("employeeId") String employeeId,
                                         @PathVariable("date") String date,
                                         @PathVariable("fixedSalary") long fixedSalary,
                                         @PathVariable("variableSalary") long variableSalary,
                                        @PathVariable("notes") String notes){

        boolean res = salaryService.addSalary(customerId,employeeId,Date.valueOf(date),fixedSalary,variableSalary,notes);

        return new ResponseEntity(res, HttpStatus.OK);

    }

    @RequestMapping(value="/addsalary", method= RequestMethod.POST)
    public ResponseEntity addSalary(@RequestBody SalaryDTO salaryDTO){

        boolean res = salaryService.addSalary(salaryDTO);

        return new ResponseEntity(res, HttpStatus.OK);

    }


    @RequestMapping(value="getall/{customerId}/{employeeId}", method= RequestMethod.GET)
    public ResponseEntity getSalary(@PathVariable("customerId") String customerId,
                                         @PathVariable("employeeId") String employeeId){
        return new ResponseEntity(salaryService.getSalary(customerId,employeeId),HttpStatus.OK);
    }


    @RequestMapping(value="getcurrent/{customerId}/{employeeId}", method= RequestMethod.GET)
    public ResponseEntity getCurrent(@PathVariable("customerId") String customerId,
                                    @PathVariable("employeeId") String employeeId){
        Salary s = salaryService.getCurrentSalary(customerId,employeeId);
        return new ResponseEntity(salaryAdapter.convertToDto(s),HttpStatus.OK);
    }

    @RequestMapping(value="getprevious/{customerId}/{employeeId}", method= RequestMethod.GET)
    public ResponseEntity getPrevious(@PathVariable("customerId") String customerId,
                                    @PathVariable("employeeId") String employeeId){
        Salary s = salaryService.getPreviousSalary(customerId,employeeId);
        return new ResponseEntity(salaryAdapter.convertToDto(s),HttpStatus.OK);
    }


    @RequestMapping(value="/delete/{customerId}/{employeeId}/{date}", method= RequestMethod.DELETE)
    public ResponseEntity deleteSalary(@PathVariable("customerId") String customerId,
                                            @PathVariable("employeeId") String employeeId,
                                            @PathVariable("date") String date){

        boolean res = salaryService.deleteSalary(customerId,employeeId,Date.valueOf(date));

        return new ResponseEntity(res,HttpStatus.OK);
    }

    @RequestMapping(value="/deleteemployee/{customerId}/{employeeId}", method= RequestMethod.DELETE)
    public ResponseEntity deleteSalary(@PathVariable("customerId") String customerId,
                                       @PathVariable("employeeId") String employeeId){

        boolean res = salaryService.deleteSalary(customerId,employeeId);

        return new ResponseEntity(res,HttpStatus.OK);
    }

    @RequestMapping(value="/update/{customerId}/{employeeId}/{date}/{fixedSalary}/{variableSalary}/{notes}", method= RequestMethod.POST)
    public ResponseEntity updateSalary(@PathVariable("customerId") String customerId,
                                    @PathVariable("employeeId") String employeeId,
                                    @PathVariable("date") String date,
                                    @PathVariable("fixedSalary") long fixedSalary,
                                    @PathVariable("variableSalary") long variableSalary,
                                    @PathVariable("notes") String notes){

        boolean res = salaryService.updateSalary(customerId,employeeId,Date.valueOf(date),fixedSalary,variableSalary,notes);

        return new ResponseEntity(res, HttpStatus.OK);

    }

    @RequestMapping(value="/updatesalary", method= RequestMethod.POST)
    public ResponseEntity updateSalary(@RequestBody SalaryDTO salaryDTO){

        boolean res = salaryService.updateSalary(salaryDTO);

        return new ResponseEntity(res, HttpStatus.OK);

    }

}
