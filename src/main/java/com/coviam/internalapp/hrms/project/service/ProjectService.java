package com.coviam.internalapp.hrms.project.service;

import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.project.dto.AddProjectDTO;
import com.coviam.internalapp.hrms.project.dto.ProjectDTO;
import com.coviam.internalapp.hrms.project.entity.Project;
import com.coviam.internalapp.hrms.project.entity.ProjectType;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface ProjectService {
    Project getProjectById(String projId);
    Employee getProjectOwner(String projId);
    ProjectType getProjectType(String projId);
    Boolean deleteProject(String projId);
    Boolean addProject(AddProjectDTO addProjectDTO,String customerId);
    Boolean updateProject(String projId, String  projName, String projTypeId, Date startDate, Date endDate);

    List<Project> getAllProjectOfEmployeeId(String employeeId);

    List<ProjectDTO> getAllProjects(String custId);
}
