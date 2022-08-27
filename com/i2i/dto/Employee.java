package com.i2i.dto;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Employee {

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "SLNO")
    private int slNo;
    //@Column(name = "EMPLOYEE_ID", columnDefinition = "varchar(80)")
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;
    @Column(name = "NAME")
    private String employeeName;
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate employeeDateOfBirth;
    @Column(name = "DATE_OF_JOINING")
    private LocalDate employeeDateOfJoining;
    @Column(name = "MOBILE_NUMBER")
    private long employeeMobileNumber;
    @Column(name = "COMPANY_NAME")
    private final static String companyName = "Ideas2IT";
    @Column(name = "IS_DELETE")
    private boolean isDelete = false;

    public String getCompanyName() {
	return companyName;
    }

    public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
    }
  
    public String getEmployeeName() {
	return employeeName;
    }
    
    public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
    }
  
    public String getEmployeeId() {
	return employeeId;
    }
    
    public void setEmployeeDateOfBirth(LocalDate employeeDateOfBirth) {
	this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public LocalDate getEmployeeDateOfBirth() {
	return employeeDateOfBirth;
    }

    public void setEmployeeDateOfJoining(LocalDate employeeDateOfJoining) {
	this.employeeDateOfJoining = employeeDateOfJoining;
    }

    public LocalDate getEmployeeDateOfJoining() {
	return employeeDateOfJoining;
    }
            
    public void setEmployeeMobileNumber(long employeeMobileNumber) {
	this.employeeMobileNumber = employeeMobileNumber;
    }
  
    public long getEmployeeMobileNumber() {
	return employeeMobileNumber;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public boolean getIsDelete() {
        return isDelete;
    }
    
    public int getEmployeeAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(employeeDateOfBirth, currentDate).getYears();
    }

    public int getEmployeeExperience() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(employeeDateOfJoining, currentDate).getYears();
    }

    public String toString() {
        
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Name :")
                     .append(this.getEmployeeName())
                     .append("\nEmployee Id :")
                     .append(this.getEmployeeId())
                     .append("\nAge :")
                     .append(this.getEmployeeAge())
                     .append("\nExperience :")
                     .append(this.getEmployeeExperience())
                     .append("\nMobileNumber :")
                     .append(this.getEmployeeMobileNumber());       
 
        return stringBuilder.toString();
    }
}