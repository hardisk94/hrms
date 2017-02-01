package com.coviam.internalapp.hrms.department.dto;

import java.util.HashSet;
import java.util.Set;

import com.coviam.internalapp.hrms.lead.entity.Lead;

/**
 * Created by coviam on 30/01/17.
 */
public class DepartmentDto {
    private String departmentId;
    private String customerId;
    private String departmentName;
    private String departmentDescription;
    private String departmentParentDepartment;
    private Set<Lead> leadsSet = new HashSet<Lead>(0);

	public DepartmentDto() {
       
    }
    
	public DepartmentDto(String departmentId, String customerId, String departmentName, String departmentDescription,
			String departmentParentDepartment) {
		this.departmentId = departmentId;
		this.customerId = customerId;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.departmentParentDepartment = departmentParentDepartment;
	}

	public DepartmentDto(String departmentId, String customerId, String departmentName, String departmentDescription,
			String departmentParentDepartment, Set<Lead> leadsSet) {
		super();
		this.departmentId = departmentId;
		this.customerId = customerId;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.departmentParentDepartment = departmentParentDepartment;
		this.leadsSet = leadsSet;
	}
	
	public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public String getDepartmentParentDepartment() {
		return departmentParentDepartment;
	}

	public void setDepartmentParentDepartment(String departmentParentDepartment) {
		this.departmentParentDepartment = departmentParentDepartment;
	}

	public Set<Lead> getLeadsSet() {
		return leadsSet;
	}

	public void setLeadsSet(Set<Lead> leadsSet) {
		this.leadsSet = leadsSet;
	}
}
