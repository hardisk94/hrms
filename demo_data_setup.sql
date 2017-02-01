-- Test data from employee type
Insert into EMPLOYEE_TYPE( EMPLOYEE_TYPE_ID,EMPLOYEE_TYPE,DESCRIPTION,CUSTOMER_ID)
values('1','Contract','Hired for a specific job at a specific rate of pay','1');
insert into  EMPLOYEE_TYPE(EMPLOYEE_TYPE_ID,EMPLOYEE_TYPE,DESCRIPTION,CUSTOMER_ID)
values('2','Intern','Trainee who works in order to gain work  experience on live projects','1');
insert into EMPLOYEE_TYPE(EMPLOYEE_TYPE_ID,EMPLOYEE_TYPE,DESCRIPTION,CUSTOMER_ID)
values('3','Full-Time','Employment for a job role or business execution. This resource is provided with all corporate benifits based on the role.', '1');
insert into  EMPLOYEE_TYPE(EMPLOYEE_TYPE_ID,EMPLOYEE_TYPE,DESCRIPTION,CUSTOMER_ID)
values('4','Probation','Employment is on assement for the job role and / or business function execution','1');
insert into EMPLOYEE_TYPE(EMPLOYEE_TYPE_ID,EMPLOYEE_TYPE,DESCRIPTION,CUSTOMER_ID)
values('5','Part-Time','Employment for a job role or business execution. Works for less number of hours than required by labour laws. This resource is provided with all corporate benifits based on the role, but these benifits are prorated.', '1');

--Test data for employee status 
insert into EMPLOYEE_STATUS(ID,TYPE_NAME,TYPE_DESCRIPTION,CUSTOMER_ID)
values( '1','Active', ' Presently Working' ,'1');
insert into EMPLOYEE_STATUS(ID,TYPE_NAME,TYPE_DESCRIPTION,CUSTOMER_ID)
values( '2','Sabattical', 'A period of paid leave granted ','1' );
insert into EMPLOYEE_STATUS(ID,TYPE_NAME,TYPE_DESCRIPTION,CUSTOMER_ID)
values( '3','Resigned', 'To give up (a job or position) in a formal or official way','1' );
insert into EMPLOYEE_STATUS(ID,TYPE_NAME,TYPE_DESCRIPTION,CUSTOMER_ID)
values( '4','Exited', 'Left the Job','1'  );
insert into EMPLOYEE_STATUS(ID,TYPE_NAME,TYPE_DESCRIPTION,CUSTOMER_ID)
values( '5','Termination', 'Terminated on performance basis' ,'1' );
insert into EMPLOYEE_STATUS(ID,TYPE_NAME,TYPE_DESCRIPTION,CUSTOMER_ID)
values( '6','Personal Improvement Program', 'Under performing resource','1' );

-- Project type setup data
insert into PROJECT_TYPE(ID,PROJECT_TYPE_NAME,CUSTOMER_ID)
values('1','Partnership','1');
insert into PROJECT_TYPE(ID,PROJECT_TYPE_NAME,CUSTOMER_ID)
values('2','Product','1');
insert into PROJECT_TYPE(ID,PROJECT_TYPE_NAME,CUSTOMER_ID)
values('3','Practice','1');
insert into PROJECT_TYPE(ID,PROJECT_TYPE_NAME,CUSTOMER_ID)
values('4','Consulting','1');

-- test data for location 
insert into LOCATION(LOCATION_ID, CUSTOMER_ID, SHORT_NAME,ADDRESS,PHONE,FRONT_DESK_NUMBER,LAT_LONG,IS_ACTIVE)
values('1','1','Block-A','1076, 24th Main, 11th Cross, HSR Layout, Bangalore - 560-102, INDIA' ,'India: +91-998-000-3816 ','US: (732) 205 9191 ','', True);
insert into LOCATION(LOCATION_ID, CUSTOMER_ID, SHORT_NAME,ADDRESS,PHONE,FRONT_DESK_NUMBER,LAT_LONG,IS_ACTIVE)
values('2','1','Block-B','1068, 24th Main, HSR Layout, Bangalore - 560-102, INDIA' ,'India: +91-998-000-3816','US: (732) 205 9191','', True);
insert into LOCATION(LOCATION_ID, CUSTOMER_ID, SHORT_NAME,ADDRESS,PHONE,FRONT_DESK_NUMBER,LAT_LONG,IS_ACTIVE)
values('3','1','Block-C','1212, 24th Main, 11th Cross, HSR Layout, Bangalore - 560-102, INDIA' ,'India: +91-998-000-3816','US: (732) 205 9191 ','', True);

