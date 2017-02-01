package com.coviam.internalapp.hrms.project.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by coviam on 23/01/17.
 */
@Entity
@Table(name = TableUtils.PROJECT_TYPE_TABLE)
public class ProjectType {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.PROJECT_PRODUCT_TYPE_ID)
    private String id;
    @Column(name = ColumnUtils.PROJECT_PRODUCT_TYPE_NAME)
    private String name;

    @Column(name = ColumnUtils.PROJECT_PRODUCT_TYPE_CUST_ID)
    private String customerId ;

    public ProjectType() {

    }

    public ProjectType(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
