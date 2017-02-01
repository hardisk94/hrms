package com.coviam.internalapp.hrms.dependent.service;

import com.coviam.internalapp.hrms.dependent.dto.DependentDTO;
import com.coviam.internalapp.hrms.dependent.entity.Dependent;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by ashwini on 23/01/17.
 */
@Service
public interface DependentService {

    public boolean addDependent(String customerId, String employeeId, String firstName, String middleName, String lastName,
                                Date dateOfBirth, String dependentGender, String dependentRelation);

    public boolean addDependent(DependentDTO dependentDTO);

    public boolean deleteDependent(String customerId, String employeeId, String firstName);

    public boolean deleteAllDependents(String customerId, String employeeId);

    public List<Dependent> getDependents(String customerId, String employeeId);

    public boolean updateDependent(String customerId, String employeeId, String firstName, String middleName, String lastName,
                                   Date dateOfBirth, String dependentGender, String dependentRelation);

    public boolean updateDependent(DependentDTO dependentDTO);



}