-- Leave type data 
insert into LEAVE_TYPE(CUSTOMER_ID,LEAVE_TYPE_ID,LEAVE_TYPE,MAX_LEAVE,DEFAULT_LEAVE,CARRY_FORWARD)
values('1','1','Casual Leave','10','10','0');
insert into LEAVE_TYPE(CUSTOMER_ID,LEAVE_TYPE_ID,LEAVE_TYPE,MAX_LEAVE,DEFAULT_LEAVE,CARRY_FORWARD)
values('1','2','Earned Leave','12','0','0');
insert into LEAVE_TYPE(CUSTOMER_ID,LEAVE_TYPE_ID,LEAVE_TYPE,MAX_LEAVE,DEFAULT_LEAVE,CARRY_FORWARD)
values('1','3','Maternity Leave','90','90','0');
insert into LEAVE_TYPE(CUSTOMER_ID,LEAVE_TYPE_ID,LEAVE_TYPE,MAX_LEAVE,DEFAULT_LEAVE,CARRY_FORWARD)
values('1','4','Paternal Leave','14','14','0');
insert into LEAVE_TYPE(CUSTOMER_ID,LEAVE_TYPE_ID,LEAVE_TYPE,MAX_LEAVE,DEFAULT_LEAVE,CARRY_FORWARD)
values('1','5','Medical Leave','10','10','0');


--designation 
INSERT INTO designation(designation_id, customer_id, code, name, is_active ) 
VALUES (1, 1, '001', 'Software Engineer',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active ) 
VALUES (2, 1, '002', 'Software Engineer',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active ) 
VALUES (3, 1, '003', 'Senior Software Engineer',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active ) 
VALUES (4, 1, '004', 'Team Lead',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active ) 
VALUES (5, 1, '005', 'Project Manager',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active ) 
VALUES (6, 1, '006', 'Senior Project Manager',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active ) 
VALUES (7, 1, '007', 'Director',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active ) 
VALUES (8, 1, '008', 'Senior Director',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active )
VALUES (9, 1, '009', 'Vice President',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active )
VALUES (10, 1, '010', 'Senior Vice President',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active ) 
VALUES (11, 1, '011', 'CTO',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active ) 
VALUES (12, 1, '012', 'CEO',True );
INSERT INTO designation(designation_id, customer_id, code, name, is_active ) 
VALUES (13, 1, '013', 'COO',True );

--department 
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (1, 1, 'Coviam', 'Coviam', null);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (2, 1, 'BliBli', 'BliBli', 1);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (3, 1, 'Novire', 'Novire', 1);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (4, 1, 'HouseJoy', 'HouseJoy', 1);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (5, 1, 'Development', 'Development', 2);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (6, 1, 'QA', 'QA', 2);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (7, 1, 'Core Commerce', 'Core Commerce', 5);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (8, 1, 'SCM', 'SCM', 5);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (9, 1, 'Analytics', 'Analytics', 5);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (10, 1, 'MTA', 'MTA', 5);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (11, 1, 'Core Commerce', 'Core Commerce', 6);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (12, 1, 'SCM', 'SCM', 6);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (13, 1, 'Analytics', 'Analytics', 6);
INSERT INTO department(department_id, customer_id,  name, description, parent_department_id)
VALUES (14, 1, 'MTA', 'MTA', 6);

-- Grade type
INSERT INTO grade_type(gradetype_id, gradetype_scale, gradetype_type)
VALUES (1, 100, 'Percentage');
INSERT INTO grade_type(gradetype_id, gradetype_scale, gradetype_type)
VALUES (2, 10, 'CGPA');
INSERT INTO grade_type(gradetype_id, gradetype_scale, gradetype_type)
VALUES (3, 5, 'CGPA 5 Scale');


-- employee details

INSERT INTO employee_detail(employee_id, blood_group, customer_id, date_of_joining, department_id, email_id,
	employee_number, name, employee_type_id, is_lead, location_id, phone_number, emergency_address, emergency_contact,
	emergency_name, emergency_relation, permanent_address, designation_id, facebook_id, twitter_id, skype_id)
