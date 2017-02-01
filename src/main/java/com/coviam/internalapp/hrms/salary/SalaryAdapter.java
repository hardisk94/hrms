package com.coviam.internalapp.hrms.salary;

import com.coviam.internalapp.hrms.salary.dto.SalaryGetDTO;
import com.coviam.internalapp.hrms.salary.entity.Salary;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JahnaviSuthar on 30/01/17.
 */
@Service
public class SalaryAdapter {

    @Autowired
    private ModelMapper modelMapper;

    public SalaryGetDTO convertToDto(Salary salary){
        SalaryGetDTO salaryGetDTO = modelMapper.map(salary,SalaryGetDTO.class);
        return salaryGetDTO;
    }
}
