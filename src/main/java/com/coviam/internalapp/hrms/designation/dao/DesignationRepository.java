package com.coviam.internalapp.hrms.designation.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.coviam.internalapp.hrms.designation.entity.Designation;

import java.util.List;

/**
 * Created by Saurabh on 23/01/17.
 */
@Repository
public interface DesignationRepository extends JpaRepository<Designation,String> {
    //public Designation findByEmployeeId(String employeeId);
    public List<Designation> findAllByCustomerIdAndIsActive(String customerId, Boolean isActive);
    public Designation findOneByCustomerIdAndDesignationIdAndIsActive(String customerID, String designationId, Boolean isActive);
    public List<Designation> findAllByCustomerIdAndDesignationCodeAndIsActive(String customerId, String designationCode,Boolean isActive);
    public Designation findByDesignationCode(String customerId, String designationCode);
    public Designation findByDesignationName(String name);
}