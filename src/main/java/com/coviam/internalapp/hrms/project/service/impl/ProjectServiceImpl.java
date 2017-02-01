package com.coviam.internalapp.hrms.project.service.impl;

import com.coviam.internalapp.hrms.employee.dao.EmployeeRepository;
import com.coviam.internalapp.hrms.employee.entity.Employee;
import com.coviam.internalapp.hrms.project.Adapter.ProjectAdapter;
import com.coviam.internalapp.hrms.project.dao.ProjectRepository;
import com.coviam.internalapp.hrms.project.dao.ProjectTypeRepository;
import com.coviam.internalapp.hrms.project.dto.AddProjectDTO;
import com.coviam.internalapp.hrms.project.dto.ProjectDTO;
import com.coviam.internalapp.hrms.project.entity.Project;
import com.coviam.internalapp.hrms.project.entity.ProjectType;
import com.coviam.internalapp.hrms.project.service.ProjectService;
import com.coviam.internalapp.hrms.project.service.ProjectTypeService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * Created by coviam on 24/01/17.
 */
@Component
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectTypeRepository projectTypeRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectAdapter projectAdapter;

    @Override
    public Project getProjectById(String projId) {
        return projectRepository.findOne(projId);
    }

    @Override
    public Employee getProjectOwner(String projId) {

        //Project project = projectRepository.findOne(projId);
        //String employeeId = project.getProjectOwner();
        //get Employee by Id and return Employee
        return null;
    }

    @Override
    public ProjectType getProjectType(String projId) {

        Project project = projectRepository.findOne(projId);

        return project.getProjectTypeObj();
    }

    @Override
    public Boolean deleteProject(String projId) {
        Project project = projectRepository.findOne(projId);
        project.setActive(false);
        projectRepository.save(project);
        return true;
    }

    @Override
    public Boolean addProject(AddProjectDTO addProjectDTO,String customerId) {
        Project project = projectAdapter.convertAddProjectDTOtoProjectEntity(addProjectDTO);
        project.setCustomerId(customerId);
        Employee employee = employeeRepository.findOne(addProjectDTO.getEmployeeId());

        projectRepository.save(project);
        employee.getProjects().add(project);

        employeeRepository.save(employee);
        return true;
    }

    @Override
    public Boolean updateProject(String projId, String projName, String projTypeId, Date startDate, Date endDate) {
        Project project = projectRepository.findOne(projId);
        ProjectType projectType = projectTypeRepository.findOne(projTypeId);

        project.setName(projName);
        project.setProjectTypeObj(projectType);
        project.setStartDate(startDate);
        project.setEndDate(endDate);

        projectRepository.save(project);

        return true;
    }

    @Override
    public List<Project> getAllProjectOfEmployeeId(String employeeId) {
        Employee employee = employeeRepository.findOne(employeeId);

        return employee.getProjectsList();
    }

    @Override
    public List<ProjectDTO> getAllProjects(String custId) {

        List<Project> projects = Lists.newArrayList(projectRepository.findAll());

        return projectAdapter.convertToProjectListDTO(projects);
    }
}
