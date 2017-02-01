package com.coviam.internalapp.hrms.leavemgmt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;

@Entity
@Table(name = TableUtils.LEAVEHISTORY_TABLE)
public class LeaveHistory {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = ColumnUtils.LEAVEHISTORY_LEAVE_HISTORY_ID)
	private int leaveHistoryId; 
	
	@Column(name = ColumnUtils.LEAVEHISTORY_CUSTOMER_ID)
	private String customerId;
	
	@Column(name=ColumnUtils.LEAVEHISTORY_EMPLOYEE_ID)
	private String employeeId;
	
	@Column(name=ColumnUtils.LEAVEHISTORY_APPROVED_BY)
	private String approvedBy;
	
	@Column(name=ColumnUtils.LEAVEHISTORY_FROM_DATE)
	private Date fromDate;
	
	@Column(name = ColumnUtils.LEAVEHISTORY_TO_DATE)
	private Date toDate;
	
	@Column(name = ColumnUtils.LEAVEHISTORY_DAY_COUNT)
	private int dayCount;
	
	@Column(name = ColumnUtils.LEAVEHISTORY_LEAVE_TYPE)
	private String leaveType;
	
	@Column(name = ColumnUtils.LEAVEHISTORY_LEAVE_REASON)
    private String leaveReason;
	
    @Column(name = ColumnUtils.LEAVEHISTORY_STATUS_REASON)
    private String statusReason;
	
	@Column(name = ColumnUtils.LEAVEHISTORY_APPLIED_DATE)
	private Date appliedDate;
	
	@Column(name = ColumnUtils.LEAVEHISTORY_APPROVED_DATE)
	private Date approvedDate;
	
	@Column(name = ColumnUtils.LEAVEHISTORY_LEAVE_STATUS)
	private String leaveStatus;
	
	@Column(name = ColumnUtils.LEAVEHISTORY_IS_CANCELLED)
	private boolean isCancelled;
	
	public LeaveHistory() {
		
	}
	
	public LeaveHistory(String employeeId, String customerId, Date fromDate, Date toDate, int dayCount, String leaveType, String leaveReason) {
		super();
		this.employeeId = employeeId;
		this.customerId = customerId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.dayCount = dayCount;
		this.leaveType = leaveType;
		this.leaveReason = leaveReason;
		this.isCancelled = false;
		this.leaveStatus = "pending";
		this.appliedDate = new Date();
	}
	
	public int getLeaveHistoryId() {
		return leaveHistoryId;
	}
	public void setLeaveHistoryId(int leaveHistoryId) {
		this.leaveHistoryId = leaveHistoryId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public int getDayCount() {
		return dayCount;
	}
	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public Date getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public boolean isCancelled() {
		return isCancelled;
	}
	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getStatusReason() {
		return statusReason;
	}
	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAprovedBy() {
		return approvedBy;
	}

	public void setAprovedBy(String aprovedBy) {
		this.approvedBy = aprovedBy;
	}
	
	
}
