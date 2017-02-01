package com.coviam.internalapp.hrms.employee.entity;

import com.coviam.internalapp.hrms.department.entity.Department;
import com.coviam.internalapp.hrms.dependent.entity.Dependent;
import com.coviam.internalapp.hrms.designation.entity.Designation;
import com.coviam.internalapp.hrms.educationaldetails.entity.EducationalDetails;
import com.coviam.internalapp.hrms.emptype.entity.EmployeeType;
import com.coviam.internalapp.hrms.esop.entity.ESOP;
import com.coviam.internalapp.hrms.lead.entity.Lead;
import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;
import com.coviam.internalapp.hrms.location.entity.Location;
import com.coviam.internalapp.hrms.project.entity.Project;
import com.coviam.internalapp.hrms.skills.entity.Skills;
import com.coviam.internalapp.hrms.utils.ColumnUtils;
import com.coviam.internalapp.hrms.utils.TableUtils;
import com.coviam.internalapp.hrms.variablepayhistory.entity.VariablePay;
import com.coviam.internalapp.hrms.work.entity.WorkExperience;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name=TableUtils.EMP_DETAIL)
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = ColumnUtils.EMPLOYEE_ID, unique = true, nullable = false)
    private String employeeId;

    @Column(name = ColumnUtils.EMP_DETAIL_CUSTOMER_ID)
    private String customerId;
    @Column(name = ColumnUtils.EMP_DETAIL_EMPLOYEE_NUMBER)
    private String employeeCode;
    @Column(name = ColumnUtils.EMP_DETAIL_NAME)
    private String employeeName;
    @Column(name = ColumnUtils.EMP_DETAIL_JOINING_DATE)
    private Date dateOfJoining;
    @Column(name = ColumnUtils.EMP_DETAIL_IMAGE)
    private byte[] image;
    @Column(name = ColumnUtils.EMP_DETAIL_DURATION)
    private String duration;
    @Column(name = ColumnUtils.EMP_DETAIL_BLOOD_GROUP)
    private String bloodGroup;
    @Column(name = ColumnUtils.EMP_DETAIL_PHONE_NUMBER)
    private String phoneNumber;
    @Column(name = ColumnUtils.EMP_DETAIL_IS_LEAD)
    private Boolean isLead;
    @Column(name = ColumnUtils.EMP_DETAIL_EMAIL_ID)
    private String emailId;
    @Column(name = ColumnUtils.EMP_DETAIL_PERMANENT_ADDRESS)
    private String permanentAddress;
    @Column(name = ColumnUtils.EMP_DETAIL_EMERGENCY_CONTACT)
    private String emergencyContact;
    @Column(name = ColumnUtils.EMP_DETAIL_EMERGENCY_ADDRESS)
    private String emergencyAddress;
    @Column(name = ColumnUtils.EMP_DETAIL_EMERGENCY_RELATION)
    private String emergencyRelation;
    @Column(name = ColumnUtils.EMP_DETAIL_EMERGENCY_NAME)
    private String emergencyName;
    @Column(name = ColumnUtils.EMP_DETAIL_FACEBOOK_ID)
    private String facebookId;
    @Column(name = ColumnUtils.EMP_DETAIL_TWITTER_ID)
    private String twitterId;
    @Column(name = ColumnUtils.EMP_DETAIL_SKYPE_ID)
    private String skypeId;

    @OneToMany(mappedBy = "employeeId")
    private List<Skills> skillsList;

    @OneToMany(mappedBy = "employeeId")
    private List<LeaveHistory> leaveHistories;


    @OneToMany(mappedBy = "employeeId")
    private List<Lead> leadsList;

    @OneToMany(mappedBy = "employeeId")
    private List<WorkExperience> workExperiencesList;

    @OneToMany(mappedBy = "employeeId")
    private List<LeaveHistory> leaveHistoryList;

    @OneToMany(mappedBy = "employeeId")
    private List<EducationalDetails> educationalDetailsList;

    @OneToMany(mappedBy = "employeeId")
    private List<VariablePay> variablePayslist;

    @ManyToMany(targetEntity = Project.class)
    private List<Project> projects;

    @OneToMany(mappedBy = "employeeId")
    private List<Dependent> dependentsList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ColumnUtils.DESIGNATION_ID)
    private Designation designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ColumnUtils.LOCATION_ID)
    private Location location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ColumnUtils.DEPARTMENT_ID)
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ColumnUtils.EMPLOYEE_TYPE_EMPTYPE_ID)
    private EmployeeType employeeType;




    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getLead() {
        return isLead;
    }

    public void setLead(Boolean lead) {
        isLead = lead;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    public void setEmergencyAddress(String emergencyAddress) {
        this.emergencyAddress = emergencyAddress;
    }

    public String getEmergencyRelation() {
        return emergencyRelation;
    }

    public void setEmergencyRelation(String emergencyRelation) {
        this.emergencyRelation = emergencyRelation;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getSkypeId() {
        return skypeId;
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }

    public List<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    public List<LeaveHistory> getLeaveHistories() {
        return leaveHistories;
    }

    public void setLeaveHistories(List<LeaveHistory> leaveHistories) {
        this.leaveHistories = leaveHistories;
    }

    public List<Lead> getLeadsList() {
        return leadsList;
    }

    public void setLeadsList(List<Lead> leadsList) {
        this.leadsList = leadsList;
    }

    public List<WorkExperience> getWorkExperiencesList() {
        return workExperiencesList;
    }

    public void setWorkExperiencesList(List<WorkExperience> workExperiencesList) {
        this.workExperiencesList = workExperiencesList;
    }

    public List<LeaveHistory> getLeaveHistoryList() {
        return leaveHistoryList;
    }

    public void setLeaveHistoryList(List<LeaveHistory> leaveHistoryList) {
        this.leaveHistoryList = leaveHistoryList;
    }

    public List<EducationalDetails> getEducationalDetailsList() {
        return educationalDetailsList;
    }

    public void setEducationalDetailsList(List<EducationalDetails> educationalDetailsList) {
        this.educationalDetailsList = educationalDetailsList;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public List<VariablePay> getVariablePayslist() {
        return variablePayslist;
    }

    public void setVariablePayslist(List<VariablePay> variablePayslist) {
        this.variablePayslist = variablePayslist;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Dependent> getDependentsList() {
        return dependentsList;
    }

    public void setDependentsList(List<Dependent> dependentsList) {
        this.dependentsList = dependentsList;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public List<Project> getProjectsList() {
        return projects;
    }
}
