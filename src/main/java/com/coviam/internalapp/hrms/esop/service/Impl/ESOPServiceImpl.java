package com.coviam.internalapp.hrms.esop.service.Impl;

import com.coviam.internalapp.hrms.esop.dao.ESOPDao;
import com.coviam.internalapp.hrms.esop.entity.ESOP;
import com.coviam.internalapp.hrms.esop.entity.ESOPBreakage;
import com.coviam.internalapp.hrms.esop.service.ESOPBreakageService;
import com.coviam.internalapp.hrms.esop.service.ESOPService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.*;

/**
 * Created by Saurabh on 24/01/17.
 */
@Component
public class ESOPServiceImpl implements ESOPService{
    @Autowired
    ESOPDao esopDao;

   @Autowired
    ESOPBreakageService esopBreakageService;


//    @Transactional
//    @Override
//    public boolean addEsop(String customerId, String employeeId, Date dateOffered, int offeredStocks,
//                           long priceOfStock, int breakages, List<Date> vestingDates, List<Integer> stocksToBeVested) {
//        try{
//            ESOP esop=new ESOP(customerId, employeeId, dateOffered, offeredStocks, priceOfStock, breakages);
//            esop=esopDao.save(esop);
//            String esopId=esop.getEsopId(); //auto generated id
//            esopBreakageService.addBreakages(esopId, vestingDates, stocksToBeVested);
//            return true;
//        }catch(Exception e){
//            return false;
//        }
//    }


    @Transactional
    @Override
    public ESOP addEsop(ESOP esop) {
        return esopDao.save(esop);
    }


    @Transactional
    @Override
    public boolean deleteEsopById(String esopId) {
        try{
            ESOP esop=esopDao.findOne(esopId);
            return deleteEsop(esop);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public boolean deleteEsop(ESOP esop) {
        try{
            esop.setActive(0);      //deactivate esop
            List<ESOPBreakage> esopBreakageList = esop.getEsopBreakageList();
            if(esopBreakageList != null){
                for(ESOPBreakage esopBreakage : esopBreakageList){
                    esopBreakage.setActive(0);      //deactivate breakages
                }
            }
            esopDao.save(esop);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @Transactional
    @Override
    public ESOP getEsopById(String esopId) {
        return esopDao.findOne(esopId);
    }


    @Override
    public List<ESOP> getAllESOPs() {
        return Lists.newArrayList(esopDao.findAllByOrderByDateOfferedAsc());
    }


//    @Transactional
//    @Override
//    public boolean updateEsopById(String esopId, String customerId, String employeeId, Date dateOffered,
//                                  int offeredStocks, long priceOfStock, int breakages) {
//        try{
//            ESOP esop=new ESOP(customerId, employeeId, dateOffered, offeredStocks, priceOfStock, breakages);
//            esop.setEsopId(esopId);
//            esopDao.save(esop);
//            return true;
//        }
//        catch(Exception e){
//            return false;
//        }
//    }

    @Transactional
    @Override
    public ESOP updateESOP(ESOP esop){
        esopBreakageService.deleteByEsop(esop);   //deactivate old esop-breakage entries
        return esopDao.save(esop);
    }




//--------------------------

    @Transactional
    @Override
    public List<ESOP> getEsopsByEmployee(String customerId,String employeeId) {
        return esopDao.findByCustomerIdAndEmployeeIdOrderByDateOfferedAsc(customerId,employeeId);
    }

    @Override
    public List<ESOPBreakage> getEsopBreakagesByEmployee(String customerId,String employeeId) {
        List<ESOPBreakage> esopBreakageList = new ArrayList<ESOPBreakage>();
        List<ESOP> esopList = this.getEsopsByEmployee(customerId,employeeId);

        for(ESOP esop: esopList){
            List<ESOPBreakage> esopBreakageList1 = esop.getEsopBreakageList();
            esopBreakageList.addAll(esopBreakageList1);
        }
        Collections.sort(esopBreakageList, new Comparator<ESOPBreakage>() {
            @Override
            public int compare(ESOPBreakage o1, ESOPBreakage o2) {
                if(o2.getVestingDate().after(o1.getVestingDate())) return -1;
                else if(o1.getVestingDate().after(o2.getVestingDate())) return 1;
                else return 0;
            }
        });
        return esopBreakageList;
    }

    @Transactional
    @Override
    public int getActiveOfferedStocksByEmployee(String customerId,String employeeId) {
        int totalOfferedStocks=0;
        List<ESOP> esopList = esopDao.findByCustomerIdAndEmployeeId(customerId,employeeId);
        for(ESOP esop : esopList){
            if(esop.getActive()==1){
                totalOfferedStocks += esop.getOfferedStocks();
            }
        }
        return totalOfferedStocks;
    }


    @Transactional
    @Override
    public int getVestedStocksByEmployee(String customerId,String employeeId) {
        int totalVestedStocks=0;
        List<ESOP> esopList = esopDao.findByCustomerIdAndEmployeeId(customerId,employeeId);
        for(ESOP esop : esopList){
            if(esop.getActive()==1){
                String esopId=esop.getEsopId();
                java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

                //List<ESOPBreakage> esopBreakageList = esopBreakageService.getBreakagesByEsopId(esopId); //or get it from esop.esopBreakageList
                List<ESOPBreakage> esopBreakageList = esop.getEsopBreakageList();

                for(ESOPBreakage esopBreakage : esopBreakageList){

                    if(esopBreakage.getActive()==1 && sqlDate.after(esopBreakage.getVestingDate())){   //if date is passed
                        totalVestedStocks += esopBreakage.getStocksToBeVested();
                    }
                }
            }

        }
        return totalVestedStocks;
    }




}
