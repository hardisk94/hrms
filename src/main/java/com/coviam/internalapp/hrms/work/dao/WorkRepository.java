package com.coviam.internalapp.hrms.work.dao;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.work.entity.WorkExperience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by coviam on 23/01/17.
 */

@Repository
public interface WorkRepository extends CrudRepository<WorkExperience,String> {

    List<WorkExperience> findByEmployeeId(@Param(ColumnUtils.WORK_EMPLOYEE_ID) String empId);

    List<WorkExperience> findByEmployeeIdOrderByStartDateDesc(@Param(ColumnUtils.WORK_EMPLOYEE_ID) String empId);

}
