
package com.coviam.internalapp.hrms.esop.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * Created by Saurabh on 23/01/17.
 */


@Entity
@Table(name = TableUtils.ESOP_TABLE)
public class ESOP {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.ESOP_ID)
    private String esopId;

    @Column(name = ColumnUtils.CUSTOMER_ID)
    private String customerId;

    @Column(name = ColumnUtils.EMPLOYEE_ID)
    private String employeeId;

    @Column(name = ColumnUtils.ESOP_DATE_OFFERED)
    private Date dateOffered;

    @Column(name = ColumnUtils.ESOP_OFFERED_STOCKS)
    private int offeredStocks;

    @Column(name = ColumnUtils.ESOP_PRICE_OF_STOCK)
    private long priceOfStock;

    @Column(name = ColumnUtils.ESOP_BREAKAGES)
    private int breakages;

    @Column(name = ColumnUtils.ESOP_ACTIVE)
    private int active;

    @OneToMany(mappedBy = "esop" ,cascade=CascadeType.ALL)
    List<ESOPBreakage> esopBreakageList;

    public List<ESOPBreakage> getEsopBreakageList() {
        return esopBreakageList;
    }

    public void setEsopBreakageList(List<ESOPBreakage> esopBreakageList) {
        this.esopBreakageList = esopBreakageList;
    }

    public ESOP() {
    }

    public ESOP(String customerId, String employeeId, Date dateOffered, int offeredStocks,
                long priceOfStock, int breakages,int active) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.dateOffered = dateOffered;
        this.offeredStocks = offeredStocks;
        this.priceOfStock = priceOfStock;
        this.breakages = breakages;
        this.active=active;
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

    public Date getDateOffered() {
        return dateOffered;
    }

    public void setDateOffered(Date dateOffered) {
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}

