package com.coviam.internalapp.hrms.esop.DTO;

import com.coviam.internalapp.hrms.esop.entity.ESOPBreakage;
import com.coviam.internalapp.hrms.utils.ColumnUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Saurabh on 25/01/17.
 */
public class ESOPDTO implements Serializable{

    private String esopId;
    private String customerId;
    private String employeeId;
    private String dateOffered;
    private int offeredStocks;
    private long priceOfStock;
    private int breakages;

    //breakages
    private String[] dates;
    private int[] stocks;


    public ESOPDTO() {
    }

    public ESOPDTO(String esopId, String customerId, String employeeId, String dateOffered,
                   int offeredStocks, long priceOfStock, int breakages,
                   String[] dates, int[] stocks) {
        this.esopId = esopId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.dateOffered = dateOffered;
        this.offeredStocks = offeredStocks;
        this.priceOfStock = priceOfStock;
        this.breakages = breakages;
        this.dates = dates;
        this.stocks = stocks;
    }

    public String getEsopId() {
        return esopId;
    }

    public void setEsopId(String esopId) {
        this.esopId = esopId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDateOffered() {
        return dateOffered;
    }

    public void setDateOffered(String dateOffered) {
        this.dateOffered = dateOffered;
    }

    public int getOfferedStocks() {
        return offeredStocks;
    }

    public void setOfferedStocks(int offeredStocks) {
        this.offeredStocks = offeredStocks;
    }

    public long getPriceOfStock() {
        return priceOfStock;
    }

    public void setPriceOfStock(long priceOfStock) {
        this.priceOfStock = priceOfStock;
    }

    public int getBreakages() {
        return breakages;
    }

    public void setBreakages(int breakages) {
        this.breakages = breakages;
    }

    public String[] getDates() {
        return dates;
    }

    public void setDates(String[] dates) {
        this.dates = dates;
    }

    public int[] getStocks() {
        return stocks;
    }

    public void setStocks(int[] stocks) {
        this.stocks = stocks;
    }

}
