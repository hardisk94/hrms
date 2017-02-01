package com.coviam.internalapp.hrms.designation.service;

import com.coviam.internalapp.hrms.designation.entity.Designation;

import java.util.List;

/**
 * Created by Saurabh on 23/01/17.
 */
public interface DesignationService  {
    //load only active objects for all the methods
    public List<Designation> getAlldesignation(String customerId);
    public Designation getDesignation(String customerId, String designationId);
    public List<Designation> getDesignationByDesignationCode(String customerId, String designationCode);
    public Designation updateDesignation(Designation designationObj) throws Exception;
    public Designation deleteDesignation(String customerId, String designationId);
    public Designation addDesignation(Designation designationObj)throws Exception;
    public Designation getDesignationByName(String name);
}
