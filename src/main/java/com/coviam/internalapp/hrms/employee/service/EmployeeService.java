package com.coviam.internalapp.hrms.employee.service;

import com.coviam.internalapp.hrms.employee.dto.EmployeeUpdateImageDto;
import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.utils.ResponseDto;

import java.util.List;

public interface EmployeeService {
    List<Employee> findByEmployeeName(String name);

    Employee findByEmployeeCode(String employeeCode);

    Employee getEmployeeById(String customerId, String employeeId);

    public void createEmployee(Employee employee);

    public void removeEmployee(String employee_id);

    List<Employee> getAllEmployeeDetails(String customerId);

    Employee getEmployee(String employeeId);

    public ResponseDto updloadImage(String customerId, String employeeId, EmployeeUpdateImageDto employeeUpdateImageDto);
}
