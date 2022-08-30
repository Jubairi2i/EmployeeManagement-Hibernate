package com.i2i.dto;

import java.util.List;

public class TrainerDto extends EmployeeDto {

    private List<TraineeDto> trainees;

    public List<TraineeDto> getTrainees() {
        return trainees;
    }
 
    public void setTrainees(List<TraineeDto> trainees) {
        this.trainees = trainees;
    }

    public String toString() {
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                      .append("\n")
                      .append(getTrainees());
        return stringBuilder.toString();
    }
}