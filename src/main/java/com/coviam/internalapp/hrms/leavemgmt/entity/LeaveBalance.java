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
@Table(name = TableUtils.LEAVEBALANCE_TABLE)
public class LeaveBalance {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = ColumnUtils.LEAVEBALANCE_ID)
	private int id;
	
	@Column(name=ColumnUtils.LEAVEBALANCE_CUSTOMER_ID)
	private String customerId;
	
	@Column(name = ColumnUtils.LEAVEBALANCE_EMPLOYEE_ID)
	private String employeeId;
	
	@Column(name = ColumnUtils.LEAVEBALANCE_LEAVE_TYPE)
	private int leaveType;
	
	@Column(name = ColumnUtils.LEAVEBALANCE_LEAVE_BALANCE)
	private int leaveBalance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public LeaveBalance() {
		
	}
	
	public LeaveBalance(String employeeId, String customerId, int leaveType, int leaveBalance) {
		super();
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.leaveType = leaveType;
		this.leaveBalance = leaveBalance;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public int getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(int leaveType) {
		this.leaveType = leaveType;
	}

	public int getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
