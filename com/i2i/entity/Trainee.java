package com.i2i.entity;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@NamedQueries(  
    {  
        @NamedQuery(  
        name = "getAllTrainee",  
        query = "from Trainee trainee where trainee.isDelete = false"  
        ),
        @NamedQuery(  
        name = "getTraineeById",  
        query = "from Trainee trainee where trainee.employeeId = :employeeId and trainee.isDelete = false" 
        ),
        @NamedQuery(  
        name = "updateTraineeById",  
        query = "Update Trainee trainee set trainee.employeeMobileNumber =:newMobileNumber where trainee.employeeId = :employeeId and trainee.isDelete = false"  
        )  
    }  
)  

@Entity
@Table(name = "TRAINEE_TABLE")
public class Trainee extends Employee {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "trainees")
    private List<Trainer> trainers = new ArrayList<>();

    public List<Trainer> getTrainers() {
        return trainers;
    }
 
    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public String toString() {
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                     .append("\n")
                     .append(this.getTrainers());
        return stringBuilder.toString();
    }

}