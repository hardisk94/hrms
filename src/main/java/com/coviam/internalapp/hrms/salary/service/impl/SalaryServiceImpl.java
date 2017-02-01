package com.coviam.internalapp.hrms.salary.service.impl;

import com.coviam.internalapp.hrms.salary.dao.SalaryDao;
import com.coviam.internalapp.hrms.salary.dto.SalaryDTO;
import com.coviam.internalapp.hrms.salary.entity.Salary;
import com.coviam.internalapp.hrms.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by JahnaviSuthar on 24/01/17.
 */
@Component
public class SalaryServiceImpl implements SalaryService{

    @Autowired
    SalaryDao salaryDao;


    /*Only latest salary can be added into the database by this method.
     The change in salary is calculated using previous 'current' 'active' salary, is zero if no such record is found*/
    @Transactional
    @Override
    public boolean addSalary(String customerId, String employeeId, Date dateOfChange, long fixedSalary,
                             long variableSalary, String notes) {


        double percentageChange = 0;
        long absoluteChange = 0;
        Date date_prev = null;

         List<Salary> salaryList = salaryDao.findByCustomerIdAndEmployeeIdAndIsActiveAndIsCurrent(customerId,
                employeeId,true,true);

        if(salaryList.size() == 1) {
            Salary s_prev = salaryList.get(0);
            date_prev = s_prev.getDateOfChange();
            absoluteChange = fixedSalary - s_prev.getFixedSalary();
            percentageChange = (absoluteChange * 100)/s_prev.getFixedSalary();

            if(date_prev.compareTo(dateOfChange) >= 0) {
                return false;
            }
            s_prev.setCurrent(false);
            salaryDao.save(s_prev);
        }


        Salary s = salaryDao.findByCustomerIdAndEmployeeIdAndDateOfChangeAndIsActive(customerId,
                employeeId,dateOfChange,true);

        if(s == null) {

            s = salaryDao.findByCustomerIdAndEmployeeIdAndDateOfChangeAndIsActive(customerId,
                    employeeId,dateOfChange,false);

            if(s != null){
                s.setFixedSalary(fixedSalary);
                s.setVariableSalary(variableSalary);
                s.setNotes(notes);
                s.setPercentageChange(percentageChange);
                s.setAbsoluteChange(absoluteChange);
                s.setActive(true);
                s.setCurrent(true);
                salaryDao.save(s);
            }
            else {
                salaryDao.save(new Salary(customerId, employeeId, fixedSalary,
                        variableSalary, dateOfChange, percentageChange, absoluteChange, notes));
            }
            return true;
        }
        return false;
    }


    @Transactional
    @Override
    public boolean addSalary(SalaryDTO salaryDTO){

        String customerId = salaryDTO.getCustomerId();
        String employeeId = salaryDTO.getEmployeeId();
        String dateOfChange = salaryDTO.getDateOfChange();
        String fixedSalary = salaryDTO.getFixedSalary();
        String variableSalary = salaryDTO.getVariableSalary();
        String notes = salaryDTO.getNotes();

        if(customerId != null && employeeId != null && dateOfChange != null){
            Date date = Date.valueOf(dateOfChange);
            long fixsal = Long.parseLong(fixedSalary);
            long varsal = Long.parseLong(variableSalary);

            double percentageChange = 0;
            long absoluteChange = 0;
            Date date_prev = null;

            List<Salary> salaryList = salaryDao.findByCustomerIdAndEmployeeIdAndIsActiveAndIsCurrent(customerId,
                    employeeId,true,true);

            if(salaryList.size() == 1) {
                Salary s_prev = salaryList.get(0);
                date_prev = s_prev.getDateOfChange();
                absoluteChange = fixsal - s_prev.getFixedSalary();
                percentageChange = (absoluteChange * 100)/s_prev.getFixedSalary();

                if(date_prev.compareTo(date) >= 0) {
                    return false;
                }
                s_prev.setCurrent(false);
                salaryDao.save(s_prev);
            }


            Salary s = salaryDao.findByCustomerIdAndEmployeeIdAndDateOfChangeAndIsActive(customerId,
                    employeeId,date,true);

            if(s == null) {

                s = salaryDao.findByCustomerIdAndEmployeeIdAndDateOfChangeAndIsActive(customerId,
                        employeeId,date,false);

                if(s != null){
                    s.setFixedSalary(fixsal);
                    s.setVariableSalary(varsal);
                    s.setNotes(notes);
                    s.setPercentageChange(percentageChange);
                    s.setAbsoluteChange(absoluteChange);
                    s.setActive(true);
                    s.setCurrent(true);
                    salaryDao.save(s);
                }
                else {
                    salaryDao.save(new Salary(customerId, employeeId, fixsal,
                            varsal, date, percentageChange, absoluteChange, notes));
                }
                return true;
            }

        }

        return false;
    }


