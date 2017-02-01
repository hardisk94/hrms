package com.coviam.internalapp.hrms.employeestatus.service.impl;

import com.coviam.internalapp.hrms.employeestatus.dao.EmplyoeeStatusTypeRepository;
import com.coviam.internalapp.hrms.employeestatus.entity.EmployeeStatusType;
import com.coviam.internalapp.hrms.employeestatus.service.EmployeeStatusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by coviam on 25/01/17.
 */
@Component
public class EmployeeStatusTypeImpl implements EmployeeStatusTypeService {
    @Autowired
    EmplyoeeStatusTypeRepository emplyoeeStatusTypeRepository;

    @Override
    public EmployeeStatusType getEmployeeStatusTypeById(String empId) {
        return emplyoeeStatusTypeRepository.findOne( empId);
    }

    @Override
    public EmployeeStatusType addEmployeeStatusType(EmployeeStatusType employeeStatusTypeObj) {
        return emplyoeeStatusTypeRepository.save(employeeStatusTypeObj);

    }
}
