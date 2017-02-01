package com.coviam.internalapp.hrms.dependent.dao;

import com.coviam.internalapp.hrms.dependent.entity.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.coviam.internalapp.hrms.department.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ashwini on 23/01/17.
 */
@Repository
public interface DependentDao extends JpaRepository<Dependent, String> {

    public Dependent findByCustomerIdAndEmployeeIdAndFirstNameAndIsActive(String customerId,
                                                                     String employeeId, String firstName,boolean isActive);

    public List<Dependent> findByCustomerIdAndEmployeeIdAndIsActive(String customerId, String employeeId, boolean isActive);
}
