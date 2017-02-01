package com.coviam.internalapp.hrms.designation.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

    /**
     * Created by Saurabh on 23/01/17.
     */
    @Entity
    @Table(name=TableUtils.DESIGNATION_TABLE)
    public class Designation implements Serializable{
        private static final long serialVersionUID = 210120121344L;
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid2")
        @Column(name=ColumnUtils.DESIGNATION_ID)
        private String designationId;
        @Column(name=ColumnUtils.CUSTOMER_ID)
        private String customerId;
        @Column(name = ColumnUtils.DESIGNATION_NAME)
        private String designationName;
        @Column(name = ColumnUtils.DESIGNATION_DESC)
        private String designationDesc;
        @Column(name = ColumnUtils.DESIGNATION_ROLE)
        private String roleResponsibilities;
        @Column(name= ColumnUtils.DESIGNATION_PROMO)
        private String criteriaForNextPromotion;
        @Column(name=ColumnUtils.DESIGNATION_CODE)
        private String designationCode;
        @Column(name=ColumnUtils.DESIGNATION_ISACTIVE)
        private boolean isActive ;

        public Designation(){

        }


        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

        public String getDesignationId() {
            return designationId;
        }

        public void setDesignationId(String designationId) {
            this.designationId = designationId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
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

        public String getDesignationCode() {
            return designationCode;
        }

        public void setDesignationCode(String designationCode) {
            this.designationCode = designationCode;
        }

        public boolean getisActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public Designation(String designationId, String customerId, String designationName, String designationDesc, String roleResponsibilities, String criteriaForNextPromotion, String designationCode, boolean isActive) {
            this.designationId = designationId;
            this.customerId = customerId;
            this.designationName = designationName;
            this.designationDesc = designationDesc;
            this.roleResponsibilities = roleResponsibilities;
            this.criteriaForNextPromotion = criteriaForNextPromotion;
            this.designationCode = designationCode;
            this.isActive = isActive;
        }


        @Override
        public String toString() {
            return "Designation{" +
                    "designationId='" + designationId + '\'' +
                    ", customerId='" + customerId + '\'' +
                    ", designationName='" + designationName + '\'' +
                    ", designationDesc='" + designationDesc + '\'' +
                    ", roleResponsibilities='" + roleResponsibilities + '\'' +
                    ", criteriaForNextPromotion='" + criteriaForNextPromotion + '\'' +
                    ", designationCode='" + designationCode + '\'' +
                    ", isActive=" + isActive +
                    '}';
        }
    }
