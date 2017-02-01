package com.coviam.internalapp.hrms.lead.entity;

import com.coviam.internalapp.hrms.department.entity.Department;
import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *@author Jyothi Prakash
 */
@Entity
@Table(name = TableUtils.LEAD_TABLE)
public class Lead{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.LEAD_ID)
    private String id;

    @Column(name = ColumnUtils.EMPLOYEE_ID)
    private String employeeId;

    @Column(name = ColumnUtils.DEPARTMENT_ID)
    private String departmentId;
    
    @Column(name = ColumnUtils.LEAD_ISACTIVE)
    private String leadIsActive;
    
    @Column(name = ColumnUtils.LEAD_START)
    private String leadStart;
    
    @Column(name = ColumnUtils.LEAD_END)
    private String leadEnd;

    public Lead(){
    	
    }
    
	public Lead(String id, String employeeId, String departmentId, String leadIsActive, String leadStart,
			String leadEnd) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.leadIsActive = leadIsActive;
		this.leadStart = leadStart;
		this.leadEnd = leadEnd;
	}

	public String getId(){
        return id;
    }

    public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeId(){
        return employeeId;
    }

    public String getDepartmentId(){
        return departmentId;
    }

    public void setDepartmentId(String deptId){
        this.departmentId = deptId;
    }

    public void setEmployeeId(String empId){
        this.employeeId = empId;
    }

	public String getLeadIsActive() {
		return leadIsActive;
	}

	public void setLeadIsActive(String leadIsActive) {
		this.leadIsActive = leadIsActive;
	}

	public String getLeadStart() {
		return leadStart;
	}

	public void setLeadStart(String leadStart) {
		this.leadStart = leadStart;
	}

	public String getLeadEnd() {
		return leadEnd;
	}

	public void setLeadEnd(String leadEnd) {
		this.leadEnd = leadEnd;
	}
}

