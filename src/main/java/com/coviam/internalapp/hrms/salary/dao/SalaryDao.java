package com.coviam.internalapp.hrms.salary.dao;

import com.coviam.internalapp.hrms.salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.sql.Date;

/**
 * Created by JahnaviSuthar on 24/01/17.
 */

@Repository
public interface SalaryDao extends JpaRepository<Salary,String>{

    public Salary findByCustomerIdAndEmployeeIdAndDateOfChangeAndIsActive(String customerId,
                                                                          String employeeId, Date dateOfChange,boolean isActive);

    public List<Salary> findByCustomerIdAndEmployeeIdAndIsActiveAndIsCurrent(String customerId,
                                                                          String employeeId,boolean isActive,
                                                                                      boolean isCurrent);


    public List<Salary> findByCustomerIdAndEmployeeIdAndIsActive(String customerId,
                                                                 String employeeId, boolean isActive);


}
