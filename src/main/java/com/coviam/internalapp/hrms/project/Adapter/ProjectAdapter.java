package com.coviam.internalapp.hrms.project.Adapter;

import com.coviam.internalapp.hrms.employee.dao.EmployeeRepository;
import com.coviam.internalapp.hrms.project.dao.ProjectRepository;
import com.coviam.internalapp.hrms.project.dao.ProjectTypeRepository;
import com.coviam.internalapp.hrms.project.dto.AddProjectDTO;
import com.coviam.internalapp.hrms.project.dto.ProjectDTO;
import com.coviam.internalapp.hrms.project.dto.UpdateProjectDTO;
import com.coviam.internalapp.hrms.project.entity.Project;
import com.coviam.internalapp.hrms.project.entity.ProjectType;
import com.coviam.internalapp.hrms.project.service.ProjectService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by coviam on 27/01/17.
 */
@Service
public class ProjectAdapter {


    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Boolean convertProjectDTOtoEntityUpdate(UpdateProjectDTO updateProjectDTO){

        //Project project = modelMapper.map(projectDTO,Project.class);
        ProjectType projectType = projectTypeRepository.findByName(updateProjectDTO.getType());

        Date startDate = Date.valueOf(updateProjectDTO.getStartDate());
        Date endDate = Date.valueOf(updateProjectDTO.getEndDate());

        projectService.updateProject(updateProjectDTO.getId(),updateProjectDTO.getName(),projectType.getId(),startDate,endDate);

        return true;
    }

    public List<ProjectDTO> convertToProjectListDTO(List<Project> projects){
        return projects.stream().map(project -> convertToDTO(project)).collect(Collectors.toList());
    }


    private ProjectDTO convertToDTO(Project project){
        return modelMapper.map(project,ProjectDTO.class);
    }

    public Project convertAddProjectDTOtoProjectEntity(AddProjectDTO addProjectDTO){
        ProjectType projectType = projectTypeRepository.findByName(addProjectDTO.getProjectTypeName());
        Project project = new Project(addProjectDTO.getName(),addProjectDTO.getProjectDesc(),Date.valueOf(addProjectDTO.getStartDate()),Date.valueOf(addProjectDTO.getEndDate()),projectType,addProjectDTO.getCustomerId());

        return project;

    }
}
