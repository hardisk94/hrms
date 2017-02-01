package com.coviam.internalapp.hrms.work.dao;

import com.coviam.internalapp.hrms.work.entity.VisaDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by coviam on 24/01/17.
 */
@Repository
public interface VisaRepository extends JpaRepository<VisaDetail, String> {
    public List<VisaDetail> findByCustomerIdAndEmployeeId(String customerId, String employeeId);
}
