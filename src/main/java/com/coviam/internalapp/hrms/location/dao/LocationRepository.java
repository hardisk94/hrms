package com.coviam.internalapp.hrms.location.dao;

import com.coviam.internalapp.hrms.location.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, String>{
    List<Location> findByCustomerIdAndLocationIsActive(String customerId, Boolean locationIsActive);
    Location findOneByCustomerIdAndLocationIdAndLocationIsActive(String customerId, String locationId, Boolean locationIsActive);
}
