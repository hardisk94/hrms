package com.coviam.internalapp.hrms.esop.service;

import com.coviam.internalapp.hrms.esop.entity.ESOP;
import com.coviam.internalapp.hrms.esop.entity.ESOPBreakage;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by Saurabh on 24/01/17.
 */
@Service
public interface ESOPBreakageService {

//    public boolean addBreakages(String esopId, List<Date> vestingDates, List<Integer> stocksToBeVested);
//    public boolean addBreakage(String esopId, Date vestingDate, int stocksToBeVested);
//    public boolean deleteByEsopId(String esopId);
    //    public boolean updateAllBreakages(String esopId, List<Date> vestingDates,
//                                   List<Integer> stocksToBeVested);

    public boolean addEsopBreakage(ESOPBreakage esopBreakage);
    public boolean deleteByEsop(ESOP esop);
    public boolean deleteByEsopId(String espoId);
    public boolean deleteByEsopBreakageId(String esopBreakageId);
    public List<ESOPBreakage> getBreakagesByEsop(ESOP esop);
    public List<ESOPBreakage> getBreakagesByEsopId(String esopId);
    public ESOPBreakage getBreakageById(String breakageId);
    public boolean updateBreakage(ESOPBreakage esopBreakage);
    public boolean updateAllBreakages(List<ESOPBreakage> esopBreakageList);

}