    /*Does not allow to delete the current salary record*/
    @Transactional
    @Override
    public boolean deleteSalary(String customerId, String employeeId, Date dateOfChange) {

        if(customerId != null && employeeId != null && dateOfChange != null) {
            Salary s = salaryDao.findByCustomerIdAndEmployeeIdAndDateOfChangeAndIsActive(customerId,
                    employeeId, dateOfChange, true);

            if (s != null && !s.isCurrent()) {
                s.setActive(false);
                return true;
            }
        }
        return false;

    }

    @Transactional
    @Override
    public boolean deleteSalary(String customerId, String employeeId) {

        if(customerId != null && employeeId != null) {

            List<Salary> salaryList = salaryDao.findByCustomerIdAndEmployeeIdAndIsActive(customerId,
                    employeeId, true);

            if (salaryList.size() > 0) {

                for(Salary s: salaryList){
                    s.setActive(false);
                    salaryDao.save(s);
                }
                return true;
            }
        }
        return false;

    }

    @Transactional
    @Override
    public Salary getSalary(String customerId, String employeeId, Date dateOfChange) {
        return salaryDao.findByCustomerIdAndEmployeeIdAndDateOfChangeAndIsActive(customerId, employeeId, dateOfChange,true);
    }

    @Transactional
    @Override
    public List<Salary> getSalary(String customerId, String employeeId) {
        return salaryDao.findByCustomerIdAndEmployeeIdAndIsActive(customerId, employeeId,true);
    }

    @Transactional
    @Override
    public Salary getCurrentSalary(String customerId, String employeeId) {
        List<Salary> salaryList = salaryDao.findByCustomerIdAndEmployeeIdAndIsActiveAndIsCurrent(customerId,
                employeeId,true,true);
        if(salaryList.size() == 1)
            return salaryList.get(0);
        return null;
    }

    @Transactional
    @Override
    public List<Salary> getPreviousSalaries(String customerId, String employeeId) {
        return salaryDao.findByCustomerIdAndEmployeeIdAndIsActiveAndIsCurrent(customerId,
                employeeId,true,false);
    }

    @Transactional
    @Override
    public Salary getPreviousSalary(String customerId, String employeeId) {
        List<Salary> salaryList = this.getPreviousSalaries(customerId, employeeId);
        return Collections.max(salaryList, Comparator.comparing(c->c.getDateOfChange()));
    }

    /*Allows to update only current record*/
    @Transactional
    @Override
    public boolean updateSalary(String customerId, String employeeId, Date dateOfChange,
                                long fixedSalary, long variableSalary, String notes) {

        Salary s = salaryDao.findByCustomerIdAndEmployeeIdAndDateOfChangeAndIsActive(customerId,
                employeeId,dateOfChange,true);

        if(s != null && s.isCurrent()){


            double prev_salary = (s.getAbsoluteChange() * 100)/(s.getPercentageChange());

            double absoluteChange = fixedSalary - prev_salary;
            double percentageChange = (absoluteChange*100.0)/prev_salary;


            s.setFixedSalary(fixedSalary);
            s.setVariableSalary(variableSalary);
            s.setAbsoluteChange((long)Math.ceil(absoluteChange));
            s.setPercentageChange(percentageChange);
            s.setNotes(notes);
            return true;
        }
        return false;
    }

    /*Allows to update only current record*/
    @Transactional
    @Override
    public boolean updateSalary(SalaryDTO salaryDTO){

        String customerId = salaryDTO.getCustomerId();
        String employeeId = salaryDTO.getEmployeeId();
        String dateOfChange = salaryDTO.getDateOfChange();
        String fixedSalary = salaryDTO.getFixedSalary();
        String variableSalary = salaryDTO.getVariableSalary();
        String notes = salaryDTO.getNotes();

        if(customerId != null && employeeId != null && dateOfChange != null) {

            Date date = Date.valueOf(dateOfChange);
            long fixsal = Long.parseLong(fixedSalary);
            long varsal = Long.parseLong(variableSalary);

            Salary s = salaryDao.findByCustomerIdAndEmployeeIdAndDateOfChangeAndIsActive(customerId,
                    employeeId, date, true);

            if (s != null && s.isCurrent()) {

                double prev_salary = (s.getAbsoluteChange() * 100) / (s.getPercentageChange());

                double absoluteChange = fixsal - prev_salary;
                double percentageChange = (absoluteChange * 100.0) / prev_salary;

                s.setFixedSalary(fixsal);
                s.setVariableSalary(varsal);
                s.setAbsoluteChange((long) Math.ceil(absoluteChange));
                s.setPercentageChange(percentageChange);
                s.setNotes(notes);
                return true;
            }
        }
        return false;
    }
}

