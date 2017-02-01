package com.coviam.internalapp.hrms.work.dao;

import com.coviam.internalapp.hrms.work.entity.PassportDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by coviam on 24/01/17.
 */
@Repository
public interface PassportRepository extends JpaRepository<PassportDetails, String> {

}
