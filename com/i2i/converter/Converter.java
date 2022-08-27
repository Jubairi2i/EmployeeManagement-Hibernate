package com.i2i.converter;

import com.i2i.entity.Trainer;
import com.i2i.entity.Trainee;
import com.i2i.dto.Employee;
import com.i2i.dto.TrainerDto;
import com.i2i.dto.TraineeDto;
import java.util.List;
import java.util.LinkedList;


public class Converter {

    public static Trainer convertTrainerDtoToTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setEmployeeId(trainerDto.getEmployeeId());
        trainer.setEmployeeName(trainerDto.getEmployeeName());
        trainer.setEmployeeMobileNumber(trainerDto.getEmployeeMobileNumber());
        trainer.setEmployeeDateOfBirth(trainerDto.getEmployeeDateOfBirth());
        trainer.setEmployeeDateOfJoining(trainerDto.getEmployeeDateOfJoining());
        return trainer;
    }


    public static TrainerDto convertTrainerToTrainerDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setEmployeeId(trainer.getEmployeeId());
        trainerDto.setEmployeeName(trainer.getEmployeeName());
        trainerDto.setEmployeeMobileNumber(trainer.getEmployeeMobileNumber());
        trainerDto.setEmployeeDateOfBirth(trainer.getEmployeeDateOfBirth());
        trainerDto.setEmployeeDateOfJoining(trainer.getEmployeeDateOfJoining());
        return trainerDto;
    }

    public static Trainee convertTraineeDtoToTrainee(TraineeDto traineeDto) {
        Trainee trainee = new Trainee();
        trainee.setEmployeeId(traineeDto.getEmployeeId());
        trainee.setEmployeeName(traineeDto.getEmployeeName());
        trainee.setEmployeeMobileNumber(traineeDto.getEmployeeMobileNumber());
        trainee.setEmployeeDateOfBirth(traineeDto.getEmployeeDateOfBirth());
        trainee.setEmployeeDateOfJoining(traineeDto.getEmployeeDateOfJoining());
        return trainee;
    }

    public static TraineeDto convertTraineeToTraineeDto(Trainee trainee) {
        TraineeDto traineeDto = new TraineeDto();
        traineeDto.setEmployeeId(trainee.getEmployeeId());
        traineeDto.setEmployeeName(trainee.getEmployeeName());
        traineeDto.setEmployeeMobileNumber(trainee.getEmployeeMobileNumber());
        traineeDto.setEmployeeDateOfBirth(trainee.getEmployeeDateOfBirth());
        traineeDto.setEmployeeDateOfJoining(trainee.getEmployeeDateOfJoining());
        return traineeDto;
    }

    public static List<TraineeDto> convertTraineeList(List<Trainee> trainees) {
	List<TraineeDto> traineeDtos = new LinkedList();
	TraineeDto traineeDto = null; 
	for (Trainee trainee : trainees) {
	    traineeDto = convertTraineeToTraineeDto(trainee);
	    traineeDtos.add(traineeDto); 
	}
	return traineeDtos;
    }

    public static List<TrainerDto> convertTrainerList(List<Trainer> trainers) {
	List<TrainerDto> trainerDtos = new LinkedList();
	TrainerDto trainerDto = null; 
	for (Trainer trainer : trainers) {
	    trainerDto = convertTrainerToTrainerDto(trainer);
	    trainerDtos.add(trainerDto); 
	}
	return trainerDtos;
    }

    public static List<Employee> convertEmployeeList(List<Employee> employees) {
	List<Employee> employeeList = new LinkedList();
	TrainerDto trainerDto = null;
	TraineeDto traineeDto = null;
	for (Employee employee : employees) {
	    if (employee instanceof Trainer) {
		trainerDto = convertTrainerToTrainerDto((Trainer)employee);
		employeeList.add(trainerDto);
	    }
	    else {
		traineeDto = convertTraineeToTraineeDto((Trainee)employee);
		employeeList.add(traineeDto);
	    }
        }
	return employeeList;
    }	
}
