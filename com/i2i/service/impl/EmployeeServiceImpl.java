package com.i2i.service.impl;

import com.i2i.dto.Employee;
import com.i2i.dto.TrainerDto;
import com.i2i.dto.TraineeDto;
import com.i2i.entity.Trainer;
import com.i2i.entity.Trainee;
import com.i2i.converter.Converter;
import com.i2i.service.IEmployeeService;
import com.i2i.dao.IEmployeeDao;
import com.i2i.dao.impl.EmployeeDaoImpl;
import java.util.List;

public class EmployeeServiceImpl<T extends Employee> implements IEmployeeService<T> {

    private static IEmployeeDao<Trainer> trainerDao = new EmployeeDaoImpl(new Trainer());
    private static IEmployeeDao<Trainee> traineeDao = new EmployeeDaoImpl(new Trainee());
    private T t;

    public EmployeeServiceImpl(T t) {
        this.t = t;
    }

    /**
     * creates new employee record and adds it in Trainer or Trainee list
     * @param employee {@link Trainer} or {@link Trainee} the trainer object
     * @return {@link void}
     */
    @Override
    public void addEmployee(T t) {
        if(t instanceof TrainerDto) {
            Trainer trainer = Converter.convertTrainerDtoToTrainer((TrainerDto)t);
	    trainerDao.insertEmployee((Trainer)trainer);
        } else {
            Trainee trainee = Converter.convertTraineeDtoToTrainee((TraineeDto)t);
            traineeDao.insertEmployee((Trainee)trainee);
        }
    }

    /**
     * Returns list of  All employees    
     * @return {@link List} of {@link Trainer} or {@link Trainee} 
     */
    @Override
    public List<T> getAllEmployees() {
        if(t instanceof TrainerDto) {
            List<TrainerDto> trainers = Converter.convertTrainerList((List<Trainer>)trainerDao.retrieveAllEmployees());
	    return (List<T>) trainers;
        } else {
            List<TraineeDto> trainees = Converter.convertTraineeList((List<Trainee>)traineeDao.retrieveAllEmployees());
            return (List<T>) trainees;
        }
    }
 
    /**
     * Used to get the Employee by EmployeeId
     * @param EmployeeId {@link String} EmployeeId of the trainer or trainee
     * @return {@link Trainer} the trainer object
     */
    @Override
    public T getEmployeeById(String employeeId) {
        if(t instanceof TrainerDto) {
            TrainerDto trainer = Converter.convertTrainerToTrainerDto((Trainer)trainerDao.retrieveEmployeeById(employeeId));
            return (T)trainer;
	} else {
            TraineeDto trainee = Converter.convertTraineeToTraineeDto((Trainee)traineeDao.retrieveEmployeeById(employeeId));
            return (T)trainee;
	} 
    }      

    /**
     * Used to remove the Trainer by TrainerId
     * @param TrainerId {@link String} TrainerId of the traineer 
     * @return {@link void} 
     */
    @Override
    public void removeEmployeeById(String employeeId) {
        if(t instanceof TrainerDto) {
            trainerDao.removeEmployeeById(employeeId);
	} else {
            traineeDao.removeEmployeeById(employeeId);
	} 
    } 

    /**
     * Used to update the Mobile Number value by EmployeeId
     * @param TrainerId {@link String & link long} TrainerId of the traineer 
     * @return {@link String} 
     */
    @Override
    public String updateEmployeeById(String employeeId, long newMobileNumber) {
        if(t instanceof TrainerDto) {
            return trainerDao.updateEmployeeById(employeeId, newMobileNumber);
	} else {
            return traineeDao.updateEmployeeById(employeeId, newMobileNumber);
	}
    }

    /**
     * Used to associate Employee by EmployeeId
     * @param TrainerId and TraineeId {@link String & link String} TrainerId of the traineer TraineeId of the traineee 
     * @return {@link void} 
     */
    @Override
    public void associateEmployeeById(String employeeId, List<T> employees) {
        if(t instanceof TrainerDto) {
            trainerDao.associateEmployeeById(employeeId, (List<Trainee>)employees);
	} else {
            traineeDao.associateEmployeeById(employeeId, (List<Trainer>)employees);
        }
    } 

    /**
     * Used to get the Associated Employee by EmployeeId
     * @param EmployeeId {@link String} EmployeeId of the trainer or trainee
     * @return {@link Trainer or link Trainee} the trainer or trainee object
     */
    @Override
    public List<T> getAssociateEmployeeById(String employeeId) {
        if(t instanceof TrainerDto) {
            List<TrainerDto> trainers = Converter.convertTrainerList((List<Trainer>)trainerDao.retriveAssociate(employeeId));
            return (List<T>)trainers;
	} else {
            List<TraineeDto> trainees = Converter.convertTraineeList((List<Trainee>)traineeDao.retriveAssociate(employeeId));
            return (List<T>)trainees;
	} 
    }         
}	    