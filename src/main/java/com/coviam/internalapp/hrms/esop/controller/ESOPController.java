package com.coviam.internalapp.hrms.esop.controller;

import com.coviam.internalapp.hrms.esop.DTO.ESOPDTO;
import com.coviam.internalapp.hrms.esop.entity.ESOP;
import com.coviam.internalapp.hrms.esop.entity.ESOPBreakage;
import com.coviam.internalapp.hrms.esop.service.ESOPBreakageService;
import com.coviam.internalapp.hrms.esop.service.ESOPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 25/01/17.
 */
@CrossOrigin
@RestController
@RequestMapping("eSOPs")
public class ESOPController {

    @Autowired
    ESOPService esopService;
    @Autowired
    ESOPBreakageService esopBreakageService;


    @RequestMapping(value="/testParse", method= RequestMethod.GET)
    public ESOPDTO testParse(){
        ESOPDTO esop = new ESOPDTO();
        esop.setEsopId("124");
        esop.setCustomerId("cust");
        esop.setEmployeeId("empid");
        esop.setDateOffered("2011-1-1");
        esop.setOfferedStocks(1000);
        esop.setPriceOfStock(10);
        esop.setBreakages(2);
        esop.setDates(new String[]{"2013-1-1", "2022-4-4"});
        esop.setStocks(new int[]{250,250});
        return esop;
    }


    //tested
//    @RequestMapping(value="/addEsop/{customerId}/{employeeId}/{offeredDate}/{offeredStocks}/{priceOfStock}" +
//            "/{breakages}/{dates}/{stocks}", method=RequestMethod.POST)
//    public String addEsop(@PathVariable String customerId, @PathVariable String employeeId,
//                          @PathVariable String offeredDate, @PathVariable int offeredStocks,
//                          @PathVariable String priceOfStock, @PathVariable int breakages,
//                          @PathVariable String[] dates, @PathVariable int[] stocks
//                          ){
//        if(dates.length != stocks.length)return "invalid params";
//
//        long priceOfStocks=Long.parseLong(priceOfStock);
//        Date sqlDateOffered=Date.valueOf(offeredDate);
//        List<Date> vestingDates = new ArrayList<Date>();
//        List<Integer> stocksToBeVested = new ArrayList<Integer>();
//        for(int i=0;i<stocks.length;i++){
//            vestingDates.add(Date.valueOf(dates[i]));
//            stocksToBeVested.add(stocks[i]);
//        }
//        if(esopService.addEsop(customerId, employeeId, sqlDateOffered,offeredStocks, priceOfStocks, breakages,
//                vestingDates, stocksToBeVested)){
//            return "added";
//        }
//        else return "not added";
//    }


