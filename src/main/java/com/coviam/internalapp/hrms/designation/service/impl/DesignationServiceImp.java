package com.coviam.internalapp.hrms.designation.service.impl;

import com.coviam.internalapp.hrms.designation.entity.Designation;
import com.coviam.internalapp.hrms.designation.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coviam.internalapp.hrms.designation.dao.DesignationRepository;
import java.util.List;
import javax.transaction.Transactional;


/**
 * Created by coviam on 24/01/17.
 */
@Service
public class DesignationServiceImp implements DesignationService {

    @Autowired
    DesignationRepository designationRepository;

    //all functions load when active
    @Override
    public List<Designation> getAlldesignation(String customerId) {
        return designationRepository.findAllByCustomerIdAndIsActive(customerId, true);
    }

    @Override
    public Designation getDesignation(String customerId, String designationId) {
        return designationRepository.findOneByCustomerIdAndDesignationIdAndIsActive(customerId, designationId, true);
    }

    @Override
    public List<Designation> getDesignationByDesignationCode(String customerId, String designationCode) {
        return designationRepository.findAllByCustomerIdAndDesignationCodeAndIsActive(customerId, designationCode, true);
    }
    @Override
    public Designation getDesignationByName(String name)
    {
        return designationRepository.findByDesignationName(name);
    }

    @Override
    public Designation updateDesignation(Designation designationObj) throws  Exception {
        if(designationObj==null)
            throw new Exception("Designation object is empty");
        else if(designationObj.getCustomerId()==null || designationObj.getCriteriaForNextPromotion()==null || designationObj.getDesignationCode()==null || designationObj.getDesignationDesc()==null || designationObj.getDesignationId()==null || designationObj.getDesignationName()== null || designationObj.getRoleResponsibilities()==null || designationObj.getisActive()==false)
            throw new Exception("Details cannot be null");
        else{
        designationObj.setActive(true);
        return designationRepository.save(designationObj);}
    }


    @Override
    public Designation deleteDesignation(String customerId, String designationId) {
        Designation designation=getDesignation(customerId,designationId);
        designation.setActive(false);
        return designationRepository.save(designation);

    }

    @Override
    public Designation addDesignation(Designation designationObj) throws Exception{
        if(designationObj==null)
            throw new Exception("Designation Object is Empty");
        if(designationObj.getCriteriaForNextPromotion()==null || designationObj.getCustomerId() == null || designationObj.getDesignationCode()==null || designationObj.getDesignationDesc()==null || designationObj.getDesignationName()== null || designationObj.getRoleResponsibilities()==null)
            throw new Exception("Details cannot be null");
        else{
        designationObj.setActive(true);
        return designationRepository.save(designationObj);}



    }
}





