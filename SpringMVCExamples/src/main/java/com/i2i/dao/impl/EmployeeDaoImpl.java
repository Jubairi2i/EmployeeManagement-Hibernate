package com.i2i.dao.impl;

import com.i2i.dao.IEmployeeDao;
import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * <p>
 * EmployeeDaoImpl is used get value from database and give it to
 * service
 * </p>
 *
 * @author Mohamed Jubair
 *
 * @version 1
 *
 * @since 2022-07-18
 */
@Repository
public class EmployeeDaoImpl<T extends Employee> implements IEmployeeDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * creates new employee record and adds it in Trainer table
     *
     * @param employee {@link T} employee object
     *
     * @return {void}
     */
    @Override
    public void insertEmployee(T employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    /**
     * Returns list of All trainers form database
     *
     * @return {@link Trainer} of Trainer
     */
    @Override
    public List<Trainer> retrieveAllTrainers() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery query = session.getNamedQuery("getAllTrainer");
        List<Trainer> trainers = query.getResultList();
        return trainers;
    }

    /**
     * Returns list of All trainees from database
     *
     * @return {@link Trainee} of Trainee
     */
    @Override
    public List<Trainee> retrieveAllTrainees() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery query = session.getNamedQuery("getAllTrainee");
        List<Trainee> trainees = query.getResultList();
        return trainees;
    }

    /**
     * Used to get the Employee by employeeId
     *
     * @param employeeId {@link String} EmployeeId of trainer
     * @return {@link Trainer} the employee object
     */
    @Override
    public Trainer retrieveTrainerById(String employeeId) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery query = session.getNamedQuery("getTrainerById")
                .setParameter("employeeId", employeeId);
        Trainer trainer = (Trainer) query.getSingleResult();
        return trainer;
    }

    /**
     * Used to get the Employee by employeeId
     *
     * @param employeeId {@link String} EmployeeId of trainee
     * @return {@link Trainee} the employee object
     */
    @Override
    public Trainee retrieveTraineeById(String employeeId) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery query = session.getNamedQuery("getTraineeById")
                .setParameter("employeeId", employeeId);
        Trainee trainee = (Trainee) query.getSingleResult();
        return trainee;
    }

    /**
     * Used to update the Mobile Number of the employee by using employeeId
     *
     * @param employee {@link Trainer}
     * @return {void}
     */
    @Override
    public void updateEmployee(T employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

}