VALUES (1, 'O +ve', 1, '01-06-2015', 1, 'emp1@coviam.com',
	'E10001', 'Employee One', 3, True, 1, '+91 99800 03816', 'House Number 1, Vijay Nagar, Banglore', '+91 94875 85764', 'Sister of Employee', 'Sister', '#1076, 24th main, Coviam Technology and Service Pvt. Ltd., HSR Layout, Banglore', 12, 'emp.one@coviam.com', 'emp.one', 'emp.one');
INSERT INTO employee_detail(employee_id, blood_group, customer_id, date_of_joining, department_id, email_id,
	employee_number, name, employee_type_id, is_lead, location_id, phone_number, emergency_address, emergency_contact,
	emergency_name, emergency_relation, permanent_address, designation_id, facebook_id, twitter_id, skype_id)
VALUES (2, 'O +ve', 1, '01-06-2015', 1, 'emp2@coviam.com',
	'E10002', 'Emplyee Two', 3, True, 1, '+91 99800 03816', 'House Number 2, Lalji Nagar, Banglore', '+91 94875 85764', 'Bother of Employee', 'Brother', '#1076, 24th main, Coviam Technology and Service Pvt. Ltd., HSR Layout, Banglore', 12, 'emp.two@coviam.com', 'emp.two', 'emp.two');
INSERT INTO employee_detail(employee_id, blood_group, customer_id, date_of_joining, department_id, email_id,
	employee_number, name, employee_type_id, is_lead, location_id, phone_number, emergency_address, emergency_contact,
	emergency_name, emergency_relation, permanent_address, designation_id, facebook_id, twitter_id, skype_id)
VALUES (3, 'O +ve', 1, '01-06-2015', 1, 'emp3@coviam.com',
	'E10003', 'Employee Three', 3, True, 1, '+91 99800 03816', 'House Number 3, Ramji Nagar, Banglore', '+91 94875 85764', 'Wife of Employee', 'Wife', '#1076, 24th main, Coviam Technology and Service Pvt. Ltd., HSR Layout, Banglore', 12, 'emp.three@coviam.com', 'emp.three', 'emp.three');

-- leave balance
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (1, 1, 1, 10, 1);
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (2, 1, 1, 12, 2);
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (3, 1, 1, 14, 4);
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (4, 1, 1, 10, 5);
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (5, 1, 2, 10, 1);
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (6, 1, 2, 12, 2);
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (7, 1, 2, 14, 4);
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (8, 1, 2, 10, 5);
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (9, 1, 3, 10, 1);
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (10, 1, 3, 12, 2);
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (11, 1, 3, 14, 4);
INSERT INTO leave_balance(id, customer_id, employee_id, leave_balance, leave_type)
VALUES (12, 1, 3, 10, 5);

-- bank detail
INSERT INTO bank_detail(bank_detail_id, account_number, account_type, bank_name, branch_name, customer_id, employee_id, ifsccode, is_active)
VALUES('1', '392874635243', 'Salary', 'ICICI', 'HSR Layout', '1', '1', 'ICIC374658', true);
INSERT INTO bank_detail(bank_detail_id, account_number, account_type, bank_name, branch_name, customer_id, employee_id, ifsccode, is_active)
VALUES('2', '392874635534', 'Salary', 'ICICI', 'HSR Layout', '2', '1', 'ICIC374658', true);
INSERT INTO bank_detail(bank_detail_id, account_number, account_type, bank_name, branch_name, customer_id, employee_id, ifsccode, is_active)
VALUES('3', '392874635123', 'Salary', 'ICICI', 'HSR Layout', '3', '1', 'ICIC374658', true);

-- departmentLead
--INSERT INTO department_lead(department_id, lead_id)
--VALUES('1', '1');
--INSERT INTO department_lead(department_id, lead_id)
--VALUES('1', '2');
--INSERT INTO department_lead(department_id, lead_id)
--VALUES('2', '3');