    @RequestMapping(value="/addEsop", method = RequestMethod.POST
            ,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public String addEsop( ESOPDTO esopDTO){
        try{
            ESOP esop=new ESOP(esopDTO.getCustomerId(), esopDTO.getEmployeeId(), Date.valueOf(esopDTO.getDateOffered()), esopDTO.getOfferedStocks(),
                    esopDTO.getPriceOfStock(), esopDTO.getBreakages(), 1);
            int breakages=esopDTO.getStocks().length;

            if(esopDTO.getDates()==null || esopDTO.getStocks()==null){
                return "breakages not provided";
            }
            if(esopDTO.getStocks().length != esopDTO.getDates().length){
                return "invalid breakages";
            }

            List<ESOPBreakage> esopBreakageList = new ArrayList<ESOPBreakage>();
            for(int i=0;i<breakages;i++){
                ESOPBreakage esopBreakage = new ESOPBreakage(esop, Date.valueOf(esopDTO.getDates()[i]), esopDTO.getStocks()[i], 1);
                esopBreakageList.add(esopBreakage);
                //esopBreakageService.addEsopBreakage(esopBreakage);
            }
            esop.setEsopBreakageList(esopBreakageList);
            esop=esopService.addEsop(esop);
            return "added";
        }
        catch(Exception e){
            e.printStackTrace();
            return "not added";
        }
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value="/deleteEsopById/{esopId}", method= RequestMethod.DELETE)
    public String deleteEsopById(@PathVariable String esopId){
        if(esopService.deleteEsopById(esopId))return "deleted";
        else return "not deleted";
    }


//    @RequestMapping(value="/deleteEsop/", method= RequestMethod.DELETE)
//    public String deleteEsop(@RequestBody ESOP esop){
//        if(esopService.deleteEsop(esop))return "deleted";
//        else return "not deleted";
//    }



    @RequestMapping(value="/getByEsopId/{esopId}", method= RequestMethod.GET)
    public ESOP getByEsopId(@PathVariable String esopId){
        return esopService.getEsopById(esopId);
    }

    @RequestMapping(value="/getAllEsops", method= RequestMethod.GET)
    public List<ESOP> getByEsopId(){
        return esopService.getAllESOPs();
    }





//    @RequestMapping(value="updateEsopById/{esopId}/{customerId}/{employeeId}/{dateOffered}" +
//            "/{offeredStocks}/{priceOfStock}/{breakages}", method = RequestMethod.PUT)
//    public String updateEsopById(@PathVariable String esopId,@PathVariable  String customerId,@PathVariable  String employeeId,
//                                 @PathVariable String dateOffered, @PathVariable int offeredStocks,
//                                 @PathVariable String priceOfStock, @PathVariable int breakages){
//
//        long priceOfStocks=Long.parseLong(priceOfStock);
//        Date sqlDateOffered=Date.valueOf(dateOffered);
//        if(esopService.updateEsopById(esopId ,customerId,employeeId,sqlDateOffered,offeredStocks,priceOfStocks,breakages))
//            return "updated";
//        else return "not updated";
//
//    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/updateEsop", method = RequestMethod.PUT
            ,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateEsop(ESOPDTO esopDTO){
        try{
            ESOP esop=new ESOP(esopDTO.getCustomerId(), esopDTO.getEmployeeId(), Date.valueOf(esopDTO.getDateOffered()),
                    esopDTO.getOfferedStocks(), esopDTO.getPriceOfStock(), esopDTO.getBreakages(), 1);
            esop.setEsopId(esopDTO.getEsopId());

            if(esopDTO.getDates()==null || esopDTO.getStocks()==null){
                return "breakages not provided";
            }
            if(esopDTO.getStocks().length != esopDTO.getDates().length){
                return "invalid breakages";
            }

            int breakages=esopDTO.getStocks().length;


            List<ESOPBreakage> esopBreakageList = new ArrayList<ESOPBreakage>();
            for(int i=0;i<breakages;i++){
                ESOPBreakage esopBreakage = new ESOPBreakage(esop, Date.valueOf(esopDTO.getDates()[i]), esopDTO.getStocks()[i], 1);
                esopBreakageList.add(esopBreakage);
                //esopBreakageService.addEsopBreakage(esopBreakage);

            }
            esop.setEsopBreakageList(esopBreakageList);
            esop=esopService.updateESOP(esop);      //deactivate old breakages and add new as active
            return "updated";
        }

        catch(Exception e){
            e.printStackTrace();
            return "not updated";
        }
    }


    @RequestMapping(value="getEsopsByEmployee/{customerId}/{employeeId}", method=RequestMethod.GET)
    public List<ESOP> getEsopsByEmployee(@PathVariable String customerId,@PathVariable String employeeId){
        return esopService.getEsopsByEmployee(customerId,employeeId);
    }

    @RequestMapping(value="getEsopBreakagesByEmployee/{customerId}/{employeeId}", method=RequestMethod.GET)
    public List<ESOPBreakage> getEsopBreakagesByEmployee(@PathVariable String customerId,@PathVariable String employeeId){
        return esopService.getEsopBreakagesByEmployee(customerId,employeeId);
    }


    @RequestMapping(value="getActiveOfferedStocksByEmployee/{customerId}/{employeeId}", method=RequestMethod.GET)
    public int getActiveOfferedStocksByEmployee(@PathVariable String customerId,@PathVariable String employeeId){
        return esopService.getActiveOfferedStocksByEmployee(customerId,employeeId);
    }

    @RequestMapping(value="getVestedStocksByEmployee/{customerId}/{employeeId}", method=RequestMethod.GET)
    public int getVestedStocksByEmployee(@PathVariable String customerId,@PathVariable String employeeId){
        return esopService.getVestedStocksByEmployee(customerId,employeeId);
    }

}
