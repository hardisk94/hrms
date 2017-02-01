package com.coviam.internalapp.hrms.dependent.service.impl;

import com.coviam.internalapp.hrms.dependent.dao.DependentDao;
import com.coviam.internalapp.hrms.dependent.dto.DependentDTO;
import com.coviam.internalapp.hrms.dependent.entity.Dependent;
import com.coviam.internalapp.hrms.dependent.service.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

/**
 * Created by JahnaviSuthar on 25/01/17.
 */
@Component
public class DependentServiceImpl implements DependentService{

    @Autowired
    DependentDao dependentDao;

    @Transactional
    @Override
    public boolean addDependent(String customerId, String employeeId, String firstName, String middleName,
                                String lastName, Date dateOfBirth, String dependentGender, String dependentRelation) {

        if(customerId != null && employeeId != null && firstName != null){

            if(dependentDao.findByCustomerIdAndEmployeeIdAndFirstNameAndIsActive(customerId,employeeId,
                    firstName,true) == null){
                if(lastName != null && dateOfBirth != null && dependentGender != null && dependentRelation!= null) {
                    dependentDao.save(new Dependent(employeeId, customerId,
                            firstName,middleName,lastName,dateOfBirth,dependentGender,dependentRelation));
                    return true;
                }
            }

        }
        return false;
    }

    @Transactional
    @Override
    public boolean addDependent(DependentDTO dependentDTO) {

        String customerId = dependentDTO.getCustomerId();
        String employeeId = dependentDTO.getEmployeeId();
        String firstName = dependentDTO.getDependentFirstName();
        String lastName = dependentDTO.getDependentLastName();
        String middleName = dependentDTO.getDependentMiddleName();
        String dateOfBirth = dependentDTO.getDateOfBirth();
        String gender = dependentDTO.getDependentGender();
        String relation = dependentDTO.getDependentRelation();


        if(customerId != null && employeeId != null && firstName != null
                && lastName != null && dateOfBirth != null && gender != null){



            if(dependentDao.findByCustomerIdAndEmployeeIdAndFirstNameAndIsActive(customerId,employeeId,
                    firstName,true) == null){

                Date date = Date.valueOf(dateOfBirth);

                Dependent d = dependentDao.findByCustomerIdAndEmployeeIdAndFirstNameAndIsActive(customerId,employeeId,
                        firstName,false);

                if(d != null){
                    d.setDateofBirth(date);
                    d.setMiddleName(middleName);
                    d.setLastName(lastName);
                    d.setDependentGender(gender);
                    d.setDependentRelation(relation);
                    d.setActive(true);
                }
                else{
                    d = new Dependent(employeeId,customerId,firstName,
                            middleName,lastName,date,gender,relation);

                }
                dependentDao.save(d);
                return true;
            }

        }
        return false;
    }


    @Transactional
    @Override
    public boolean deleteDependent(String customerId, String employeeId, String firstName) {
        if(customerId != null && employeeId != null && firstName != null){
            Dependent d = dependentDao.findByCustomerIdAndEmployeeIdAndFirstNameAndIsActive(customerId,employeeId,
                    firstName,true);
            if(d != null){
                d.setActive(false);
                return true;
            }
        }
        return false;
    }

    @Transactional
    @Override
    public boolean deleteAllDependents(String customerId, String employeeId) {
        if(customerId != null && employeeId != null){
            List<Dependent> dependentList = dependentDao.findByCustomerIdAndEmployeeIdAndIsActive(customerId,
                    employeeId,true);
            if(dependentList.size() > 0){
                for(Dependent d : dependentList)
                    d.setActive(false);
                return true;
            }
        }
        return false;
    }

    @Transactional
    @Override
    public List<Dependent> getDependents(String customerId, String employeeId) {
        if(customerId != null && employeeId != null){
            return dependentDao.findByCustomerIdAndEmployeeIdAndIsActive(customerId,
                    employeeId,true);
        }
        return null;
    }

    @Transactional
    @Override
    public boolean updateDependent(String customerId, String employeeId, String firstName, String middleName,
                                   String lastName, Date dateOfBirth, String dependentGender, String dependentRelation) {

        if(customerId != null && employeeId != null && firstName != null){

            Dependent d = dependentDao.findByCustomerIdAndEmployeeIdAndFirstNameAndIsActive(customerId,
                    employeeId, firstName,true);
            if(d != null){
                if(lastName != null && dateOfBirth != null && dependentGender != null && dependentRelation!= null) {
                    d.setMiddleName(middleName);
                    d.setLastName(lastName);
                    d.setDateofBirth(dateOfBirth);
                    d.setDependentGender(dependentGender);
                    d.setDependentRelation(dependentRelation);
                    return true;
                }
            }

        }
        return false;
    }

    @Transactional
    @Override
    public boolean updateDependent(DependentDTO dependentDTO) {


        String customerId = dependentDTO.getCustomerId();
        String employeeId = dependentDTO.getEmployeeId();
        String firstName = dependentDTO.getDependentFirstName();
        String lastName = dependentDTO.getDependentLastName();
        String middleName = dependentDTO.getDependentMiddleName();
        String dateOfBirth = dependentDTO.getDateOfBirth();
        String gender = dependentDTO.getDependentGender();
        String relation = dependentDTO.getDependentRelation();

        if(customerId != null && employeeId != null && firstName != null){

            Dependent d = dependentDao.findByCustomerIdAndEmployeeIdAndFirstNameAndIsActive(customerId,
                    employeeId, firstName,true);
            if(d != null){
                if(lastName != null && dateOfBirth != null && gender != null && relation!= null) {
                    Date date = Date.valueOf(dateOfBirth);
                    d.setMiddleName(middleName);
                    d.setLastName(lastName);
                    d.setDateofBirth(date);
                    d.setDependentGender(gender);
                    d.setDependentRelation(relation);
                    return true;
                }
            }

        }
        return false;
    }
}