--salary
INSERT INTO salary (salary_id, absolute_change, customer_id, date_of_change, employee_id, fixed_salary, is_active, is_current, notes, percentage_change, variable_salary)
VALUES ('1', 0, '1', '2016-05-01', '1', 75000, true, false, 'None', 0, 25000);
INSERT INTO salary (salary_id, absolute_change, customer_id, date_of_change, employee_id, fixed_salary, is_active, is_current, notes, percentage_change, variable_salary)
VALUES ('2', 10000, '1', '2016-10-01', '1', 85000, true, false, 'None', 13, 23000);
INSERT INTO salary (salary_id, absolute_change, customer_id, date_of_change, employee_id, fixed_salary, is_active, is_current, notes, percentage_change, variable_salary)
VALUES ('3', 10000, '1', '2017-01-01', '1', 95000, true, true, 'None', 11, 23000);
INSERT INTO salary (salary_id, absolute_change, customer_id, date_of_change, employee_id, fixed_salary, is_active, is_current, notes, percentage_change, variable_salary)
VALUES ('4', 0, '1', '2016-05-01', '2', 70000, true, false, 'None', 0, 20000);
INSERT INTO salary (salary_id, absolute_change, customer_id, date_of_change, employee_id, fixed_salary, is_active, is_current, notes, percentage_change, variable_salary)
VALUES ('5', 10000, '1', '2016-10-01', '2', 80000, true, false, 'None', 14, 20000);
INSERT INTO salary (salary_id, absolute_change, customer_id, date_of_change, employee_id, fixed_salary, is_active, is_current, notes, percentage_change, variable_salary)
VALUES ('6', 10000, '1', '2017-01-01', '2', 90000, true, true, 'None', 12, 20000);
INSERT INTO salary (salary_id, absolute_change, customer_id, date_of_change, employee_id, fixed_salary, is_active, is_current, notes, percentage_change, variable_salary)
VALUES ('7', 0, '1', '2016-05-01', '3', 65000, true, false, 'None', 0, 15000);
INSERT INTO salary (salary_id, absolute_change, customer_id, date_of_change, employee_id, fixed_salary, is_active, is_current, notes, percentage_change, variable_salary)
VALUES ('8', 10000, '1', '2016-10-01', '3', 75000, true, false, 'None', 15, 15000);
INSERT INTO salary (salary_id, absolute_change, customer_id, date_of_change, employee_id, fixed_salary, is_active, is_current, notes, percentage_change, variable_salary)
VALUES ('9', 10000, '1', '2017-01-01', '3', 85000, true, true, 'None', 13, 15000);


--variable_pay_history
INSERT INTO variable_pay_history (variable_pay_id, actual_payment_before_tax, customer_id, date_of_payment, employee_id, is_active, percentage_paid, variable_payment)
VALUES ('1', 15000, '1', '2016-07-01', '1', true, 60, 25000);
INSERT INTO variable_pay_history (variable_pay_id, actual_payment_before_tax, customer_id, date_of_payment, employee_id, is_active, percentage_paid, variable_payment)
VALUES ('2', 18400, '1', '2016-12-01', '1', true, 80, 23000);
INSERT INTO variable_pay_history (variable_pay_id, actual_payment_before_tax, customer_id, date_of_payment, employee_id, is_active, percentage_paid, variable_payment)
VALUES ('3', 12000, '1', '2016-12-01', '3', true, 80, 15000);
INSERT INTO variable_pay_history (variable_pay_id, actual_payment_before_tax, customer_id, date_of_payment, employee_id, is_active, percentage_paid, variable_payment)
VALUES ('4', 9000, '1', '2016-07-01', '3', true, 60, 15000);
INSERT INTO variable_pay_history (variable_pay_id, actual_payment_before_tax, customer_id, date_of_payment, employee_id, is_active, percentage_paid, variable_payment)
VALUES ('5', 12000, '1', '2016-07-01', '2', true, 60, 20000);
INSERT INTO variable_pay_history (variable_pay_id, actual_payment_before_tax, customer_id, date_of_payment, employee_id, is_active, percentage_paid, variable_payment)
VALUES ('6', 16000, '1', '2016-12-01', '2', true, 80, 20000);

--leave history
INSERT INTO leave_history(
            leave_history_id, applied_date, approved_by, approved_date, customer_id, 
            days_count, employee_id, from_date, is_cancelled, leave_reason, 
            leave_status, leave_type, status_reason, to_date)
VALUES (1, '01-Jan-2016', 2, '04-Jan-2016', 1, 
            2, 1, '25-Jan-2016', False, 'Taking rest', 
            'Approved', 1, 'Need to take reast', '28-Jan-2016');
