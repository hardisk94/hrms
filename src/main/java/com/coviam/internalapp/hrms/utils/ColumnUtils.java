package com.coviam.internalapp.hrms.utils;
/**
 * Created by sarang on 23/01/17.
 */
public interface ColumnUtils {
    //educationdetails table

    public static final String EDUCATION_DETAILS_ID = "edu_detail_id";
    public static final String EDUCATION_DETAILS_EDUCATIONTYPE = "educationType";
    public static final String EDUCATION_DETAILS_INSTITUTE = "eduDetail_institute";
    public static final String EDUCATION_DETAILS_DEGREE = "degree";
    public static final String EDUCATION_DETAILS_ISACTIVE = "eduDetail_isActive";
    public static final String EDUCATION_DETAILS_DATEOFJOINING = "date_of_joining";
    public static final String EDUCATION_DETAILS_PASSOUTDATE = "pass_out_date";
    public static final String EDUCATION_DETAILS_GRADE = "grade";
    public static final String EDUCATION_DETAILS_CUSTOMER_ID = "customer_id";
    public static final String GRADETYPE_ID = "gradetype_id";
    public static final String GRADETYPE_TYPE = "gradetype_type";
    public static final String GRADETYPE_SCALE = "gradetype_scale";

    //bankdetails table

    public static final String BANKDETAIL_ID = "BANK_DETAIL_ID";
    public static final String BANK_NAME="BANK_NAME";
    public static final String BRANCH_NAME="BRANCH_NAME";
    public static final String IFSCCODE="IFSCCODE";
    public static final String ACCOUNT_NUMBER="ACCOUNT_NUMBER";
    public static final String ACCOUNT_TYPE="ACCOUNT_TYPE";
    public static final String IS_ACTIVE="IS_ACTIVE";

    //project table
    public static final String PROJECT_ID = "ID";
    public static final String PROJECT_NAME = "PROJECT_NAME";
    public static final String PROJECT_TYPE = "PROJECT_TYPE_ID";
    public static final String PROJECT_DESC = "PROJECT_DESCRIPTION";
    public static final String PROJECT_OWNER = "PROJECT_OWNER_ID";
    public static final String PROJECT_IS_ACTIVE = "IS_ACTIVE";
    public static final String PROJECT_CUST_ID = "CUSTOMER_ID";
    public static final String PROJECT_START_DATE = "START_DATE";
    public static final String PROJECT_END_DATE = "END_DATE";
    public static final String PROJECT_PRODUCT_TYPE_ID = "ID";
    public static final String PROJECT_PRODUCT_TYPE_NAME = "PROJECT_TYPE_NAME";
    public static final String PROJECT_PRODUCT_TYPE_CUST_ID = "CUSTOMER_ID";


    //work table
    public static final String WORK_ID = "ID";
    public static final String WORK_ORG_NAME = "ORG_NAME";
    public static final String WORK_EMPLOYEE_ID = "EMPLOYEE_ID";
    public static final String WORK_CUSTOMER_ID = "CUSTOMER_ID";
    public static final String WORK_START_DATE = "START_DATE";
    public static final String WORK_END_DATE = "END_DATE";
    public static final String WORK_DESIGNATION = "DESIGNATION";
    public static final String WORK_OFFICE_LOC_ID = "OFFICE_LOCATION_ID";
    public static final String WORK_EMP_STATUS_ID = "EMPLOYEE_STATUS_ID";




    //Passport Detail Table
    public static final String PASSPORT_ID = "id";
    public static final String PASSPORT_CUS_ID = "cus_id";
    public static final String PASSPORT_TYPE = "pass_type";
    public static final String PASSPORT_COUNTRY_CODE = "pass_country_code";
    public static final String PASSPORT_NUMBER = "pass_number";
    public static final String PASSPORT_PERSON_NAME = "pass_per_name";
    public static final String PASSPORT_NATIONALITY = "pass_nationality";
    public static final String PASSPORT_SEX = "pass_sex";
    public static final String PASSPORT_DOB = "pass_dob";
    public static final String PASSPORT_ISSUE_PLACE = "pass_issue_place";
    public static final String PASSPORT_ISSUE_DATE = "pass_issue_date";
    public static final String PASSPORT_EXPIRY_DATE = "pass_exp_date";
    public static final String PASSPORT_IS_ACTIVE="IS_ACTIVE";

