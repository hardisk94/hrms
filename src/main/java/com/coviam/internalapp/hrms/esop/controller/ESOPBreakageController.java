package com.coviam.internalapp.hrms.esop.controller;

import com.coviam.internalapp.hrms.esop.entity.ESOP;
import com.coviam.internalapp.hrms.esop.entity.ESOPBreakage;
import com.coviam.internalapp.hrms.esop.service.ESOPBreakageService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 25/01/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/eSOPBreakages")
public class ESOPBreakageController {
    @Autowired
    ESOPBreakageService esopBreakageService;

    @RequestMapping("/testParse")
    public ESOPBreakage testParse(){
        ESOPBreakage esopBreakage = new ESOPBreakage();
        return esopBreakage;
    }


    @RequestMapping(value = "/add",method= RequestMethod.POST
            ,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addEsopBreakage(ESOPBreakage esopBreakage){
        System.out.println("ADD REQUEST "+esopBreakage.toString());
        if(esopBreakageService.addEsopBreakage(esopBreakage))return "added";
        else return "not added";
    }

    @RequestMapping(value="/deleteByBreakageId/{breakageId}" ,method= RequestMethod.DELETE)
    public String deleteByBreakageId(@PathVariable String breakageId){
        if(esopBreakageService.deleteByEsopBreakageId(breakageId))return "deleted";
        else return "not deleted";
    }


    @RequestMapping(value="/deleteByEsop" ,method= RequestMethod.DELETE
            ,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteByEsop(ESOP esop){
        if(esopBreakageService.deleteByEsop(esop))return "deleted";
        else return "not deleted";
    }

    @RequestMapping(value="/deleteByEsopId/{esopId}" ,method= RequestMethod.DELETE)
    public String deleteByEsopId(@PathVariable String esopId){
        if(esopBreakageService.deleteByEsopId(esopId))return "deleted";
        else return "not deleted";
    }

    //tested
//    @RequestMapping(value="/add/{esopId}/{dates}/{stocks}" ,method= RequestMethod.POST)
//    public String addEsopBreakages(@PathVariable String esopId, @PathVariable String[] dates, @PathVariable int[] stocks){
//        if(dates.length != stocks.length)return "invalid input";
//
//        List<Date> vestingDates=new ArrayList<Date>();
//        List<Integer> stocksToBeVested = new ArrayList<Integer>();
//
//        for(int i=0;i<dates.length;i++){
//            Date date=Date.valueOf(dates[i]);
//            vestingDates.add(date);
//            stocksToBeVested.add(stocks[i]);
//        }
//
//        if(esopBreakageService.addBreakages(esopId, vestingDates, stocksToBeVested))return "added";
//        else return "not added";
//    }




//    @RequestMapping(value="/getByEsop" ,method= RequestMethod.GET)
//    public List<ESOPBreakage> getBreakagesByEsop(@RequestBody ESOP esop){
//        return esopBreakageService.getBreakagesByEsop(esop);
//    }

    @RequestMapping(value="/getByEsopId/{esopId}" ,method= RequestMethod.GET)
    public List<ESOPBreakage> getBreakagesByEsopId(@PathVariable String esopId){
        return esopBreakageService.getBreakagesByEsopId(esopId);
    }



    @RequestMapping(value="/getBreakageById/{breakageId}" ,method= RequestMethod.GET)
    public ESOPBreakage getBreakageById(@PathVariable String breakageId){
        return esopBreakageService.getBreakageById(breakageId);
    }



    @RequestMapping(value="/update" ,method= RequestMethod.PUT
            ,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateBreakage(ESOPBreakage esopBreakage){
        if(esopBreakageService.updateBreakage(esopBreakage))return "updated";
        else return "not updated";
    }



    @RequestMapping(value="/updateAllBreakages" ,method= RequestMethod.PUT
            ,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateAllBreakages(List<ESOPBreakage> esopBreakageList){
        if(esopBreakageService.updateAllBreakages(esopBreakageList))return "updated";
        else return "not updated";
    }




}
