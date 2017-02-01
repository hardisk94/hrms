package com.coviam.internalapp.hrms.designation.dto;

/**
 * Created by Hardik on 27/01/17.
 */
public class DesignationDto {
    private String designationId;
    private String designationName;
    private String designationDesc;
    private String roleResponsibilities;
    private String criteriaForNextPromotion;

    public DesignationDto() {
    }

    public DesignationDto(String designationId, String designationName, String designationDesc, String roleResponsibilities, String criteriaForNextPromotion) {
        this.designationId = designationId;
        this.designationName = designationName;
        this.designationDesc = designationDesc;
        this.roleResponsibilities = roleResponsibilities;
        this.criteriaForNextPromotion = criteriaForNextPromotion;
    }

    public String getDesignationId() {
        return designationId;
    }

    public void setDesignationId(String designationId) {
        this.designationId = designationId;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getDesignationDesc() {
        return designationDesc;
    }

    public void setDesignationDesc(String designationDesc) {
        this.designationDesc = designationDesc;
    }

    public String getRoleResponsibilities() {
        return roleResponsibilities;
    }

    public void setRoleResponsibilities(String roleResponsibilities) {
        this.roleResponsibilities = roleResponsibilities;
    }

    public String getCriteriaForNextPromotion() {
        return criteriaForNextPromotion;
    }

    public void setCriteriaForNextPromotion(String criteriaForNextPromotion) {
        this.criteriaForNextPromotion = criteriaForNextPromotion;
    }
}
