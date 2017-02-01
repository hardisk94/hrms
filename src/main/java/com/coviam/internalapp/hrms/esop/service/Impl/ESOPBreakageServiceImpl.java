package com.coviam.internalapp.hrms.esop.service.Impl;

import com.coviam.internalapp.hrms.esop.dao.ESOPBreakageDao;
import com.coviam.internalapp.hrms.esop.dao.ESOPDao;
import com.coviam.internalapp.hrms.esop.entity.ESOP;
import com.coviam.internalapp.hrms.esop.entity.ESOPBreakage;
import com.coviam.internalapp.hrms.esop.service.ESOPBreakageService;
import com.coviam.internalapp.hrms.esop.service.ESOPService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

/**
 * Created by Saurabh on 24/01/17.
 */
@Component
public class ESOPBreakageServiceImpl implements ESOPBreakageService {

    @Autowired
    ESOPBreakageDao esopBreakageDao;

    @Autowired
    ESOPDao esopDao;
//    @Transactional
//    @Override
//    public boolean addBreakages(String esopId, List<Date> vestingDates, List<Integer> stocksToBeVested) {
//        if(vestingDates.size() != stocksToBeVested.size())return false;
//        try{
//            int breakages= vestingDates.size();
//            for(int i=0;i<breakages;i++){
//                ESOPBreakage esopBreakage = new ESOPBreakage(esopId, vestingDates.get(i), stocksToBeVested.get(i));
//                esopBreakageDao.save(esopBreakage);
//            }
//            return true;
//        }catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }

//    @Override
//    public boolean addBreakage(String esopId, Date vestingDate, int stocksToBeVested) {
//        try{
//            ESOPBreakage esopBreakage = new ESOPBreakage(esopId, vestingDate, stocksToBeVested);
//            esopBreakageDao.save(esopBreakage);
//            return true;
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }

//    @Transactional
//    @Override
//    public boolean deleteByEsopId(String esopId) {
//        try{
//             //esopBreakageDao.deleteByEsopId(esopId);
//            return true;
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }

    @Transactional
    @Override
    public boolean addEsopBreakage(ESOPBreakage esopBreakage) {
        try{
            esopBreakageDao.save(esopBreakage);
            return true;
        }catch(Exception e){
            return false;
        }
    }


    @Transactional
    @Override
    public boolean deleteByEsop(ESOP esop) {
        try{
            //esopBreakageDao.deleteByEsop(esop);
            List<ESOPBreakage> esopBreakageList = esopBreakageDao.findByEsop(esop);
            for(ESOPBreakage esopBreakage: esopBreakageList){
                esopBreakage.setActive(0);
                esopBreakageDao.save(esopBreakage);
            }

            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteByEsopId(String espoId) {
            ESOP esop=esopDao.findOne(espoId);
            return this.deleteByEsop(esop);
    }


    @Transactional
    @Override
    public boolean deleteByEsopBreakageId(String esopBreakageId) {
        try{
            //esopBreakageDao.delete(esopBreakageId);
            ESOPBreakage esopBreakage = esopBreakageDao.findOne(esopBreakageId);
            esopBreakage.setActive(0);
            esopBreakageDao.save(esopBreakage);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public List<ESOPBreakage> getBreakagesByEsop(ESOP esop) {
        return  esopBreakageDao.findByEsop(esop);
    }

    @Override
    public List<ESOPBreakage> getBreakagesByEsopId(String esopId) {
        return this.getBreakagesByEsop(esopDao.findOne(esopId));
    }

    @Transactional
    @Override
    public ESOPBreakage getBreakageById(String breakageId) {
        return esopBreakageDao.findOne(breakageId);
    }

    @Transactional
    @Override
    public boolean updateBreakage(ESOPBreakage esopBreakage) {
        try{
            esopBreakageDao.save(esopBreakage);
            return true;
        }
        catch(Exception e ){
            e.printStackTrace();
            return false;
        }
    }

//    @Transactional
//    @Override
//    public boolean updateAllBreakages(String esopId, List<Date> vestingDates,
//                                   List<Integer> stocksToBeVested) {
//        if(vestingDates.size() != stocksToBeVested.size())return false;
//        try{
//            List<ESOPBreakage> esopBreakageList=this.getBreakagesByEsopId(esopId);
//            for(int i=0;i<esopBreakageList.size();i++){
//                ESOPBreakage esopBreakage=esopBreakageList.get(i);
//                esopBreakage.setVestingDate(vestingDates.get(i));
//                esopBreakage.setStocksToBeVested(stocksToBeVested.get(i));
//                esopBreakageDao.save(esopBreakage);
//            }
//            return true;
//        }catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }


    @Override
    public boolean updateAllBreakages(List<ESOPBreakage> esopBreakageList) {
        try{
            for(ESOPBreakage esopBreakage : esopBreakageList){
                esopBreakageDao.save(esopBreakage);
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }



}
