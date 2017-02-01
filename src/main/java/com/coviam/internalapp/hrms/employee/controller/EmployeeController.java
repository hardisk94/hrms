package com.coviam.internalapp.hrms.employee.controller;
import com.coviam.internalapp.hrms.department.dao.DepartmentRepository;
import com.coviam.internalapp.hrms.department.entity.Department;
import com.coviam.internalapp.hrms.designation.dao.DesignationRepository;
import com.coviam.internalapp.hrms.designation.entity.Designation;
import com.coviam.internalapp.hrms.designation.service.DesignationService;
import com.coviam.internalapp.hrms.employee.adaptor.EmployeeAdaptor;
import com.coviam.internalapp.hrms.employee.dao.EmployeeRepository;
import com.coviam.internalapp.hrms.employee.dto.EmployeeBasicDto;
import com.coviam.internalapp.hrms.employee.dto.EmployeeUpdateImageDto;
import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.employee.service.EmployeeService;
import com.coviam.internalapp.hrms.employee.dto.EmployeeContactDto;
import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.employee.service.EmployeeService;
import com.coviam.internalapp.hrms.location.service.LocationService;
import com.coviam.internalapp.hrms.utils.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
/**
 * Created by coviam on 27/01/17.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeAdaptor employeeAdaptor;
    @Autowired
    DesignationRepository designationRepository;
    @Autowired
    DesignationService designationService;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    Employee employee;
    LocationService location;
    Designation designation;
    Department department;
    @RequestMapping(value = "/getByEmployeeId/{employeeId}", method = RequestMethod.GET)
    public Employee getByEmployeeId (@PathVariable String employeeId) {
        return employeeService.getEmployee(employeeId);
    }
    @RequestMapping(value = "/basicDetails/getById/{customerId}/{employeeId}", method = RequestMethod.GET)
    public ResponseDto getBasicDetailsByEmployeeId (@PathVariable String customerId, @PathVariable String employeeId){
        Employee employee = employeeService.getEmployeeById(customerId, employeeId);
        return employeeAdaptor.convertToEmployeeBasicDto(employee);
    }
    @RequestMapping(value = "/dependentDetails/getById/{customerId}/{employeeId}", method = RequestMethod.GET)
    public ResponseDto getDependentDetailsByEmployeeId (@PathVariable String customerId, @PathVariable String employeeId){
        Employee employee = employeeService.getEmployeeById(customerId, employeeId);
        return employeeAdaptor.convertToEmployeeDependentDto(employee);
    }
    @RequestMapping(value = "/contactDetails/getById/{customerId}/{employeeId}", method = RequestMethod.GET)
    public ResponseDto getContactDetailsByEmployeeId (@PathVariable String customerId, @PathVariable String
            employeeId){
        Employee employee = employeeService.getEmployeeById(customerId, employeeId);
        return employeeAdaptor.convertToEmployeeContactDto(employee);
    }
    @RequestMapping(value = "/getAllEmployee/{customerId}", method = RequestMethod.GET)
    public List<Employee> getByEsopd (@PathVariable String customerId){
        return employeeService.getAllEmployeeDetails(customerId);
    }
    @RequestMapping(value="/updateEmployee",method=RequestMethod.PUT,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public String updateEmployeeBasic(EmployeeBasicDto employeeBasicDto)
    {
        Employee emp=employeeRepository.findOne(employeeBasicDto.getEmployeeId());
        String name=employeeBasicDto.getDesignationName();
        designation=designationService.getDesignationByName(name);
        String deptName=employeeBasicDto.getDepartmentName();
        department=departmentRepository.findBydepartmentName(deptName);
        emp.setDepartment(department);
        emp.setPhoneNumber(employeeBasicDto.getPhoneNumber());
        emp.setEmailId(employeeBasicDto.getEmailId());
        emp.setEmployeeName(employeeBasicDto.getEmployeeName());
        employeeRepository.save(emp);
        return "added Successfully";
    }
    @RequestMapping(value="/updateContact/{employeeId}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateContact(@PathVariable String employeeId, @RequestBody EmployeeContactDto employeeContactDto)
    {
        Employee emp=employeeRepository.findOne(employeeId);
        emp.setEmergencyContact(employeeContactDto.getGetEmergencyContact());
        emp.setEmergencyRelation(employeeContactDto.getEmergencyRelation());
        emp.setEmergencyAddress(employeeContactDto.getEmergencyAddress());
        emp.setEmergencyName(employeeContactDto.getEmergencyName());
        emp.setPermanentAddress(employeeContactDto.getPermanentAddress());
        emp.setFacebookId(employeeContactDto.getFacebookId());
        emp.setTwitterId(employeeContactDto.getTwitterId());
        emp.setSkypeId(employeeContactDto.getSkypeId());
        emp.setEmailId(employeeContactDto.getEmailId());
        emp.setPhoneNumber(employeeContactDto.getPhoneNumber());
        employeeRepository.save(emp);
        return "added Successfully";
    }
    @RequestMapping(value="/updateEmployee/{employeeId}",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public String updateEmployeeBasic(@PathVariable String employeeId ,@RequestBody EmployeeBasicDto employeeBasicDto)
    {
        Employee emp=employeeRepository.findOne(employeeId);
        String name=employeeBasicDto.getDesignationName();
        designation=designationService.getDesignationByName(name);
        emp.setDesignation(designation);
        String deptName=employeeBasicDto.getDepartmentName();
        department=departmentRepository.findBydepartmentName(deptName);
        emp.setDepartment(department);
        employeeRepository.save(emp);
        return "added Successfully";
    }
    @RequestMapping(value = "/uploadImage/{customerId}/{employeeId}", method = RequestMethod.PUT)
    public ResponseDto uploadEmployeeImage(@PathVariable String customerId, @PathVariable String employeeId, @RequestBody EmployeeUpdateImageDto empImageDto) {
        return employeeService.updloadImage(customerId, employeeId, empImageDto);
    }
    @RequestMapping("/image/download/{customerId}/{employeeId}")
    public ResponseDto downloadEmployeeImage(@PathVariable String customerId, @PathVariable String employeeId) throws Exception{
        byte[] byte_string = employeeService.getEmployeeById(customerId, employeeId).getImage();
        InputStream in = new ByteArrayInputStream(byte_string);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        ImageIO.write(bImageFromConvert, "jpg", new File("/Users/Coviam/Downloads/employee.jpg"));
        return new ResponseDto(200, "Done");
    }
}