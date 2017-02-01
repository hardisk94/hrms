package com.coviam.internalapp.hrms.employeestatus.service;

import com.coviam.internalapp.hrms.employeestatus.entity.EmployeeStatusType;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeStatusTypeService {
    EmployeeStatusType getEmployeeStatusTypeById(String empId);
    EmployeeStatusType addEmployeeStatusType(EmployeeStatusType employeeStatusTypeObj);

}
