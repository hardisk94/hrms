package com.coviam.internalapp.hrms.skills.DTO;

import com.coviam.internalapp.hrms.skills.entity.Skills;

import java.util.List;

/**
 * Created by coviam on 27/01/17.
 */
public class SkillDto {
    private List<Skills> skills;

    public List<Skills> getSkills() {
        return skills;
    }

    public SkillDto(List<Skills> skills) {
        this.skills = skills;
    }

    public SkillDto() {
    }

    public void setSkills(List<Skills> skills) {

        this.skills = skills;
    }
}