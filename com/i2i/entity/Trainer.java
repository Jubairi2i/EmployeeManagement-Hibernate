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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@NamedQueries(  
    {  
        @NamedQuery(  
        name = "getAllTrainer",  
        query = "from Trainer trainer where trainer.isDelete = false"  
        ),
        @NamedQuery(  
        name = "getTrainerById",  
        query = "from Trainer trainer where trainer.employeeId = :employeeId and trainer.isDelete = false" 
        ),
        @NamedQuery(  
        name = "updateTrainerById",  
        query = "Update Trainer trainer set trainer.employeeMobileNumber =:newMobileNumber where trainer.employeeId = :employeeId"  
        )  
    }  
)  

@Entity
@Table(name = "TRAINER_TABLE")
public class Trainer extends Employee {
   

    @ManyToMany(targetEntity = Trainee.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "TRAINER_TRAINEE", 
             joinColumns = { @JoinColumn(name = "TRAINER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "TRAINEE_ID") })
    private List<Trainee> trainees;

    public List<Trainee> getTrainees() {
        return trainees;
    }
 
    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public String toString() {
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                     .append("\n")
                     .append(this.getTrainees());
        return stringBuilder.toString();
    }
}