INSERT INTO leave_history(
            leave_history_id, applied_date, approved_by, approved_date, customer_id, 
            days_count, employee_id, from_date, is_cancelled, leave_reason, 
            leave_status, leave_type, status_reason, to_date)
VALUES (2, '01-Jan-2016', 2, '04-Jan-2016', 1, 
            4, 1, '25-Jun-2016', False, 'Taking rest', 
            'Approved', 1, 'Need to take reast', '30-Jun-2016');
INSERT INTO leave_history(
            leave_history_id, applied_date, approved_by, approved_date, customer_id, 
            days_count, employee_id, from_date, is_cancelled, leave_reason, 
            leave_status, leave_type, status_reason, to_date)
VALUES (3, '01-Feb-2016', 1, '04-Feb-2016', 1, 
            3, 2, '25-Feb-2016', False, 'Taking rest', 
            'Approved', 2, 'Need to take reast', '28-Feb-2016');
INSERT INTO leave_history(
            leave_history_id, applied_date, approved_by, approved_date, customer_id, 
            days_count, employee_id, from_date, is_cancelled, leave_reason, 
            leave_status, leave_type, status_reason, to_date)
VALUES (4, '01-Jan-2016', 1, '04-Jan-2016', 1, 
            2, 3, '25-Jun-2016', False, 'Taking rest', 
            'Approved', 1, 'Need to take reast', '30-Jun-2016');

-----dependent
insert into dependent(dependent_id,customer_id,date_of_birth,dependent_gender,dependent_relation,employee_id,first_name,is_active,last_name,middle_name)
values('1','1','1957-7-3','male','father','1','Vijkay','true','Khanna','Kumar');
insert into dependent(dependent_id,customer_id,date_of_birth,dependent_gender,dependent_relation,employee_id,first_name,is_active,last_name,middle_name)
values('2','1','1967-4-5','female','mother','1','Santoshi','true','Khanna','Kumari');
insert into dependent(dependent_id,customer_id,date_of_birth,dependent_gender,dependent_relation,employee_id,first_name,is_active,last_name,middle_name)
values('3','1','1955-6-7','male','father','2','Vikas','true','Kashyap','');
insert into dependent(dependent_id,customer_id,date_of_birth,dependent_gender,dependent_relation,employee_id,first_name,is_active,last_name,middle_name)
values('4','1','1965-5-8','female','mother','2','Radhika','true','Kashyap','');
insert into dependent(dependent_id,customer_id,date_of_birth,dependent_gender,dependent_relation,employee_id,first_name,is_active,last_name,middle_name)
values('5','1','1963-9-7','male','father','3','Sanjay','true','Dubey','');
insert into dependent(dependent_id,customer_id,date_of_birth,dependent_gender,dependent_relation,employee_id,first_name,is_active,last_name,middle_name)
values('6','1','1968-6-4','female','mother','3','Rekha','true','Dubey','');

------educational_detail
insert into education_detail(edu_detail_id,customer_id,date_of_joining,degree,employee_id,grade,gradetype_id,pass_out_date)
values('1','1','2016-7-6','Btech','1','90','1','2015-5-5');
insert into education_detail(edu_detail_id,customer_id,date_of_joining,degree,employee_id,grade,gradetype_id,pass_out_date)
values('2','1','2016-7-6','Btech','2','9','2','2015-5-5');
insert into education_detail(edu_detail_id,customer_id,date_of_joining,degree,employee_id,grade,gradetype_id,pass_out_date)
values('3','1','2016-7-6','Btech','3','4','3','2015-5-5');
insert into education_detail(edu_detail_id,customer_id,date_of_joining,degree,employee_id,grade,gradetype_id,pass_out_date)
values('4','1','2016-7-6','Mtech','3','80','1','2015-5-5');

------esop
insert into esop(esop_id,active,break_up_count,customer_id,date_offered,employee_id,offered_stocks,price_of_stock)
values('1','1','4','1','2016-9-12','1','2','770000');
insert into esop(esop_id,active,break_up_count,customer_id,date_offered,employee_id,offered_stocks,price_of_stock)
values('2','1','7','1','2016-9-12','2','1','70000');
insert into esop(esop_id,active,break_up_count,customer_id,date_offered,employee_id,offered_stocks,price_of_stock)
values('3','1','2','1','2016-9-12','3','3','8770000');

