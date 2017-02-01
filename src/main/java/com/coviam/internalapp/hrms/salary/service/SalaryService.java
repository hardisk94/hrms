package com.coviam.internalapp.hrms.salary.service;


import com.coviam.internalapp.hrms.salary.dto.SalaryDTO;
import com.coviam.internalapp.hrms.salary.entity.Salary;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;

/**
 * Created by JahnaviSuthar on 24/01/17.
 */
@Service
public interface SalaryService {

    public boolean addSalary(String customerId, String employeeId, Date dateOfChange,
                             long fixedSalary, long variableSalary, String notes);

    public boolean addSalary(SalaryDTO salaryDTO);

    public boolean deleteSalary(String customerId, String employeeId, Date dateOfChange);

    public boolean deleteSalary(String customerId, String employeeId);

    public Salary getSalary(String customerId, String employeeId, Date dateOfChange);

    public List<Salary> getSalary(String customerId, String employeeId);

    public boolean updateSalary(String customerId, String employeeId, Date dateOfChange,
                                long fixedSalary, long variableSalary, String notes);

    public boolean updateSalary(SalaryDTO salaryDTO);

    public Salary getCurrentSalary(String customerId, String employeeId);

    public List<Salary> getPreviousSalaries(String customerId, String employeeId);

    public Salary getPreviousSalary(String customerId, String employeeId);

}
