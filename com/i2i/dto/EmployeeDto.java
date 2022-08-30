package com.i2i.dto;

import java.time.LocalDate;
import java.time.Period;

public class EmployeeDto {

    private String employeeId;
    private String employeeName;
    private LocalDate employeeDateOfBirth;
    private LocalDate employeeDateOfJoining;
    private long employeeMobileNumber;
    private final static String companyName = "Ideas2IT";
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