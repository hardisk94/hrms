package com.coviam.internalapp.hrms.employeestatus.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;

import javax.persistence.*;

@Entity
@Table(name = TableUtils.EMPLOYEE_STATUS)
public class EmployeeStatusType {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.EMPLOYEE_STATUS_ID)
    String id;

    @Column(name = ColumnUtils.EMPLOYEE_STATUS_TYPE_NAME)
    String statusType;

    @Column(name = ColumnUtils.EMPLOYEE_STATUS_DESC)
    String statusDesc;

    @Column(name = ColumnUtils.EMPLOYEE_STATUS_CUST_ID)
    String custId;

    public EmployeeStatusType() {
    }

    public EmployeeStatusType( String statusType, String statusDesc, String custId) {
        this.statusType = statusType;
        this.statusDesc = statusDesc;
        this.custId = custId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
}