    //Visa Table
    public static final String WORK_VISA_ID = "ID";
    public static final String WORK_VISA_COUNTRY_NAME = "COUNTRY_NAME";
    public static final String WORK_VISA_VALID_FROM = "VALID_FROM";
    public static final String WORK_VISA_EXPIRY_DATE = "EXPIRY_DATE";
    public static final String WORK_VISA_ISSUE_DATE = "ISSUE_DATE";
    public static final String WORK_VISA_CUST_ID = "CUSTOMER_ID";
    public static final String WORK_VISA_PASSPORT_ID = "PASSPORT_ID";

    //Employee Status Table
    public static final String EMPLOYEE_STATUS_ID = "ID";
    public static final String EMPLOYEE_STATUS_TYPE_NAME = "TYPE_NAME";
    public static final String EMPLOYEE_STATUS_DESC = "TYPE_DESCRIPTION";
    public static final String EMPLOYEE_STATUS_CUST_ID = "CUSTOMER_ID";



    //employee_details table
    public static final String EMPLOYEE_ID="EMPLOYEE_ID";
    public static final String EMP_DETAIL_CUSTOMER_ID="CUSTOMER_ID";
    public static final String EMP_DETAIL_EMPLOYEE_NUMBER="EMPLOYEE_NUMBER";
    public static final String EMP_DETAIL_NAME="NAME";
    public static final String EMP_DETAIL_JOINING_DATE="DATE_OF_JOINING";
    public static final String EMP_DETAIL_IMAGE="PHOTO";
    public static final String EMP_DETAIL_BLOOD_GROUP="BLOOD_GROUP";
    public static final String EMP_DETAIL_DURATION="DURATION";
    public static final String EMP_DETAIL_PHONE_NUMBER="PHONE_NUMBER";
    public static final String CUSTOMER_ID = "CUSTOMER_ID";
    public static final String EMP_DETAIL_IS_LEAD= "IS_LEAD";
    public static final String EMP_DETAIL_EMAIL_ID="EMAIL_ID";
    public static final String EMP_DETAIL_EMERGENCY_ADDRESS="EMERGENCY_ADDRESS";
    public static final String EMP_DETAIL_EMERGENCY_CONTACT="EMERGENCY_CONTACT";
    public static final String EMP_DETAIL_EMERGENCY_NAME="EMERGENCY_NAME";
    public static final String EMP_DETAIL_PERMANENT_ADDRESS="PERMANENT_ADDRESS";
    public static final String EMP_DETAIL_EMERGENCY_RELATION="EMERGENCY_RELATION";
    public static final String EMP_DETAIL_FACEBOOK_ID="FACEBOOK_ID";
    public static final String EMP_DETAIL_SKYPE_ID="SKYPE_ID";
    public static final String EMP_DETAIL_TWITTER_ID="TWITTER_ID";

    //salary table
    public static final String SALARY_ID = "SALARY_ID";
    public static final String SALARY_FIXED_SALARY = "FIXED_SALARY";
    public static final String SALARY_VARIABLE_SALARY = "VARIABLE_SALARY";
    public static final String SALARY_DATE_OF_CHANGE = "DATE_OF_CHANGE";
    public static final String SALARY_PERCENTAGE_CHANGE_IN_FIXED_SALARY = "PERCENTAGE_CHANGE";
    public static final String SALARY_ABSOLUTE_CHANGE_IN_FIXED_SALARY = "ABSOLUTE_CHANGE";
    public static final String SALARY_NOTES = "NOTES";
    public static String SALARY_IS_CURRENT = "IS_CURRENT";
    public static String SALARY_IS_ACTIVE = "IS_ACTIVE";


