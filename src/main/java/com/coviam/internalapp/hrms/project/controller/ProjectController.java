package com.coviam.internalapp.hrms.project.controller;

import com.coviam.internalapp.hrms.employee.adapter.EmployeeProjectAdapter;
import com.coviam.internalapp.hrms.employee.dto.EmployeeProjectDTO;
import com.coviam.internalapp.hrms.employee.service.EmployeeService;
import com.coviam.internalapp.hrms.project.Adapter.ProjectAdapter;
import com.coviam.internalapp.hrms.project.dto.AddProjectDTO;
import com.coviam.internalapp.hrms.project.dto.ProjectDTO;
import com.coviam.internalapp.hrms.project.dto.UpdateProjectDTO;
import com.coviam.internalapp.hrms.project.entity.Project;
import com.coviam.internalapp.hrms.project.entity.ProjectType;
import com.coviam.internalapp.hrms.project.service.ProjectService;
import com.coviam.internalapp.hrms.project.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by coviam on 25/01/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectTypeService projectTypeService;

    @Autowired
    EmployeeProjectAdapter employeeProjectAdapter;

    @Autowired
    ProjectAdapter projectAdapter;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
    public List<ProjectDTO> getAllProjects(@PathVariable("customerId") String customerId){

        return projectService.getAllProjects(customerId);
    }

    @RequestMapping(value = "/add/{customerId}",method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded; charset=UTF-8")
    public String addProject(AddProjectDTO addProjectDTO, @PathVariable("customerId") String customerId){

        projectService.addProject(addProjectDTO,customerId);

        return "Project Added";
    }

    @RequestMapping(value = "/addProjectType/{customerId}")
    public String addProjectType(@RequestBody ProjectType projectType, @PathVariable("customerId") String customerId){

        projectTypeService.createProjectType(projectType.getName());
        return "project type added";
    }

    @RequestMapping(value = "/update",consumes = "application/x-www-form-urlencoded; charset=UTF-8")
    public String updateProject(UpdateProjectDTO updateProjectDTO){
        projectAdapter.convertProjectDTOtoEntityUpdate(updateProjectDTO);
        return "Project Updated";
    }

    @RequestMapping(value = "/getAllProjectType/{customerId}",method = RequestMethod.GET)
    public List<ProjectType> getAllProjectTypes(@PathVariable("customerId") String customerId){
        return projectTypeService.getAllProjectType(customerId);
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Project getProjectById(@PathVariable("id") String id){
        return projectService.getProjectById(id);
    }

    @RequestMapping(value = "/getProjectType/{projId}",method = RequestMethod.GET)
    public ProjectType getProjectType(@PathVariable("projId") String projId){
        return projectService.getProjectType(projId);
    }

    @RequestMapping(value = "/deleteProject/{projId}",method = RequestMethod.GET)
    public String deleteProject(@PathVariable("projId") String projId){
        projectService.deleteProject(projId);

        return "delete Project" + projId;
    }

    @RequestMapping(value = "/getEmployeeProject/{customerId}/{employeeId}")
    public EmployeeProjectDTO getEmployeeProjects(@PathVariable("employeeId") String employeeId,@PathVariable("customerId") String customerId){
        return  employeeProjectAdapter.convertToDTOProjects(employeeService.getEmployeeById(customerId,employeeId));
    }




}
