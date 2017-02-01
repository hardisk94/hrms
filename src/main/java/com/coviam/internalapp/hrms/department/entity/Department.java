/**
 * 
 */
package com.coviam.internalapp.hrms.department.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.coviam.internalapp.hrms.lead.entity.Lead;
import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;

/**
 *  @author Jyothi Prakash
 */
@Entity
@Table(name = TableUtils.DEPARTMENT_TABLE)
public class Department implements Serializable {
	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name=ColumnUtils.DEPARTMENT_ID)
	private String departmentId;
	
	@Column(name=ColumnUtils.DEPARTMENT_CUSTOMER_ID)//, nullable = false)
	private String customerId;
	
	@Column(name=ColumnUtils.DEPARTMENT_NAME)//, nullable = false)//, length = 64)
	private String departmentName;
	
	@Column(name=ColumnUtils.DEPARTMENT_DESCRIPTION)
	private String departmentDescription;	
	
	@Column(name=ColumnUtils.DEPARTMENT_PARENT_DEPARTMENT)
	private String departmentParentDepartment;
	
	@ManyToMany(/*fetch = FetchType.LAZY,*/ cascade = CascadeType.ALL)
	@JoinTable(name = "department_lead",
				joinColumns = { @JoinColumn(name = ColumnUtils.DEPARTMENT_ID) },
				inverseJoinColumns = { @JoinColumn(name = ColumnUtils.LEAD_ID) })
	private Set<Lead> leadsSet = new HashSet<Lead>(0);
	
	public Set<Lead> getLeadsSet() {
		return leadsSet;
	}

	public void setLeadsSet(Set<Lead> leadsSet) {
		this.leadsSet = leadsSet;
	}

	public Department(){
		
	}

	public Department(String departmentId, String customerId, String departmentName, String departmentDescription,
			String departmentParentDepartment) {
		this.departmentId = departmentId;
		this.customerId = customerId;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.departmentParentDepartment = departmentParentDepartment;
	}
	
	public Department(String departmentId, String customerId, String departmentName, String departmentDescription,
			String departmentParentDepartment, Set<Lead> leadsSet) {
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

}
