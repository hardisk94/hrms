package com.coviam.internalapp.hrms.educationaldetails.entity;

import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by karan on 24/01/17.
 */

@Entity
@Table(name = TableUtils.GRADE_TYPE)
public class GradeType implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ColumnUtils.GRADETYPE_ID)
    private String id;
    @Column(name = ColumnUtils.GRADETYPE_TYPE)
    private String type;
    @Column(name = ColumnUtils.GRADETYPE_SCALE)
    private float scale;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
