package com.i2i.dao.impl;

import com.i2i.dto.Employee;
import com.i2i.dto.TrainerDto;
import com.i2i.dto.TraineeDto;
import com.i2i.entity.Trainer;
import com.i2i.entity.Trainee;
import com.i2i.dao.IEmployeeDao;
import com.i2i.hibernateUtil.HibernateUtil;
import com.i2i.jdbcConnection.JdbcConnection;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeDaoImpl<T extends Employee> implements IEmployeeDao<T> {

    private Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    private T t;

    public EmployeeDaoImpl(T t) {
        this.t = t;
    }

   /**
    * Returns list of  All Employees    
    * @return {@link List} of {@link Trainer} and {@link Trainee}
    */
    @Override
    public List<T> retrieveAllEmployees() {

        
        if(t instanceof Trainer) {
            List<Trainer> trainers = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                Criteria criteriaTrainer = session.createCriteria(Trainer.class);
                criteriaTrainer.add(Restrictions.ne("isDelete",true));
                trainers = criteriaTrainer.list();
                transaction.commit();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (List<T>) trainers;
        } else {

            List<Trainee> trainees = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
            
                Criteria criteriaTrainee = session.createCriteria(Trainee.class);
                criteriaTrainee.add(Restrictions.ne("isDelete",true));
                trainees = criteriaTrainee.list();
                transaction.commit();
                    
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (List<T>) trainees;
        }
    }

   /**
    * Used to get the Employee by EmployeeId
    * @param EmployeeId {@link String} EmployeeId of the trainer or trainee
    * @return {@link Trainer} or {@link Trainee} the Employee object
    */
    @Override
    public T retrieveEmployeeById(String employeeId) {

        if(t instanceof Trainer) {
            Trainer selectedTrainer = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                Criteria criteriaTrainer = session.createCriteria(Trainer.class);
                criteriaTrainer.add(Restrictions.eq("EMPLOYEE_ID",employeeId));
                criteriaTrainer.add(Restrictions.ne("isDelete", true));
                selectedTrainer = criteriaTrainer.list().get(0);
              
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (T)selectedTrainer;
        } else {
            Trainee selectedTrainee = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                Criteria criteriaTrainee = session.createCriteria(Trainee.class);
                criteriaTrainee.add(Restrictions.eq("EMPLOYEE_ID",employeeId));
                criteriaTrainer.add(Restrictions.ne("isDelete", true));
                selectedTrainee = criteriaTrainee.list().get(0);

                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (T)selectedTrainee;
        }
    }

    /**
     * creates new Employee record and inserts it in Trainer and Trainee list
     * @param employee {@link Employee} the employee object
     * @return {@link void}
     */
    @Override
    public void insertEmployee(T employee) {

        if(employee instanceof Trainer) {

             Transaction transaction = null;
             try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                 transaction = session.beginTransaction();
                 session.save(employee);
                 transaction.commit();
             } catch (Exception e) {
                 if (transaction != null) 
                     transaction.rollback();
                 e.printStackTrace(); 
             }   
          
        } else {

            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.save(employee);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) 
                    transaction.rollback();
                e.printStackTrace(); 
            }                 
        }
    }

    /**
     * Used to remove the Employee by EmployeeId
     * @param EmployeeId {@link String} EmployeeId of the Employee 
     * @return {@link void} 
     */
    @Override
    public void removeEmployeeById(String employeeId) {
        if(t instanceof Trainer) {

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {   
                Transaction transaction = session.beginTransaction();
            
                Trainer trainer = session.get(Trainer.class, employeeId);
                trainer.setIsDelete(true);
                session.update(trainer);
                transaction.commit();
             } catch (Exception e) {
                 e.printStackTrace(); 
             }
            
	    } else {

                try (Session session = HibernateUtil.getSessionFactory().openSession()) {   
                    Transaction transaction = session.beginTransaction();
            
                    Trainee trainee = session.get(Trainee.class, employeeId);
                    trainee.setIsDelete(true);
                    session.update(trainee);
                    transaction.commit();
                    session.close(); 
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
	    } 
        }
  
    /**
     * Used to update the Mobile Number value by EmployeeId
     * @param EmployeeId {@link String & link long} EmployeeId of the employee 
     * @return {@link void} 
     */
    @Override
    public String updateEmployeeById(String employeeId, long newMobileNumber) {
        String message = " Employee not updated ";
        Transaction transaction = null;
        if(t instanceof Trainer) {
	    
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
            
                Trainer trainer = session.get(Trainer.class, employeeId);
                if (!trainer.getIsDelete()) {
                    trainer.setEmployeeMobileNumber(newMobileNumber);
                    session.update(trainer);
                    message = "trainer updated";
                }
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) 
                    transaction.rollback();
                e.printStackTrace(); 
            } 

        } else {
            
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
            
                Trainee trainee = session.get(Trainee.class, employeeId);
                if (!trainee.getIsDelete()) {
                    trainee.setEmployeeMobileNumber(newMobileNumber);
                    session.update(trainee);
                    message = "trainee updated";
                }
                transaction.commit(); 
      
            } catch (Exception e) {
                    if (transaction != null) 
                        transaction.rollback();
                    e.printStackTrace(); 
            }
        }
        return message;
    }      

    @Override
    public void associateEmployeeById(String employeeId, List<T> employees) {
        
        if(t instanceof Trainer) {
	    
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction(); 
	
            Trainer selectedTrainer = (Trainer)session.get(Trainer.class, employeeId);
              
            selectedTrainer.setTrainees(employees);
            
            session.persist(selectedTrainer);
            transaction.commit(); 
            session.close();
            System.out.println(selectedTrainer.toString());
            logger.info(selectedTrainer.toString());
      
            
        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();   

            Trainee selectedTrainees = session.get(Trainee.class, employeeId);
              
            selectedTrainees.setTrainers(employees  );

            session.persist(selectedTrainees);
            transaction.commit(); 
            session.close();
        }
    } 

    @Override
    public List<T> retriveAssociate(String employeeId) {

        if(t instanceof Trainer) {
            String retriveTrainerQuery = "select trainer.Trainer_Id, trainer.Trainer_Name, trainee.Trainee_Id, trainee.Trainee_Name from link_employee inner join Trainer on trainer.Trainer_Id = link_employee.Trainer_Id inner join Trainee on trainee.Trainee_Id =link_employee.Trainee_Id where Trainer.Trainer_Id = ?";
            List<T> associateEmployee = new ArrayList();
    
            try (Connection connection = JdbcConnection.getConnection();
                 PreparedStatement pst = connection.prepareStatement(retriveTrainerQuery);) {

                 pst.setString(1, employeeId);
                 try (ResultSet resultSet = pst.executeQuery();) {

                      while(resultSet.next()) {
                          Trainer trainers = new Trainer();
                          Trainee trainees = new Trainee();
                          trainers.setEmployeeId(resultSet.getString("Trainer.Trainer_Id"));
                          trainers.setEmployeeName(resultSet.getString("Trainer.Trainer_Name"));
                          associateEmployee.add((T)trainers);
                          trainees.setEmployeeId(resultSet.getString("Trainee.Trainee_Id"));
                          trainees.setEmployeeName(resultSet.getString("Trainee.Trainee_Name"));
                          associateEmployee.add((T)trainees);
                      }
                   }
            } catch(SQLException e) {
                e.printStackTrace();
            }    
            return (List<T>) associateEmployee;   
        } else {
            List<T> associateEmployee = new ArrayList();
            String retriveTrainerQuery = "select trainer.Trainer_Id, trainer.Trainer_Name, trainee.Trainee_Id, trainee.Trainee_Name from link_employee inner join Trainer on trainer.Trainer_Id = link_employee.Trainer_Id inner join Trainee on trainee.Trainee_Id =link_employee.Trainee_Id where Trainee.Trainee_Id = ?";
            try (Connection connection = JdbcConnection.getConnection();
                 PreparedStatement pst = connection.prepareStatement(retriveTrainerQuery);) {

                 pst.setString(1, employeeId);
                 try (ResultSet resultSet = pst.executeQuery();) {

                      while(resultSet.next()) {
                          Trainer trainers = new Trainer();
                          Trainee trainees = new Trainee();
                          trainers.setEmployeeId(resultSet.getString("Trainer.Trainer_Id"));
                          trainers.setEmployeeName(resultSet.getString("Trainer.Trainer_Name"));
                          associateEmployee.add((T)trainers);
                          trainees.setEmployeeId(resultSet.getString("Trainee.Trainee_Id"));
                          trainees.setEmployeeName(resultSet.getString("Trainee.Trainee_Name"));
                          associateEmployee.add((T)trainees);
                      }
                  }
            } catch(SQLException e) {
                e.printStackTrace();
            }    
            return (List<T>) associateEmployee;
        }                 
    }
}