------esop_breakage
insert into esop_breakage(breakage_id,active,stocks_to_be_vested,vesting_date,esop_id)
values('1','1','2','2016-5-5','1');
insert into esop_breakage(breakage_id,active,stocks_to_be_vested,vesting_date,esop_id)
values('2','1','1','2016-5-5','2');
insert into esop_breakage(breakage_id,active,stocks_to_be_vested,vesting_date,esop_id)
values('3','1','3','2016-5-5','3');

------lead
--insert into lead(lead_id,department_id,employee_id,end_date,is_active,start_date)
--values('1','9','1','2015-8-30','true','2015-8-3');
--insert into lead(lead_id,department_id,employee_id,end_date,is_active,start_date)
--values('2','6','1','2016-5-3','true','2016-1-3');
--insert into lead(lead_id,department_id,employee_id,end_date,is_active,start_date)
--values('3','2','2','2016-4-30','true','2016-1-3');
--insert into lead(lead_id,department_id,employee_id,end_date,is_active,start_date)
--values('4','1','2','2016-11-23','true','2016-5-2');
--insert into lead(lead_id,department_id,employee_id,end_date,is_active,start_date)
--values('5','8','3','2016-6-30','true','2016-2-3');
--insert into lead(lead_id,department_id,employee_id,end_date,is_active,start_date)
--values('6','10','3','2016-12-31','true','2015-7-20');
--insert into lead(lead_id,department_id,employee_id,end_date,is_active,start_date)
--values('7','5','1','2016-10-30','true','2016-7-6');
--insert into lead(lead_id,department_id,employee_id,end_date,is_active,start_date)
--values('8','3','2','2017-1-30','true','2016-9-19');
--insert into lead(lead_id,department_id,employee_id,end_date,is_active,start_date)
--values('9','7','3','2017-2-3','true','2016-8-3');

-----passport_detail
insert into passport_detail(id,pass_per_name,pass_country_code,cus_id,pass_exp_date,pass_issue_date,pass_dob,is_active,pass_nationality,pass_type,pass_number,pass_issue_place,pass_sex)
values('1','Employee One','IND','1','2017-7-7','2010-2-4','1982-5-17','true','Indian','P','23455','Mumbai','male');
insert into passport_detail(id,pass_per_name,pass_country_code,cus_id,pass_exp_date,pass_issue_date,pass_dob,is_active,pass_nationality,pass_type,pass_number,pass_issue_place,pass_sex)
values('2','Employee Two','IND','1','2017-7-7','2010-2-4','1973-4-20','true','Indian','P','2398455','Kolkatta','male');
insert into passport_detail(id,pass_per_name,pass_country_code,cus_id,pass_exp_date,pass_issue_date,pass_dob,is_active,pass_nationality,pass_type,pass_number,pass_issue_place,pass_sex)
values('3','Employee Three','IND','1','2017-7-7','2010-2-4','1966-5-17','true','Indian','P','983455','Delhi','male');

--------project
insert into project (id,customer_id,end_date,is_active,project_name,project_description,project_owner_id,start_date,project_type_id)
values('1','1','2017-05-21','true','SSL','Secure Socket Layer','1','2017-02-02','1');
insert into project (id,customer_id,end_date,is_active,project_name,project_description,project_owner_id,start_date,project_type_id)
values('2','2','2017-05-21','true','peoplehum','Employee engagment platform','1','2017-02-02','1');
insert into project (id,customer_id,end_date,is_active,project_name,project_description,project_owner_id,start_date,project_type_id)
values('3','3','2017-05-21','true','Nowire','IOT ptatform','1','2017-02-02','1');

-- project details 
INSERT INTO employee_detail_projects(employee_employee_id, projects_id) VALUES (1, 1);
INSERT INTO employee_detail_projects(employee_employee_id, projects_id) VALUES (1, 2);
INSERT INTO employee_detail_projects(employee_employee_id, projects_id) VALUES (1, 3);

