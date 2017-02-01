package com.coviam.internalapp.hrms.employee.adaptor;

import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import com.coviam.internalapp.hrms.educationaldetails.service.imp.EducationDetailsServiceImp;
import com.coviam.internalapp.hrms.employee.dto.EmployeeBasicDto;
import com.coviam.internalapp.hrms.employee.dto.EmployeeContactDto;
import com.coviam.internalapp.hrms.employee.dto.EmployeeDependentDto;
import com.coviam.internalapp.hrms.employee.dto.EmployeeUpdateImageDto;
import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;
import com.coviam.internalapp.hrms.utils.ResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hardik on 27/01/17.
 */
@Service
public class EmployeeAdaptor {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EducationDetailsServiceImp educationDetailsServiceImp;

    public ResponseDto convertToEmployeeBasicDto(Employee employee) {
        ResponseDto responseDto;
        if(employee != null) {
            EmployeeBasicDto employeeBasicDto = modelMapper.map(employee, EmployeeBasicDto.class);
            List<EducationalDetails> educationDetails = educationDetailsServiceImp.getHigherStudy(employee.getCustomerId(), employee.getEmployeeId());
            if(educationDetails.size() != 0) {
                String higherStudy = educationDetails.get(0).getDegree();
                employeeBasicDto.setHigherStudy(higherStudy);
            }
            employeeBasicDto.setRoleResponsibilities(employee.getDesignation().getRoleResponsibilities());
            employeeBasicDto.setCriteriaForNextPromotion(employee.getDesignation().getCriteriaForNextPromotion());
            responseDto = new ResponseDto(200, employeeBasicDto);
        }
        else {
            responseDto = new ResponseDto(404, "Requested employee's basic detail not exist.");
        }
        return responseDto;
    }

    public ResponseDto convertToEmployeeDependentDto(Employee employee) {
        ResponseDto responseDto;
        if(employee != null) {
            Integer noOfMembers = employee.getDependentsList().size();
            EmployeeDependentDto employeeDependentDto = modelMapper.map(employee, EmployeeDependentDto.class);
            employeeDependentDto.setNoOfMember(noOfMembers);
            System.out.println(employee.getDependentsList().get(0).getDependentRelation());
//            employeeDependentDto.setDependentsList();
            responseDto = new ResponseDto(200, employeeDependentDto);
        }
        else {
            responseDto = new ResponseDto(404, "Requested employee's dependent detail not exist.");
        }
        return responseDto;
    }

    public ResponseDto convertToEmployeeContactDto(Employee employee) {
        ResponseDto responseDto;
        if(employee != null) {
            EmployeeContactDto employeeContactDto = modelMapper.map(employee, EmployeeContactDto.class);
            responseDto = new ResponseDto(200, employeeContactDto);
        }
        else {
            responseDto = new ResponseDto(404, "Requested employee's contact detail not exist.");
        }
        return responseDto;
    }

    public Employee convertToEmployeeEntity(EmployeeUpdateImageDto employeeUpdateImageDto) {
        return modelMapper.map(employeeUpdateImageDto, Employee.class);
    }

}
