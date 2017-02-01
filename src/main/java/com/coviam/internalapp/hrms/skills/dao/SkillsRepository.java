package com.coviam.internalapp.hrms.skills.dao;

import com.coviam.internalapp.hrms.skills.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SkillsRepository extends JpaRepository<Skills,String>,CustomeSkillRepository{

}