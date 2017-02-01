package com.coviam.internalapp.hrms.variablepayhistory.controller;

import com.coviam.internalapp.hrms.variablepayhistory.VariablePayAdapter;
import com.coviam.internalapp.hrms.variablepayhistory.dto.VariablePayDTO;
import com.coviam.internalapp.hrms.variablepayhistory.entity.VariablePay;
import com.coviam.internalapp.hrms.variablepayhistory.service.VariablePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JahnaviSuthar on 25/01/17.
 */

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/variablepay")
public class VariablePayController {

    @Autowired
    VariablePayService variablePayService;


    @Autowired
    VariablePayAdapter variablePayAdapter;

    @RequestMapping(value="/get/{customerId}/{employeeId}", method= RequestMethod.GET)
    public ResponseEntity getVariablePay(@PathVariable("customerId") String customerId,
                                         @PathVariable("employeeId") String employeeId){

        List<VariablePay> variablePayList = variablePayService.getByEmployeeId(customerId,employeeId);
        return new ResponseEntity(variablePayList.stream()
                .map(VariablePay->variablePayAdapter.convertToDto(VariablePay))
                .collect(Collectors.toList()), HttpStatus.OK);

    }

    @RequestMapping(value="/addvariablepay", method= RequestMethod.POST)
    public ResponseEntity addVariablePay(@RequestBody VariablePayDTO variablePayDTO){

        boolean res = variablePayService.addVariablePay(variablePayDTO);

        return new ResponseEntity(res, HttpStatus.OK);

    }



   @RequestMapping(value="/add/{customerId}/{employeeId}/{date}/{variablePayment}/{percentage}", method= RequestMethod.PUT)
    public ResponseEntity addVariablePay(@PathVariable("customerId") String customerId,
                                         @PathVariable("employeeId") String employeeId,
                                         @PathVariable("date") String date,
                                         @PathVariable("variablePayment") long variablePayment,
                                         @PathVariable("percentage") int percentage){

        boolean res = variablePayService.addVariablePay(customerId,employeeId, Date.valueOf(date),
                variablePayment, percentage);
        return new ResponseEntity(res, HttpStatus.OK);

    }

    @RequestMapping(value="/delete/{customerId}/{employeeId}/{date}", method= RequestMethod.DELETE)
    public ResponseEntity deleteVariablePay(@PathVariable("customerId") String customerId,
                                         @PathVariable("employeeId") String employeeId,
                                            @PathVariable("date") String date){

        boolean res = variablePayService.removeVariablePay(customerId,employeeId,Date.valueOf(date));

        return new ResponseEntity(res,HttpStatus.OK);
    }

   @RequestMapping(value="/update/{customerId}/{employeeId}/{date}/{variablePayment}/{percentage}", method= RequestMethod.PUT)
    public ResponseEntity updateVariablePay(@PathVariable("customerId") String customerId,
                                         @PathVariable("employeeId") String employeeId,
                                         @PathVariable("date") String date,
                                         @PathVariable("variablePayment") long variablePayment,
                                         @PathVariable("percentage") int percentage){

        boolean res = variablePayService.updateVariablePay(customerId,employeeId,Date.valueOf(date),
                variablePayment,percentage);
        return new ResponseEntity(res, HttpStatus.OK);

    }


    @RequestMapping(value="/updatevariablepay", method= RequestMethod.POST)
    public ResponseEntity updateVariablePay(@RequestBody VariablePayDTO variablePayDTO){

        boolean res = variablePayService.updateVariablePay(variablePayDTO);
        return new ResponseEntity(res, HttpStatus.OK);

    }

}
