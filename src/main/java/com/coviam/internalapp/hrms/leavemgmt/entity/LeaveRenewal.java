package com.coviam.internalapp.hrms.leavemgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;

@Entity
@Table(name = TableUtils.LEAVERENEWAL_TABLE)
public class LeaveRenewal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = ColumnUtils.LEAVERENEWAL_ID)
	private int id;
	
	@Column(name = ColumnUtils.LEAVERENEWAL_CUSTOMER_ID)
	private String customerId;
	
	@Column(name  = ColumnUtils.LEAVERENEWAL_RENEWAL_ID)
	private String renewalMonth;

	public LeaveRenewal() {
		
	}
	
	public LeaveRenewal(String customerId, String renewalMonth) {
		this.customerId = customerId;
		this.renewalMonth = renewalMonth;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getRenewalMonth() {
		return renewalMonth;
	}

	public void setRenewalMonth(String renewalMonth) {
		this.renewalMonth = renewalMonth;
	}
	
}
