package com.coviam.internalapp.hrms.employee.adapter;

import com.coviam.internalapp.hrms.employee.dao.EmployeeRepository;
import com.coviam.internalapp.hrms.employee.dto.EmployeeProjectDTO;
import com.coviam.internalapp.hrms.employee.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by coviam on 27/01/17.
 */
@Service
public class EmployeeProjectAdapter {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;


    public EmployeeProjectDTO convertToDTOProjects(Employee employee){
        return modelMapper.map(employee,EmployeeProjectDTO.class);
    }
}