    //esop table
    public static final String ESOP_ID = "ESOP_ID";
    public static  final  String ESOP_DATE_OFFERED = "DATE_OFFERED";
    public static  final  String ESOP_OFFERED_STOCKS = "OFFERED_STOCKS";
    public static  final  String ESOP_PRICE_OF_STOCK = "PRICE_OF_STOCK";
    public static  final  String ESOP_BREAKAGES = "BREAK_UP_COUNT";
    public static  final  String ESOP_ACTIVE = "ACTIVE";


    //esopbreakage table
    public static  final  String ESOP_BREAKAGE_ID = "BREAKAGE_ID";
    public static  final  String ESOP_BREAKAGE_VESTING_DATE = "VESTING_DATE";
    public static  final  String ESOP_BREAKAGE_STOCKS_TO_BE_VESTED = "STOCKS_TO_BE_VESTED";
    public static  final  String ESOP_BREAKAGE_ACTIVE = "ACTIVE";


    //variablepayhistory table
    public static final String VARIABLE_PAY_ID = "VARIABLE_PAY_ID";
    public static final String VARIABLE_PAY_HISTORY_VARIABLE_PAYMENT = "VARIABLE_PAYMENT";
    public static final String VARIABLE_PAY_HISTORY_DATE_OF_PAYMENT = "DATE_OF_PAYMENT";
    public static final String VARIABLE_PAY_HISTORY_PERCENTAGE_PAID = "PERCENTAGE_PAID";
    public static final String VARIABLE_PAY_HISTORY_ACTUAL_PAYMENT = "ACTUAL_PAYMENT_BEFORE_TAX";
    public static final String VARIABLE_PAY_HISTORY_IS_ACTIVE = "IS_ACTIVE";

    //SkillsTable
    public static final String SKILLS_ID = "SKILL_ID";
    public static final String SKILL_TYPE = "SKILL_TYPE";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String SKILL_EMP_ID="EMP_ID";
    public static final String SKILL_NAME ="SKILL_NAME";
    public static final String SKILL_PROFICIENCY = "SKILL_PROFICIENCY";

    //location table
    public static final String LOCATION_ID = "LOCATION_ID";
    public static final String LOCATION_SHORTNAME = "SHORT_NAME";
    public static final String LOCATION_ADDRESS = "ADDRESS";
    public static final String LOCATION_PHONE = "PHONE";
    public static final String LOCATION_DESKNO = "FRONT_DESK_NUMBER";
    public static final String LOCATION_LATLONG = "LAT_LONG";
    public static final String LOCATION_ISACTIVE = "IS_ACTIVE";


    //employee type table
    public static final String EMPLOYEE_TYPE_EMPTYPE_ID="EMPLOYEE_TYPE_ID";
    public static final String EMPLOYEE_TYPE_EMP_TYPE="EMPLOYEE_TYPE";
    public static final String EMPLOYEE_TYPE_DESCRIPTION="DESCRIPTION";


    //designation table
    public static final String DESIGNATION_ID = "DESIGNATION_ID";
    public static final String DESIGNATION_NAME = "NAME";
    public static final String DESIGNATION_DESC = "DESCRIPTION";
    public static final String DESIGNATION_ROLE= "ROLE_DETAILS";
    public static final String DESIGNATION_PROMO = "NEXT_PROMOTION_REQUIREMENTS";
    public static final String DESIGNATION_CODE = "CODE";
    public static final String DESIGNATION_ISACTIVE = "IS_ACTIVE";


    //department table
    public static final String DEPARTMENT_ID = "DEPARTMENT_ID";
    public static final String DEPARTMENT_CUSTOMER_ID = "CUSTOMER_ID";
    public static final String DEPARTMENT_NAME = "NAME";
    public static final String DEPARTMENT_DESCRIPTION = "DESCRIPTION";
    public static final String DEPARTMENT_PARENT_DEPARTMENT = "PARENT_DEPARTMENT_ID";


