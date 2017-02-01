package com.coviam.internalapp.hrms.bankdetails.dao;


import com.coviam.internalapp.hrms.bankdetails.entity.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ashwini on 1/23/17.
 */

@Repository
public interface BankDetailRepository extends JpaRepository<BankDetail,String>
{

    public BankDetail findByCustomerIdAndEmployeeId(String customerId,String employeeId);

}





