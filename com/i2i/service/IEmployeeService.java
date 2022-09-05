package com.i2i.service;

import com.i2i.dto.EmployeeDto;
import java.util.List;

public interface IEmployeeService<T extends EmployeeDto> {

    /**
     * creates new employee record and adds it in Trainer or Trainee list
     * @param employee {@link Trainer} or {@link Trainee} the Employee object
     * @return {@link void}
     */
    public void addEmployee(T t);

   /**
    * Returns list of  All employees    
    * @return {@link List} of {@link Trainer} or {@link Trainee} 
    */
    public List<T> getAllEmployees();

    /**
     * Used to get the Employee by EmployeeId
     * @param EmployeeId {@link String} EmployeeId of the trainer or trainee 
     * @return {@link Trainer} the employee object
     */
    public T getEmployeeById(String employeeId);

    /**
     * Used to remove the Trainer by TrainerId
     * @param TrainerId {@link String} TrainerId of the traineer 
     * @return {@link void} 
     */
    public void removeEmployeeById(String employeeId);

    /**
     * Used to update the Mobile Number value by EmployeeId
     * @param TrainerId {@link String & link long} TrainerId of the traineer 
     * @return {@link void} 
     */
    public String updateEmployeeById(String employeeId, long newMobileNumber);

    public void associateEmployeeById(String employeeId, List<EmployeeDto> employees);

    public T getAssociateEmployeeById(String employeeId);
}