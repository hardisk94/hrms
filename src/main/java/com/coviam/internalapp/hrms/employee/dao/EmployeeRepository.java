package com.coviam.internalapp.hrms.employee.dao;


import com.coviam.internalapp.hrms.employee.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,String> {
/*
    List<Employee> findByEmployeeName(String firstName);
    List<Employee>findByEmployeeCode(String employeeCode);
    */
    Employee findByCustomerIdAndEmployeeId(String customerId, String employeeId);
    List<Employee> findAllByCustomerId(String customerId);
}