----skills
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('1','1','programming purpose','1','7','Java','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('2','1','programming purpose','1','8','Python','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('3','1','Web development','2','9','HTML','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('4','1','Web development','2','7','CSS','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('5','1','Web development','2','6','JavaScript','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('6','1','Web development','2','9','Jquery','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('7','1','Full stack developer','3','5','Python','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('8','1','Full stack developer','3','5','Java','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('9','1','Full stack developer','3','5','HTML','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('10','1','Full stack developer','3','5','CSS','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('11','1','Full stack developer','3','5','JQUERY','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('12','1','Full stack developer','3','5','AJAX','Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('13','1','Marketing','1','7','Marketing','Non-Technical');
insert into skills (skill_id,customer_id,description,employee_id,skill_proficiency,skill_name,skill_type)
values('14','1','Sales','1','7','Sales','Non-Technical');

-----work
insert into work (id,customer_id, designation,employee_id,end_date,office_location_id,org_name,start_date,employee_status_id)
values('1','1','Software Engineer','1','2017-1-30','2','Google','2015-3-20','1');
insert into work (id,customer_id, designation,employee_id,end_date,office_location_id,org_name,start_date,employee_status_id)
values('2','1','Product manager','2','2017-1-30','1','Facebook','2015-3-20','1');
insert into work (id,customer_id, designation,employee_id,end_date,office_location_id,org_name,start_date,employee_status_id)
values('3','1','Team Lead','3','2017-1-30','3','Microsoft','2015-3-20','1');

------visa
insert into visa (id,country_name,customer_id,expiry_date,issue_date,passport_id,valid_from)
values('1','US','1','2017-7-7','2010-2-4','1','2010-2-20');
insert into visa (id,country_name,customer_id,expiry_date,issue_date,passport_id,valid_from)
values('2','China','1','2017-7-7','2010-2-4','2','2010-2-20');
insert into visa (id,country_name,customer_id,expiry_date,issue_date,passport_id,valid_from)
values('3','Japan','1','2017-7-7','2010-2-4','3','2010-2-20');

------document_internship letter
insert into document_gen values ('1','1','<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Internship Letter</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
var d = new Date();
var datestring = monthNames[d.getMonth()] + " " + d.getDate()  + "," +  " " + d.getFullYear();
</script>

<style>
table {
   border-collapse: collapse;
}

td, th {
   border: 1px solid #dddddd ;
   text-align: left;
   padding: 8px;
}
</style>

</head>
<body>


<p align="right" style="margin-top:0px; display: inline;"> <img src="http://i.imgur.com/i59UZ6I.png" alt="coviam logo" style="width:150px;height:70px;"> </img> &emsp; &emsp; &emsp; <font color="red"> CIN: U72200KA2015PTC079686 </font> </p>

<!-- &emsp;  &emsp;  &emsp;  &emsp; -->
<p id="date"> <script>
document.getElementById("date").innerHTML = "Date: " + datestring;
</script> <br> </br> </p>
Name: name <br> </br>
Qualification: degree_name <br> </br>
Email Address: email_id <br> </br>
Phone #: phone_number <br> </br> <br> </br>
Dear name, <br> </br>
<p> Coviam Technology and Services Pvt Ltd (“Coviam” or “Company”) is pleased to offer you a position for for project
training as Intern from start_date to end_date. During your Internship assignment, you will be working on the
    assignment at our address and paid a stipend of <b> INR 21,000/- per month </b>. You will report to
        report_person_fullname, report_person_designation, Coviam during your assignment at the company.
        At the end of the internship, you will submit a copy of your report to the Company. You may contact contact_person_fullname
        at contact_person_phone for further guidance on your assignment. </p>

<p > On completion of the probation period, successful candidates, based on performance and company acceptance criteria,
    will be offered full time employment at the end of the internship period at the sole discretion of the Company. </p>

<p> On successful completion and acceptance criteria, your Annual CTC will be <b> INR 6,25,000/- </b> per annum and your
    designation will be Software Engineer. In addition, you will also be eligible to participate in a stock options plan
    as per the <b> Coviam ESOP plan </b>. The detailed compensation break up will be as under; </p>

<table>
    <col width="70"></col>
    <col width="300"></col>
    <col width="280"></col>
    <tr>
        <th>SL.No</th>
        <th>Salary Component</th>
        <th>Compensation (INR) Per Annum</th>
    </tr>
    <tr>
        <td><b>1</b>                </td>
        <td>Basic Salary</td>
        <td>INR 275,000</td>
    </tr>
    <tr>
        <td><b>2</b></td>
        <td>House Rent Allowance</td>
        <td>INR 110,000</td>
    </tr>
    <tr>
        <td><b>3</b></td>
        <td>Conveyance Allowance</td>
        <td>INR 19,200</td>
    </tr>
    <tr>
        <td><b>4</b></td>
        <td>Medical Reimbursement</td>
        <td>INR 15,000</td>
    </tr>
    <tr>
        <td><b>5</b></td>
        <td>Leave Travel Assistance</td>
        <td>INR 41,250</td>
    </tr>
    <tr>
        <td><b>6</b></td>
        <td>Special Allowance + PF Employer Cont.         </td>
        <td>INR 89,550</td>
    </tr>
    <tr>
        <td></td>
        <td>Total Fixed Base</td>
        <td>INR 550,000</td>
    </tr>
    <tr>
        <td><b>7</b></td>
        <td>Performance Bonus</td>
        <td>INR 75,000</td>
    </tr>
    <tr>
        <td></td>
        <td><b>Total CTC</b></td>
        <td><b>INR 6,25,000</b></td>
    </tr>
</table>

<p> Coviam is a very highly rated and sought after employer offers a superior benefits package including medical insurance
    for upto 6 family members (for permanent employees), free food, unlimited holidays based on management approval and host
    of others and represents a best in class environment for innovation and learning.</p>

<p> Information pertaining to Coviam operations and intellectual property is confidential and upon reporting, you will be
    required to sign a non disclosure agreement. You are also expected to adhere to all applicable rules and regulation and
    business conduct guidelines of Coviam and act in accordance with the values and principles of the Company.</p>

<p> To confirm your acceptance of this internship assignment, you are required to: </p>
<ul>
    <li> Respond via email to <a href="mailto:contact_person_email"> contact_person_email </a>, to communicate acceptance of the internship assignment and to confirm
        your joining date. </li>
    <li>Any change of joining date must be sent to <a href="mailto:contact_person_email"> contact_person_email </a> at least 7 days prior to your
        original joining date. The new joining date must be no later than 5 days from the date of joining
        listed above.</li>
    <li>Report for onboarding at reporting_time to: <br> </br>
        address </li>
</ul>

<p> On your reporting date, please bring the following mandatory documents: </p>
<ol>
    <li>Copy of this letter duly signed and dated by you.</li>
    <li>2 photographs (passport sized, color photos with a white background).</li>
    <li>Education degree certificate and all year mark sheets for latest graduation or post graduation.
        Photocopies should include both front and back sides of the certificate.</li>
    <li> Proof of identity. Bring 2 sets of photocopies of any one of the following documents: <b> passport
        (mandatory) </b>, driving license, and voter’s identification card or PAN card.</li>
    <li> PAN card : If you do not have a PAN card, please apply for one immediately and carry the
        acknowledgement on the day of joining </li>
    <li> Bank Account details : For stipend payments (1 original photo ID proof and 1 permanent address
        proof) </li>
</ol>

<p> Coviam is a dynamic, open environment where opportunities for learning exist in eCommerce, analytics, payment
    technologies, mobile, DevOps, Automation, product management, strategy, development and various other advanced and in
    demand domains. We are delighted to have you as part of the team and participate in a fast paced, vibrant and new age
    learning environment working with leaders in various specializations with global experience.</p> <br> </br>

<p> Sincerely, </p> <br> </br> <br> </br>
<p> Signed By, </p>
<p> sign_authority_fullname <br> </br> sign_authority_designation -  Coviam Technology and Services Pvt. Ltd. </p> <br> </br>

<footer>
    <hr color="red"> </hr>
    <center> <p> <font color="red"> 1076, 24th Main, 11th Cross, HSR layout, Bangalore, India 560102 <br> </br>
    Ph : +91-962.013.3230 – <a href="http://www.coviam.com" style="color:red"> www.coviam.com </a> </font> </p> </center>
</footer>

</body>
</html>', 'U72200KA2015PTC079686', 'Coviam Tech and Services Pvt. Ltd.', 'http://i.imgur.com/i59UZ6I.png','Internship Offer Letter')


---------reporting_contact details
insert into reporting_contact_detail values ('1','Phani Kumar Patchava','VP-Engineering','phani.kumar@coviam.com','9945237596','Swapna Samal','Senior HR Manager','swapna@coviam.com','9620133230','Deepak Nachnani','Chief Executive Officer','deepak@coviam.com','9980003816', '9:00 AM')
