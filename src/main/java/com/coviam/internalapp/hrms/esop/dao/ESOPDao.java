package com.coviam.internalapp.hrms.esop.dao;

import com.coviam.internalapp.hrms.esop.entity.ESOP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Saurabh on 24/01/17.
 */
@Repository
public interface ESOPDao extends CrudRepository<ESOP, String> {

    public List<ESOP> findByCustomerIdAndEmployeeIdOrderByDateOfferedAsc(@Param("customerId") String customerId,@Param("employeeId") String employeeId);
    public List<ESOP> findByCustomerIdAndEmployeeId(@Param("customerId") String customerId,@Param("employeeId") String employeeId);

    public List<ESOP> findAllByOrderByDateOfferedAsc();
}
