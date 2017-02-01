package com.coviam.internalapp.hrms.bankdetails;

import com.coviam.internalapp.hrms.bankdetails.dto.BankDetailsDto;
import com.coviam.internalapp.hrms.bankdetails.entity.BankDetail;
import com.coviam.internalapp.hrms.educationaldetails.dto.EduDetailsDto;
import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by karan on 30/01/17.
 */

@Service
public class BankDetailsAdapter{

    @Autowired
    private ModelMapper modelMapper;

    public BankDetailsDto convertToDto(BankDetail bankDetail){
        BankDetailsDto bankDetailsDto = modelMapper.map(bankDetail, BankDetailsDto.class);
        return bankDetailsDto;
    }
    public BankDetail convertToEntity(BankDetailsDto bankDetailsDto){
        BankDetail bankDetail = modelMapper.map(bankDetailsDto, BankDetail.class);
        return bankDetail;
    }


}
