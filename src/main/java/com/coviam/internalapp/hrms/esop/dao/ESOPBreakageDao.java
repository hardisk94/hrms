package com.coviam.internalapp.hrms.esop.dao;

import com.coviam.internalapp.hrms.esop.entity.ESOP;
import com.coviam.internalapp.hrms.esop.entity.ESOPBreakage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Saurabh on 24/01/17.
 */
@Repository
public interface ESOPBreakageDao extends CrudRepository<ESOPBreakage, String> {
//    public void deleteByEsopId( @Param("esopId") String esopId);
//    public List<ESOPBreakage> findByEsopId( @Param("esopId")String esopId);

    public void deleteByEsop(@Param("esop") ESOP esop);
    public List<ESOPBreakage> findByEsop( @Param("esop")ESOP esop);
}
