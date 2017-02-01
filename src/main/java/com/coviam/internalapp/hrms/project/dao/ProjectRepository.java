package com.coviam.internalapp.hrms.project.dao;

import com.coviam.internalapp.hrms.project.entity.Project;
import com.coviam.internalapp.hrms.utils.ColumnUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,String> {

}
