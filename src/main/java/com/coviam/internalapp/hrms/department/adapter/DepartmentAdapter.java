package com.coviam.internalapp.hrms.department.adapter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coviam.internalapp.hrms.department.dto.DepartmentDto;
import com.coviam.internalapp.hrms.department.entity.Department;

/**
 * Created by coviam on 30/01/17.
 */
@Service
public class DepartmentAdapter {
    @Autowired
    private ModelMapper modelMapper;

    public DepartmentDto convertToDto(Department department) {
        return modelMapper.map(department, DepartmentDto.class);
    }
    
    public Department convertToEntity(DepartmentDto departmentDto){
    	return modelMapper.map(departmentDto, Department.class);
    }
}
