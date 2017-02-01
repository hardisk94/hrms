
package com.coviam.internalapp.hrms.emptype.entity;


/**
 * Created by coviam on 24/01/17.
 */
import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import javax.persistence.*;

@Entity
@Table(name=TableUtils.EMPLOYEE_TYPE)
public class EmployeeType {
    @Id
    @GeneratedValue
    @Column(name=ColumnUtils.EMPLOYEE_TYPE_EMPTYPE_ID)
    private String id;
    @Column(name=ColumnUtils.EMPLOYEE_TYPE_EMP_TYPE)
    private String type;
    @Column(name=ColumnUtils.EMPLOYEE_TYPE_DESCRIPTION)
    private  String description;
    @Column(name=ColumnUtils.EMP_DETAIL_CUSTOMER_ID)
    private String customerNumber;

    public EmployeeType() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}


