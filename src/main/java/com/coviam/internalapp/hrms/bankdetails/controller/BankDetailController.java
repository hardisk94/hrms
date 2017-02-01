package com.coviam.internalapp.hrms.bankdetails.controller;

import com.coviam.internalapp.hrms.bankdetails.BankDetailsAdapter;
import com.coviam.internalapp.hrms.bankdetails.dto.BankDetailsDto;
import com.coviam.internalapp.hrms.bankdetails.entity.BankDetail;
import com.coviam.internalapp.hrms.bankdetails.service.BankDetailService;
import com.coviam.internalapp.hrms.educationaldetails.EduDetailAdapter;
import com.coviam.internalapp.hrms.educationaldetails.dto.EduDetailsDto;
import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;
import com.coviam.internalapp.hrms.leavemgmt.view.entity.LeaveHistoryDto;
import com.coviam.internalapp.hrms.salary.dto.SalaryDTO;
import com.coviam.internalapp.hrms.salary.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ashwini on 25/01/17.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/bankDetails")
public class BankDetailController {
    @Autowired
    BankDetailService bankDetailService;

    @Autowired
    BankDetailsAdapter bankDetailsAdapter;

   /* @RequestMapping(value = "/add/{bankDetail}/", method = RequestMethod.PUT)
    public ResponseEntity createBankDetail(
        @PathVariable("bankDetail") BankDetail bankDetail) throws Exception {

        bankDetail = bankDetailService.addBankDetail(bankDetail);
        return new ResponseEntity(bankDetail, HttpStatus.OK);
    }*/
/*    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getCompanies(@RequestParam(value="bankdetail") BankDetail bankDetail) {
       BankDetail addbnkdetail= bankDetailService.addBankDetail(bankDetail);
        return new ResponseEntity(addbnkdetail, HttpStatus.OK);
    }
*/


    @RequestMapping(value="/create", method= RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity createBankDetail(BankDetailsDto bankDetailsDto) throws Exception{
        BankDetail addbnkdetail = bankDetailsAdapter.convertToEntity(bankDetailsDto);
        return new ResponseEntity( bankDetailService.addBankDetail(addbnkdetail), HttpStatus.OK);

    }



    @RequestMapping(value = "/delete/{customerId}/{bankDetailId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBankDetails(@PathVariable("customerId") String customerId,
                                            @PathVariable("bankDetailId") String bankDetailId) throws Exception
    {

        BankDetail bankDetail=bankDetailService.deleteBankDetail(customerId, bankDetailId);
        return new ResponseEntity(bankDetailsAdapter.convertToDto(bankDetail),HttpStatus.OK);

    }


    @RequestMapping(value="/update", method= RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity updateBankDetail(BankDetailsDto bankDetailsDto) throws Exception{
        BankDetail updatebnkdetail = bankDetailsAdapter.convertToEntity(bankDetailsDto);
        return new ResponseEntity( bankDetailService.updateBankDetail(updatebnkdetail), HttpStatus.OK);

    }




    @RequestMapping(value = "/show/{customerId}/{employeeId}",method = RequestMethod.GET)
    public List<BankDetailsDto> showBankDetail(@PathVariable("customerId") String customerId,
                                               @PathVariable("employeeId") String employeeId)
    {
        List<BankDetail> bankDetail = bankDetailService.showBankDetail(customerId,employeeId);

        return bankDetail.stream().map(BankDetail -> bankDetailsAdapter.convertToDto(BankDetail)).collect(Collectors.toList());

    }

}