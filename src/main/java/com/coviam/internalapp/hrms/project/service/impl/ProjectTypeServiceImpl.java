package com.coviam.internalapp.hrms.project.service.impl;

import com.coviam.internalapp.hrms.project.dao.ProjectTypeRepository;
import com.coviam.internalapp.hrms.project.entity.ProjectType;
import com.coviam.internalapp.hrms.project.service.ProjectTypeService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by coviam on 24/01/17.
 */
@Component
public class ProjectTypeServiceImpl implements ProjectTypeService {

    @Autowired
    ProjectTypeRepository projectTypeRepository;

    @Override
    public Boolean createProjectType(String name) {
        ProjectType projectType = new ProjectType(name,"0");
        projectTypeRepository.save(projectType);

        return true;
    }

    @Override
    public List<ProjectType> getAllProjectType(String custId) {
        return Lists.newArrayList(projectTypeRepository.findAll());
    }
}
