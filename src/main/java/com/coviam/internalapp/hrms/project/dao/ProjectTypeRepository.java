package com.coviam.internalapp.hrms.project.dao;

import com.coviam.internalapp.hrms.project.entity.ProjectType;
import com.coviam.internalapp.hrms.utils.ColumnUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by coviam on 24/01/17.
 */
@Repository
public interface ProjectTypeRepository extends CrudRepository<ProjectType,String> {

    ProjectType findByName(@Param(ColumnUtils.PROJECT_PRODUCT_TYPE_NAME) String name);

}
