package com.coviam.internalapp.hrms.educationaldetails.dao;

import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by coviam on 23/01/17.
 */
public interface EducationalDetailsRepository extends CrudRepository<EducationalDetails, String> {

    List<EducationalDetails> findByCustomerIdAndEmployeeId(String customerId,String employeeId);

    List<EducationalDetails> findByCustomerId(String customerId);

    EducationalDetails findByCustomerIdAndEmployeeIdAndDegree(String customerId,String employeeId, String degree);

    //EducationalDetails findByEmployeeId1(String employeeId);

    List<EducationalDetails> findByCustomerIdAndEmployeeIdOrderByGraduationDateDesc(String employeeId, String customerId);
}
