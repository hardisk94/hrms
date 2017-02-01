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
public interface ESOPService {

//    public boolean addEsop(String customerId, String employeeId, Date dateOffered,
//                           int offeredStocks, long priceOfStock, int breakages,
//                           List<Date> vestingDates, List<Integer> stocksToBeVested);
//    public boolean updateEsopById(String esopId, String customerId, String employeeId, Date dateOffered,
//                                  int offeredStocks, long priceOfStock, int breakages);

    public ESOP addEsop(ESOP esop);
    public ESOP getEsopById(String esopId);
    public List<ESOP> getAllESOPs();
    public ESOP updateESOP(ESOP esop);
    public boolean deleteEsopById(String esopId);
    public boolean deleteEsop(ESOP esop);

    public List<ESOP> getEsopsByEmployee(String customerId,String employeeId);
    public List<ESOPBreakage> getEsopBreakagesByEmployee(String customerId,String employeeId);
    public int getVestedStocksByEmployee(String customerId,String employeeId);
    public int getActiveOfferedStocksByEmployee(String customerId,String employeeId);



}
