package com.i2i.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * <p>
 * Employee class is parent class of both Trainer and Trainee class
 * and caries common variables of both Trainer and Trainee
 * </p>
 *
 * @author Mohamed Jubair
 *
 * @version 1
 *
 * @since 2022-07-18
 */
@MappedSuperclass
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @Column(name = "COMPANY_NAME")
    private final static String companyName = "Ideas2IT";
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;
    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;
    @Column(name = "MOBILE_NUMBER")
    private long employeeMobileNumber;
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate employeeDateOfBirth;
    @Column(name = "DATE_OF_JOIN")
    private LocalDate employeeDateOfJoin;
    @Column(name = "IS_ACTIVE")
    private boolean isActive = false;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public long getEmployeeMobileNumber() {
        return employeeMobileNumber;
    }

    public void setEmployeeMobileNumber(long employeeMobileNumber) {
        this.employeeMobileNumber = employeeMobileNumber;
    }

    public LocalDate getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
        this.employeeDateOfBirth = LocalDate.parse(employeeDateOfBirth);
    }

    public LocalDate getEmployeeDateOfJoin() {
        return employeeDateOfJoin;
    }

    public void setEmployeeDateOfJoin(String employeeDateOfJoin) {
        this.employeeDateOfJoin = LocalDate.parse(employeeDateOfJoin);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActivity(boolean active) {
        isActive = active;
    }

}
