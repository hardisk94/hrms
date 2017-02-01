package com.coviam.internalapp.hrms.variablepayhistory;

import com.coviam.internalapp.hrms.variablepayhistory.dto.VariablePayGetDTO;
import com.coviam.internalapp.hrms.variablepayhistory.entity.VariablePay;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JahnaviSuthar on 30/01/17.
 */
@Service
public class VariablePayAdapter {

    @Autowired
    private ModelMapper modelMapper;

    public VariablePayGetDTO convertToDto(VariablePay variablePay){
        VariablePayGetDTO variablePayResponse = modelMapper.map(variablePay,VariablePayGetDTO.class);
        return variablePayResponse;
    }

}
