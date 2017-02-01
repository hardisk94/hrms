package com.coviam.internalapp.hrms.work;

import com.coviam.internalapp.hrms.variablepayhistory.dto.VariablePayGetDTO;
import com.coviam.internalapp.hrms.variablepayhistory.entity.VariablePay;
import com.coviam.internalapp.hrms.work.dto.VisaDetailDto;
import com.coviam.internalapp.hrms.work.entity.VisaDetail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JahnaviSuthar on 31/01/17.
 */
@Service
public class VisaAdapter {

    @Autowired
    private ModelMapper modelMapper;

    public VisaDetailDto convertToDto(VisaDetail visaDetail){
        return modelMapper.map(visaDetail,VisaDetailDto.class);

    }
}
