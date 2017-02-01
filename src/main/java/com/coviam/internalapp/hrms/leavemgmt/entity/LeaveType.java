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
@Table(name = TableUtils.LEAVETYPE_TABLE)
public class LeaveType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = ColumnUtils.LEAVETYPE_LEAVE_TYPE_ID)
    private int leaveTypeId;
	
    @Column(name = ColumnUtils.LEAVETYPE_LEAVE_TYPE)
    private String leaveType;
    
    @Column(name = ColumnUtils.LEAVETYPE_MAX_LEAVE)
    private int maxLeave;
    
    @Column(name = ColumnUtils.LEAVETYPE_DAFAULT_TYPE)
    private int defaultLeave;
    
    @Column(name = ColumnUtils.LEAVETYPE_CARRY_FORWARD)
    private int carryForward;
    
    @Column(name = ColumnUtils.LEAVETYPE_CUSTOMER_ID)
    private String customerId;
    
    public LeaveType() {
    	
    }
    
    public LeaveType(String leaveType, int maxLeave,int defaultLeave,int carryForward,String customerId ){
		this.leaveType=leaveType;
		this.maxLeave=maxLeave;
		this.defaultLeave=defaultLeave;
		this.carryForward=carryForward;	
		this.customerId=customerId;
	}
    
	public int getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public int getMaxLeave() {
		return maxLeave;
	}
	public void setMaxLeave(int maxLeave) {
		this.maxLeave = maxLeave;
	}
	public int getDefaultLeave() {
		return defaultLeave;
	}
	public void setDefaultLeave(int defaultLeave) {
		this.defaultLeave = defaultLeave;
	}
	public int getCarryForward() {
		return carryForward;
	}
	public void setCarryForward(int carryForward) {
		this.carryForward = carryForward;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
}
