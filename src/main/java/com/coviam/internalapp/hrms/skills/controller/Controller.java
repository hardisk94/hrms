package com.coviam.internalapp.hrms.skills.controller;

import com.coviam.internalapp.hrms.skills.DTO.InsertDto;
import com.coviam.internalapp.hrms.skills.DTO.UpdateDto;
import com.coviam.internalapp.hrms.skills.entity.Skills;
import com.coviam.internalapp.hrms.skills.services.SkillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/skills")
@RestController
public class Controller {
    @Autowired
    SkillServices services;

    @RequestMapping(value = "/insert/", method = RequestMethod.POST)
    public ResponseEntity insertIntoTable(@RequestBody InsertDto insertDto)
    {
        Skills skills = services.insertBySkillTypeAndSkillName(insertDto.getSkillType(),insertDto.getEmployeeId(), insertDto.getDescription(),
                insertDto.getCustomerId(), insertDto.getSkillName(), insertDto.getProficiency());
        return new ResponseEntity(insertDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/list/{empId}/{custId}", method = RequestMethod.GET)
    public ResponseEntity getFromTableUsingEmpIdAndCustId(
            @PathVariable("empId") String empId,
            @PathVariable("custId") String custId
    ) {
        String name = new String();
        List<Skills> listSkills = services.getByEmpidAndCustId(empId, custId);
        List<String> names = new ArrayList<>();
        for (int i = 0; i < listSkills.size(); i++) {
            name = listSkills.get(i).getSkillName();
            names.add(name);
        }
        return new ResponseEntity(listSkills, HttpStatus.OK);
    }

    @RequestMapping(value = "/listEmployees/{customerId}/{skillName}", method = RequestMethod.GET)
    public ResponseEntity getEmployeesFromSkillName(
            @PathVariable("customerId") String customerId,
            @PathVariable("skillName") String skillName
    ) {
        List<Skills> empSkills = services.getEmployeesByCustomerIdAndSkillName(customerId,skillName);
        List<String> empIds = new ArrayList<>();
        for (int i = 0; i < empSkills.size(); i++) {
            empIds.add(empSkills.get(i).getEmployeeId());
        }
        return new ResponseEntity(empIds, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{empId}/{custId}/{skillName}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEntryFromTable(
            @PathVariable("empId") String empId,
            @PathVariable("custId") String custId,
            @PathVariable("skillName") String skillName) {
        List<Skills> listSkills = services.getByEmpidAndCustId(empId, custId);
        Skills skill = new Skills();
        for (int i = 0; i < listSkills.size(); i++) {
            if (listSkills.get(i).getSkillName() == skillName) {
                skill = services.deleteSkillByEmployeeIdAndSkillName(empId, custId, skillName);
            }
        }
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/", method = RequestMethod.PUT)
    public ResponseEntity updateSkill(@RequestBody UpdateDto skilldto){
        Skills skill = services.updateSkillNameByEmployeeId(skilldto.getEmployeeId(),skilldto.getCustomerId()
                ,skilldto.getOldSkillName(), skilldto.getNewSkillName());
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @RequestMapping(value = "/listSkillsTechnical/{empId}/{custId}", method = RequestMethod.GET)
    public ResponseEntity listSkillTechnical(
            @PathVariable("empId") String empId,
            @PathVariable("custId") String custId)

    {
        List<Skills> listSkills = services.listSkillsByEmployeeIdAndSkillType(empId, custId, "Technical");
        //List<List<Skills>> listOfListSkills = new ArrayList<List<Skills>>();
        //listOfListSkills.add(techSkills);
        //listOfListSkills.add(nonTechSkills);
        return new ResponseEntity(listSkills, HttpStatus.OK);
    }


    @RequestMapping(value = "/listSkillsNonTechnical/{empId}/{custId}", method = RequestMethod.GET)
    public ResponseEntity listSkillNonTechnical(
            @PathVariable("empId") String empId,
            @PathVariable("custId") String custId)

    {
        List<Skills> listSkills = services.listSkillsByEmployeeIdAndSkillType(empId, custId, "Non-Technical");
        //List<List<Skills>> listOfListSkills = new ArrayList<List<Skills>>();
        //listOfListSkills.add(techSkills);
        //listOfListSkills.add(nonTechSkills);
        return new ResponseEntity(listSkills, HttpStatus.OK);
    }



    @RequestMapping(value = "/updateProficiency/", method = RequestMethod.PUT)
    public ResponseEntity updateProficiency(@RequestBody InsertDto insertDto){
            Skills skill = services.updateSkillProficiencyByNameAndType(insertDto.getEmployeeId(),insertDto.getSkillName(),
                    insertDto.getSkillType(),insertDto.getProficiency());
            return new ResponseEntity(skill,HttpStatus.OK);
    }

}