    //lead table
    public static final String LEAD_ID = "LEAD_ID";
    public static final String LEAD_ISACTIVE="IS_ACTIVE";
    public static final String LEAD_START="START_DATE";
    public static final String LEAD_END="END_DATE";


    // LEAVEBALANCE TABLE
    public static final String LEAVEBALANCE_ID = "ID";
    public static final String LEAVEBALANCE_LEAVE_BALANCE = "LEAVE_BALANCE";
    public static final String LEAVEBALANCE_EMPLOYEE_ID = "EMPLOYEE_ID";
    public static final String LEAVEBALANCE_LEAVE_TYPE = "LEAVE_TYPE";
    public static final String LEAVEBALANCE_CUSTOMER_ID = "CUSTOMER_ID";


    // LEAVETYPE TABLE
    public static final String LEAVETYPE_CUSTOMER_ID = "CUSTOMER_ID";
    public static final String LEAVETYPE_LEAVE_TYPE_ID = "LEAVE_TYPE_ID";
    public static final String LEAVETYPE_MAX_LEAVE = "MAX_LEAVE";
    public static final String LEAVETYPE_LEAVE_TYPE = "LEAVE_TYPE";
    public static final String LEAVETYPE_DAFAULT_TYPE="DEFAULT_LEAVE";
    public static final String LEAVETYPE_CARRY_FORWARD="CARRY_FORWARD";


    //LEAVEHISTORY
    public static final String LEAVEHISTORY_LEAVE_HISTORY_ID="LEAVE_HISTORY_ID";
    public static final String LEAVEHISTORY_EMPLOYEE_ID="EMPLOYEE_ID";
    public static final String LEAVEHISTORY_FROM_DATE="FROM_DATE";
    public static final String LEAVEHISTORY_TO_DATE="TO_DATE";
    public static final String LEAVEHISTORY_DAY_COUNT="DAYS_COUNT";
    public static final String LEAVEHISTORY_LEAVE_TYPE="LEAVE_TYPE";
    public static final String LEAVEHISTORY_APPLIED_DATE="APPLIED_DATE";
    public static final String LEAVEHISTORY_APPROVED_DATE="APPROVED_DATE";
    public static final String LEAVEHISTORY_LEAVE_STATUS="LEAVE_STATUS";
    public static final String LEAVEHISTORY_IS_CANCELLED="IS_CANCELLED";
    public static final String LEAVEHISTORY_LEAVE_REASON="LEAVE_REASON";
    public static final String LEAVEHISTORY_STATUS_REASON="STATUS_REASON";
    public static final String LEAVEHISTORY_CUSTOMER_ID  ="CUSTOMER_ID";
    public static final String LEAVEHISTORY_APPROVED_BY ="APPROVED_BY";


    //LEAVERENEWAL
    public static final String LEAVERENEWAL_ID = "ID";
    public static final String LEAVERENEWAL_CUSTOMER_ID = "CUSTOMER_ID";
    public static final String LEAVERENEWAL_RENEWAL_ID = "RENEWAL_ID";


    //dependent table
    public static final String DEPENDENT_DEPENDENT_ID = "DEPENDENT_ID";
    public static final String DEPENDENT_DATE_OF_BIRTH = "DATE_OF_BIRTH";
    public static final String DEPENDENT_DEPENDENT_GENDER = "DEPENDENT_GENDER";
    public static final String DEPENDENT_DEPENDENT_RELATION = "DEPENDENT_RELATION";
    public static final String DEPENDENT_FIRST_NAME = "FIRST_NAME";
    public static final String DEPENDENT_MIDDLE_NAME = "MIDDLE_NAME";
    public static final String DEPENDENT_LAST_NAME = "LAST_NAME";
    public static String DEPENDENT_IS_ACTIVE = "IS_ACTIVE";


}



