package com.i2i.dao;

import com.i2i.entity.Employee;
import java.util.List;

public interface IEmployeeDao<T extends Employee> {

    /**
     * Returns list of  All Employees    
     * @return {@link List} of {@link Trainer} and {@link Trainee}
     */
    public List<T> retrieveAllEmployees();

    /**
     * creates new employee record and adds it in Trainer and Trainee list
     * @param employee {@link Employee} the employee object
     * @return {@link void}
     */
    public void insertEmployee(T employee);

    /**
    * Used to get the Employee by EmployeeId
    * @param EmployeeId {@link String} EmployeeId of the trainer or trainee
    * @return {@link Trainer} or {@link Trainer} the employee object
    */
    public T retrieveEmployeeById(String employeeId);

    /**
     * Used to remove the Employee by EmployeeId
     * @param EmployeeId {@link String} EmployeeId of the trainer or trainee 
     * @return {@link void} 
     */
    public void removeEmployeeById(String employeeId);

    /**
     * Used to update the Mobile Number value by EmployeeId
     * @param EmployeeId {@link String} EmployeeId of the trainer or tainee 
     * @param Mobile Number{@link long} mobile number of employee
     * @return {@link void} 
     */
    public String updateEmployeeById(String employeeId, long newMobileNumber);

    /**
     * Used to associate Employee by EmployeeId
     * @param TrainerId and TraineeId {@link String & link String} TrainerId of the traineer TraineeId of the traineee 
     * @return {@link void} 
     */
    public void associateEmployeeById(String employeeId, List<T> employees);

    /**
     * Used to get the Associated Employee by EmployeeId
     * @param EmployeeId {@link String} EmployeeId of the trainer or trainee
     * @return {@link Trainer or link Trainee} the trainer or trainee object
     */
    public List<T> retriveAssociate(String employeeId);
}