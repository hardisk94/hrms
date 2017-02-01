package com.coviam.internalapp.hrms.department.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coviam.internalapp.hrms.department.entity.Department;

/**
 * @author Jyothi Prakash
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department , String> {
	public Department findBydepartmentName(String name);
	public List<Department> findBycustomerId(String customerId);
}
