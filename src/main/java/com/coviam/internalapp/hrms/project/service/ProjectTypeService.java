package com.coviam.internalapp.hrms.project.service;

import com.coviam.internalapp.hrms.project.entity.ProjectType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by coviam on 24/01/17.
 */
@Service
public interface ProjectTypeService {
    Boolean createProjectType(String name);

    List<ProjectType> getAllProjectType(String custId);
}
