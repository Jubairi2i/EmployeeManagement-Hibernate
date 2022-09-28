package com.i2i.entity;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;

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
                        query = "from Trainee trainee where trainee.isActive = false"
                ),
                @NamedQuery(
                        name = "getTraineeById",
                        query = "from Trainee where employeeId = :employeeId and isActive = false"
                )
        }
)

/**
 * <p>
 * Trainee class is child class of Employee class
 * and it is an entity class which create table in database
 * </p>
 *
 * @author Mohamed Jubair
 *
 * @version 1
 *
 * @since 2022-07-18
 */
@Entity
@Component
@Table(name = "TRAINEE")
public class Trainee extends Employee {

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "trainees")
    private Set<Trainer> trainers;

    public Set<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<Trainer> trainers) {
        this.trainers = trainers;
    }

    /*public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append("\n")
                .append(this.getTrainers());
        return stringBuilder.toString();
    }*/
}


