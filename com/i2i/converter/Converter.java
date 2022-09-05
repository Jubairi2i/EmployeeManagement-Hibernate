package com.i2i.converter;

import com.i2i.entity.Employee;
import com.i2i.entity.Trainer;
import com.i2i.entity.Trainee;
import com.i2i.dto.EmployeeDto;
import com.i2i.dto.TrainerDto;
import com.i2i.dto.TraineeDto;
import java.util.List;
import java.util.ArrayList;


public class Converter {


    /**
     * Used to convert TrainerDto to Trainer using TrainerDto object   
     * 
     * @param Trainer {@link Trainer}
     *
     * @return {@link Trainer} 
     */    
    public static Trainer convertTrainerDtoToTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setEmployeeId(trainerDto.getEmployeeId());
        trainer.setEmployeeName(trainerDto.getEmployeeName());
        trainer.setEmployeeMobileNumber(trainerDto.getEmployeeMobileNumber());
        trainer.setEmployeeDateOfBirth(trainerDto.getEmployeeDateOfBirth());
        trainer.setEmployeeDateOfJoining(trainerDto.getEmployeeDateOfJoining());
        return trainer;
    }

    /**
     * Used to convert Trainer to TrainerDto using Trainer   
     * 
     * @param Trainer {@link Trainer}
     *
     * @return {@link TrainerDto}
     */
    public static TrainerDto convertTrainerToTrainerDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setEmployeeId(trainer.getEmployeeId());
        trainerDto.setEmployeeName(trainer.getEmployeeName());
        trainerDto.setEmployeeMobileNumber(trainer.getEmployeeMobileNumber());
        trainerDto.setEmployeeDateOfBirth(trainer.getEmployeeDateOfBirth());
        trainerDto.setEmployeeDateOfJoining(trainer.getEmployeeDateOfJoining());
        return trainerDto;
    }

    /**
     * Used to convert TraineeDto to Trainee using TraineeDto object   
     * 
     * @param Trainee {@link Trainee}
     *
     * @return {@link Trainee}
     */
    public static Trainee convertTraineeDtoToTrainee(TraineeDto traineeDto) {
        Trainee trainee = new Trainee();
        trainee.setEmployeeId(traineeDto.getEmployeeId());
        trainee.setEmployeeName(traineeDto.getEmployeeName());
        trainee.setEmployeeMobileNumber(traineeDto.getEmployeeMobileNumber());
        trainee.setEmployeeDateOfBirth(traineeDto.getEmployeeDateOfBirth());
        trainee.setEmployeeDateOfJoining(traineeDto.getEmployeeDateOfJoining());
        return trainee;
    }

    /**
     * Used to convert Trainee to TrainerDto using Trainee   
     * 
     * @param Trainee {@link Trainee}
     *
     * @return {@link TraineeDto}
     */
    public static TraineeDto convertTraineeToTraineeDto(Trainee trainee) {
        TraineeDto traineeDto = new TraineeDto();
        traineeDto.setEmployeeId(trainee.getEmployeeId());
        traineeDto.setEmployeeName(trainee.getEmployeeName());
        traineeDto.setEmployeeMobileNumber(trainee.getEmployeeMobileNumber());
        traineeDto.setEmployeeDateOfBirth(trainee.getEmployeeDateOfBirth());
        traineeDto.setEmployeeDateOfJoining(trainee.getEmployeeDateOfJoining());
        return traineeDto;
    }

    /**
     * Used to convert Trainee List to TraineeDto List using Trainee List   
     * 
     * @param Trainee {@link Trainee}
     *
     * @return {@link TraineeDto}
     */
    public static List<TraineeDto> convertTraineeList(List<Trainee> trainees) {
	List<TraineeDto> traineeDtos = new ArrayList();
	TraineeDto traineeDto = null; 
	for (Trainee trainee : trainees) {
	    traineeDto = convertTraineeToTraineeDto(trainee);
	    traineeDtos.add(traineeDto); 
	}
	return traineeDtos;
    }

    /**
     * Used to convert Trainer List to TrainerDto List using Trainer List   
     * 
     * @param Trainee {@link Trainee}
     *
     * @return {@link TraineeDto}
     */
    public static List<TrainerDto> convertTrainerList(List<Trainer> trainers) {
	List<TrainerDto> trainerDtos = new ArrayList();
	TrainerDto trainerDto = null; 
	for (Trainer trainer : trainers) {
	    trainerDto = convertTrainerToTrainerDto(trainer);
	    trainerDtos.add(trainerDto); 
	}
	return trainerDtos;
    }

    /**
     * Used to convert TraineeDto List to Trainee List using TraineeDto List   
     * 
     * @param EmployeeDto {@link EmployeeDto}
     *
     * @return {@link Trainee}
     */
    public static List<Trainee> convertTraineeDtoListToTraineeList(List<EmployeeDto> trainees) {
	List<Trainee> traineeList = new ArrayList();
	Trainee trainee = null;
	for (EmployeeDto traineeDto : trainees) {
	    trainee = convertTraineeDtoToTrainee((TraineeDto)traineeDto);
            traineeList.add(trainee);
        }
	return traineeList;
    }

    /**
     * Used to convert TrainerDto List to Trainer List using EmployeeDto List   
     * 
     * @param Trainee {@link EmployeeDto}
     *
     * @return {@link Trainee}
     */
    public static List<Trainer> convertTrainerDtoListToTrainerList(List<EmployeeDto> trainers) {
	List<Trainer> trainerList = new ArrayList();
	Trainer trainer = null;
	for (EmployeeDto trainerDto : trainers) {
	    trainer = convertTrainerDtoToTrainer((TrainerDto)trainerDto);
            trainerList.add(trainer);
        }
	return trainerList;
    }	

    /**
     * Used to convert Employee List to EmoloyeeDto List using Employee List   
     * 
     * @param Trainee {@link Employee}
     *
     * @return {@link EmployeeDto}
     */
    public static List<TrainerDto> convertTrainerListToTrainerDtoList(List<Trainer> trainers) {
	List<TrainerDto> trainerDtoList = new ArrayList();
	TrainerDto trainerDto = null;
	for (Trainer trainer : trainers) {
	    trainerDto = convertTrainerToTrainerDto((Trainer)trainer);
	    trainerDtoList.add(trainerDto);
	}  
        return trainerDtoList; 
    }

    public static List<TraineeDto> convertTraineeListToTraineeDtoList(List<Trainee> trainees) {
        List<TraineeDto> traineeDtoList = new ArrayList();
	TraineeDto traineeDto = null;    
        for (Trainee trainee : trainees) {
	    traineeDto = convertTraineeToTraineeDto((Trainee)trainee);
	    traineeDtoList.add(traineeDto);
	}
	return traineeDtoList;
    }	
}

   