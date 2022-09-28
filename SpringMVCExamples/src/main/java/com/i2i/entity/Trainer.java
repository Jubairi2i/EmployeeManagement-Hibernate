package com.i2i.entity;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
                        name = "getAllTrainer",
                        query = "from Trainer trainer where trainer.isActive = false"
                ),
                @NamedQuery(
                        name = "getTrainerById",
                        query = "from Trainer where employeeId = :employeeId and isActive = false"
                )
        }
)

/**
 * <p>
 * Trainer class is child class of Employee class
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
@Primary
@Table(name = "TRAINER")
public class Trainer extends Employee {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ASSOCIATION_TABLE",
            joinColumns = { @JoinColumn(name = "TRAINER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "TRAINEE_ID")})
    private Set<Trainee> trainees;

    public Set<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(Set<Trainee> trainees) {
        this.trainees = trainees;
    }

    /*public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
                .append("\n")
                .append(this.getTrainees());
        return stringBuilder.toString();
    }*/
}
