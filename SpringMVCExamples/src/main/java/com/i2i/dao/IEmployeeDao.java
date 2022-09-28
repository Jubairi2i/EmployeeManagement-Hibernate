package com.i2i.dao;

import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;

import java.util.List;

/**
 * <p>
 * IEmployeeDao is used to provide total abstraction to EmployeeDaoImpl
 * </p>
 *
 * @author Mohamed Jubair
 *
 * @version 1
 *
 * @since 2022-07-18
 */
public interface IEmployeeDao<T extends Employee> {
    /**
     * creates new employee record and adds it in Trainer table
     *
     * @param employee {@link Trainer} employee object
     *
     * @return {void}
     */
    public void insertEmployee(T employee);


    /**
     * Returns list of All trainers form database
     *
     * @return {@link Trainer} of Trainer
     */
    public List<Trainer> retrieveAllTrainers();
    /**
     * Returns list of All trainees form database
     *
     * @return {@link Trainee} of Trainee
     */
    public List<Trainee> retrieveAllTrainees();
    /**
     * Used to get the Employee by employeeId
     *
     * @param employeeId {@link String} EmployeeId of trainer
     *
     * @return {@link Trainer} the employee object
     */
    public Trainer retrieveTrainerById(String employeeId);
    /**
     * Used to get the Employee by employeeId
     *
     * @param employeeId {@link String} EmployeeId of trainee
     *
     * @return {@link Trainee} the employee object
     */
    public Trainee retrieveTraineeById(String employeeId);
    /**
     * Used to update the Mobile Number of the employee by using employeeId
     *
     * @param employee {@link T} employeeId of trainer
     *
     * @return {void}
     */
    public void updateEmployee(T employee);

}
