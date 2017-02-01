package com.coviam.internalapp.hrms.employee.service.impl;

import com.coviam.internalapp.hrms.employee.dao.EmployeeRepository;
import com.coviam.internalapp.hrms.employee.dto.EmployeeUpdateImageDto;
import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.employee.service.EmployeeService;
import com.coviam.internalapp.hrms.utils.ResponseDto;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * Created by coviam on 24/01/17.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findByEmployeeName(String name) {
        return null;
    }

    @Override
    public Employee findByEmployeeCode(String employeeCode) {
        return null;
    }

    @Override
    public  Employee getEmployeeById(String customerId, String employeeId) {
        return employeeRepository.findByCustomerIdAndEmployeeId(customerId, employeeId);
    }
    @Override
    public Employee getEmployee(String employeeId)
    {

        Employee employee= employeeRepository.findOne(employeeId);
        if(employee == null){
            return null;
        }
        else{
            return employee;
        }
    }

    @Override
    public ResponseDto updloadImage(String customerId, String employeeId, EmployeeUpdateImageDto employeeUpdateImageDto) {
        ResponseDto responseDto;
        Employee employee = getEmployeeById(customerId, employeeId);
        if(employee != null) {
            byte[] imageInbytes = convertToByte(employeeUpdateImageDto.getImagePath());
            employee.setImage(imageInbytes);
            createEmployee(employee);
            responseDto = new ResponseDto(200, "Image uploaded successfully.");
        }
        else {
            responseDto = new ResponseDto(500, "something went wrong.");
        }
        return responseDto;
    }

    private byte[] convertToByte(String imagePath) {
        try {
            byte[] imageInByte;
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        }
        catch (Exception e) {
            return null;
        }
    }

    // to compress the byte array before stored into database
    public static byte[] compress(byte[] data) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        deflater.finish();
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer); // returns the generated code... index
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        byte[] output = outputStream.toByteArray();
        System.out.println("Original: " + data.length / 1024 + " Kb");
        System.out.println("Compressed: " + output.length / 1024 + " Kb");
        return output;
    }

    // to decompress the byte array after fetched from database
    public static byte[] decompress(byte[] data) throws IOException, DataFormatException {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        byte[] output = outputStream.toByteArray();
        System.out.println("Original: " + data.length);
        System.out.println("Compressed: " + output.length);
        return output;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void removeEmployee(String employee_id) {
        employeeRepository.delete(employee_id);
    }

    @Override
    public List<Employee> getAllEmployeeDetails(String customerId) {
        return (List<Employee>) employeeRepository.findAllByCustomerId(customerId);
    }
}
