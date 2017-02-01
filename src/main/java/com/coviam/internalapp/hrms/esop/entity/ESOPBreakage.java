package com.coviam.internalapp.hrms.esop.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Saurabh on 24/01/17.
 */
@Entity
@Table(name = TableUtils.ESOP_BREAKAGE_TABLE)
public class ESOPBreakage {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.ESOP_BREAKAGE_ID)
    private String esopBreakageId;

    @ManyToOne(targetEntity = ESOP.class)
    @JoinColumn(name = ColumnUtils.ESOP_ID)
    //@Column(name=ColumnUtils.ESOP_ID)
    private ESOP esop;

    @Column(name = ColumnUtils.ESOP_BREAKAGE_VESTING_DATE)
    private Date vestingDate;

    @Column(name = ColumnUtils.ESOP_BREAKAGE_STOCKS_TO_BE_VESTED)
    private int stocksToBeVested;

    @Column(name = ColumnUtils.ESOP_BREAKAGE_ACTIVE)
    private int active;



    public ESOPBreakage() {
    }

    public ESOPBreakage(ESOP esop, Date vestingDate, int stocksToBeVested, int active) {
       this.esop=esop;
        this.vestingDate = vestingDate;
        this.stocksToBeVested = stocksToBeVested;
        this.active=active;
    }

    public String getEsopBreakageId() {
        return esopBreakageId;
    }

    public void setEsopBreakageId(String esopBreakageId) {
        this.esopBreakageId = esopBreakageId;
    }

    @JsonIgnore
    public ESOP getEsop() {
        return esop;
    }

    public void setEsop(ESOP esop) {
        this.esop = esop;
    }

    public Date getVestingDate() {
        return vestingDate;
    }

    public void setVestingDate(Date vestingDate) {
        this.vestingDate = vestingDate;
    }

    public int getStocksToBeVested() {
        return stocksToBeVested;
    }

    public void setStocksToBeVested(int stocksToBeVested) {
        this.stocksToBeVested = stocksToBeVested;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
