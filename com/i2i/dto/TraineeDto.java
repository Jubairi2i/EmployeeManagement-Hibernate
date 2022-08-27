package com.i2i.dto;

import java.util.List;

public class TraineeDto extends Employee {

    private List<TrainerDto> trainers;

    public List<TrainerDto> getTrainers() {
        return trainers;
    }
 
    public void setTrainers(List<TrainerDto> trainers) {
        this.trainers = trainers;
    }

    public String toString() {
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                     .append("\n")
                     .append(getTrainers());
        return stringBuilder.toString();
    }

}