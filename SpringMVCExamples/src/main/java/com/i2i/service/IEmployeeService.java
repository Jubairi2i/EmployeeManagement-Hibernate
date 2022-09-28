package com.i2i.service;

import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;

import java.util.List;

/**
 *<p>
 *IEmployeeService is used to provide total abstraction to EmployeeServicImpl
 *</p>
 *
 * @author Mohamed Jubair
 *
 * @version 1
 *
 * @since 2022-07-18
 */
public interface IEmployeeService<T extends Employee> {
    /**
     * send new employee details from controller to DAO
     *
     * @param employee {@link Trainer} of Trainer object
     *
     * @return {void}
     */
    public void addEmployee(T employee);

    /**
     * Returns list of  All trainers from DAO to controller
     *
     * @return {@link Trainer} of Trainer
     */
    public List<Trainer> getAllTrainers();
    /**
     * Returns list of  All trainees from DAO to controller
     *
     * @return {@link Trainee} of Trainee
     */
    public List<Trainee> getAllTrainees();
    /**
     * Used to get the Employee by EmployeeId form DAO to controller
     *
     * @param employeeId {@link String} EmployeeId of the trainer
     *
     * @return {@link Trainer} the employee object
     */
    public Trainer getTrainerById(String employeeId);
    /**
     * Used to get the Employee by EmployeeId form DAO to controller
     *
     * @param employeeId {@link String} EmployeeId of the trainee
     *
     * @return {@link Trainee} the employee object
     */
    public Trainee getTraineeById(String employeeId);
    /**
     * Used to update the Mobile Number value by EmployeeId
     *
     * @param employee {@link T} of employee
     *
     * @return {void}
     */
    public void updateEmployee(T employee);

}
