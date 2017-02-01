/**
 * 
 */
package com.coviam.internalapp.hrms.department.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.coviam.internalapp.hrms.department.entity.Department;
import com.coviam.internalapp.hrms.lead.entity.Lead;
import com.coviam.internalapp.hrms.utils.ResponseDto;

/**
 * @author Jyothi Prakash
 */
@Service
public interface DepartmentService {
	ResponseDto addDepartment(@RequestBody Department department);
	Department getDepartmentById(String departmentId);
	List<Department> getAllDepartment();
	List<Department> getAllDepartmentsByCustomerId(String customerId);
	ResponseDto updateDepartment(Department department);
	ResponseDto deleteDepartmentById(String departmentId);
	void deleteAllDepartment();
	ResponseDto addLeadByDepartmentId(String departmentId, Lead lead);
}
