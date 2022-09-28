package com.i2i.service.impl;

import com.i2i.dao.IEmployeeDao;
import com.i2i.dao.impl.EmployeeDaoImpl;
import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;
import com.i2i.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl<T extends Employee> implements IEmployeeService<T> {

    @Autowired
    private IEmployeeDao employeeDao;

    /*@Autowired
    private IEmployeeDao<Trainer> trainerDao;

    @Autowired
    private IEmployeeDao<Trainee> traineeDao;*/


    /*@Autowired
    public EmployeeServiceImpl(T employee, IEmployeeDao<Trainer> trainer, IEmployeeDao<Trainee> trainee) {
        this.employee = employee;
        this.trainer = trainer;
        this.trainee = trainee;
    }*/

    /*@Autowired
    public EmployeeServiceImpl(IEmployeeDao<Trainee> trainerDao) {
        this.trainerDao = trainerDao;
    }

    @Autowired
    public EmployeeServiceImpl(IEmployeeDao<Trainee> traineeDao) {
        this.traineeDoa = traineeDao;
    }*/

    /**
     * send new employee details from controller to DAO
     *
     * @param employee {@link Trainer} of Trainer object
     *
     * @return {void}
     */
    @Override
    @Transactional
    public void addEmployee(T employee) {
        employeeDao.insertEmployee(employee);
    }

    /**
     * Returns list of  All trainers from DAO to controller
     *
     * @return {@link Trainer} of Trainer
     */
    @Override
    @Transactional
    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = employeeDao.retrieveAllTrainers();
        return trainers;
    }

    /**
     * Returns list of  All trainees from DAO to controller
     *
     * @return {@link Trainee} of Trainee
     */
    @Override
    @Transactional
    public List<Trainee> getAllTrainees() {
        List<Trainee> trainees = employeeDao.retrieveAllTrainees();
        return trainees;
    }

    /**
     * Used to get the Employee by EmployeeId form DAO to controller
     *
     * @param employeeId {@link String} EmployeeId of the trainer
     *
     * @return {@link Trainer} the employee object
     */
    @Override
    @Transactional
    public Trainer getTrainerById(String employeeId) {
        return employeeDao.retrieveTrainerById(employeeId);
    }

    /**
     * Used to get the Employee by EmployeeId form DAO to controller
     *
     * @param employeeId {@link String} EmployeeId of the trainee
     *
     * @return {@link Trainee} the employee object
     */
    @Override
    @Transactional
    public Trainee getTraineeById(String employeeId) {
        return employeeDao.retrieveTraineeById(employeeId);
    }

    /**
     * Used to update the Mobile Number value by EmployeeId
     *
     * @param employee {@link T} of employee
     *
     * @return {void}
     */
    @Override
    @Transactional
    public void updateEmployee(T employee) {
        employeeDao.updateEmployee(employee);
    }

}
