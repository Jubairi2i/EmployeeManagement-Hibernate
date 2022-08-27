

import java.util.Scanner;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import com.i2i.entity.Trainer;
import com.i2i.entity.Trainee;
import com.i2i.dto.Employee;
import com.i2i.dto.TrainerDto;
import com.i2i.dto.TraineeDto;
import com.i2i.hibernateUtil.HibernateUtil;
import com.i2i.dao.impl.EmployeeDaoImpl;
import com.i2i.dao.IEmployeeDao;
import com.i2i.service.impl.EmployeeServiceImpl;
import com.i2i.service.IEmployeeService;
import com.i2i.util.EmployeeUtil;
import com.i2i.jdbcConnection.JdbcConnection;
import com.i2i.exception.ElementNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeController {
    
    private IEmployeeService<TrainerDto> trainerDtoService = new EmployeeServiceImpl(new TrainerDto());
    private IEmployeeService<TraineeDto> traineeDtoService = new EmployeeServiceImpl(new TraineeDto());
    private Scanner scan = new Scanner(System.in);
    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    
    public static void main(String[] args) {

        EmployeeController employeeController = new EmployeeController();
        employeeController.init();
       
    }
    public void init(){
        
        boolean flag = true;
	while(flag) {
            logger.info("Welcome to Ideas2IT Employee management portal!!");
            logger.info("Please enter one of the below options to proceed further.");
	    logger.info("Enter 1 for Add Trainer \nEnter 2 for Add Trainee \nEnter 3 for Remove");
            logger.info("Enter 4 for Update \nEnter 5 Associate \nEnter 6 for Display \nEnter 7 for Display Associate \nEnter 8 for Exit");
            int userInput = scan.nextInt();
            switch (userInput) {
               case 1:
                   addEmployee(1);
                   break;

               case 2:
                   addEmployee(2);
                   break;

               case 3:
                   logger.info("Enter 1 to remove Trainer \nEnter 2 to remove trainee");
                   int InputToRemove = scan.nextInt();
                   scan.nextLine();
                   switch (InputToRemove) {
                       case 1:
                           try {
                               removeTrainerById();
                           } catch(ElementNotFoundException e) {
                               logger.error("exception occured " + e);
                           }
                           break;
                       case 2:
                           try {
                               removeTraineeById();
                           } catch(ElementNotFoundException e) {
                               logger.error("exception occured "+ e);
                           }
                           break;
                   }
                   break;
                case 4:
                    logger.info("Enter 1 for update Trainer and 2 for update Trainee");
                    int updateInput = scan.nextInt();
                    scan.nextLine();
                    switch (updateInput) {
                        case 1:
                            logger.info("Enter Employee Id");
                            String trainerId = scan.nextLine();
                            logger.info("Enter Employee Mobile Number");
                            long trainerMobileNumber = scan.nextLong();
                            logger.info(updateTrainerById(trainerId, trainerMobileNumber));
                            break;
                        case 2:
                            logger.info("Enter Employee Id");
                            String traineeId = scan.nextLine();
                            logger.info("Enter Employee Mobile Number");
                            long traineeMobileNumber = scan.nextLong();
                            logger.info(updateTraineeById(traineeId, traineeMobileNumber));
                            break;
                    }
                    break;
                case 5:
                    logger.info("Enter 1 for Associate Trainer for Trainees");
                    logger.info("Enter 2 for Associate Trainee for Trainers");
                    int associateInput = scan.nextInt();
                    scan.nextLine();
                    switch (associateInput) {
                        case 1:
                            updateAssociate(1);
                            break;
                        case 2:
                            updateAssociate(2);
                            break;
                    }
                    break;
                case 6:
                   logger.info("Enter 1 for get all or Enter 2 for get by Id ");
                   int inputForDisplay = scan.nextInt();
                   switch (inputForDisplay) {
                       case 1:
                           logger.info("Enter 1 for get all Trainer or Enter 2 for get all Trainee");
                           int inputForDisplayAll = scan.nextInt();
                           switch (inputForDisplayAll) {
                               case 1:
                                   displayAllTrainers();
                                   break;
                               case 2:
                                   displayAllTrainees();
                                   break;
                     }
                     break;

                       case 2:
                           logger.info("Enter 1 for Trainer and Enter 2 for Trainee ");
                           int inputForDisplayById = scan.nextInt();
                           scan.nextLine();
                           switch (inputForDisplayById) {
                               case 1:
                                   logger.info("Enter Employee Id");
                                   String trainerId = scan.nextLine();
                                   displayTrainerById(trainerId);
                                   break;

                               case 2:
                                   logger.info("Enter Employee Id");
                                   String traineeId = scan.nextLine();
                                   displayTraineeById(traineeId);
                                   break;
                             }
                             break;
                     }
                     break;
               case 7:
                   logger.info("Enter 1 for Display associate for Trainer \nEnter 2 for Display associate for Trainee");
                   int inputDisplayAssociate = scan.nextInt();
                   scan.nextLine();
                   switch(inputDisplayAssociate) {
                   case 1:
                       displayAssociateTrainersById();
                       break;
                   case 2:
                       displayAssociateTraineesById();
                       break;
                   }
                   break;
               case 8:
                   flag = false;  
                   break;
               default:
                   logger.info("Enter valid input");
                   break;
            }  
        }    
    }
    
    public void addEmployee(int userInput) {

        scan.nextLine();
	logger.info("Enter your Name: ");
	String employeeName = scan.nextLine();    
        String employeeId = EmployeeUtil.getGeneratedId();    
	logger.info("Enter your Date of Birth in YYYY-MM-DD: ");
	String DateOfBirth = scan.nextLine();
        LocalDate employeeDateOfBirth = LocalDate.parse(DateOfBirth);
        logger.info("Enter your Date of Joining in YYYY-MM-DD: ");
        String DateOfJoining = scan.nextLine();
        LocalDate employeeDateOfJoining = LocalDate.parse(DateOfJoining);
        logger.info("Enter your Mobile Number: ");
	long employeeMobileNumber = scan.nextLong();

        if(userInput == 1) {
            TrainerDto trainer = new TrainerDto();
            trainer.setEmployeeName(employeeName);
            trainer.setEmployeeDateOfBirth(employeeDateOfBirth);
            trainer.setEmployeeDateOfJoining(employeeDateOfJoining);
            trainer.setEmployeeId(employeeId);
            trainer.setEmployeeMobileNumber(employeeMobileNumber);
            trainerDtoService.addEmployee(trainer);
        } else {
            TraineeDto trainee = new TraineeDto();
            trainee.setEmployeeName(employeeName);
            trainee.setEmployeeDateOfBirth(employeeDateOfBirth);
            trainee.setEmployeeDateOfJoining(employeeDateOfJoining);
            trainee.setEmployeeId(employeeId);
            trainee.setEmployeeMobileNumber(employeeMobileNumber);
            traineeDtoService.addEmployee(trainee);
        }
    }

    public void displayTrainerById(String employeeId) {
        TrainerDto trainer = trainerDtoService.getEmployeeById(employeeId);
        logger.info(trainer.toString());
    }
  
    public void displayTraineeById(String employeeId) {
        TraineeDto trainee = traineeDtoService.getEmployeeById(employeeId);
        logger.info(trainee.toString());
    }

    public void displayAssociateTrainersById() {
        logger.info("Enter Trainer Id");
        String trainerId = scan.nextLine();
        for (Employee employee : trainerDtoService.getAssociateEmployeeById(trainerId)){
		if( employee instanceof TrainerDto) {
        	    logger.info(employee.toString());
		} else {
	            logger.info(employee.toString());
		}
	}
    }

    public void displayAssociateTraineesById() {
        logger.info("Enter Trainee Id");
        String traineeId = scan.nextLine();
        for (Employee employee : traineeDtoService.getAssociateEmployeeById(traineeId)){
		if( employee instanceof TraineeDto) {
        	    logger.info(employee.toString());
		} else {
	            logger.info(employee.toString());
		}
	}
    }

    public void displayAllTrainers() {
	
        for(TrainerDto trainer : trainerDtoService.getAllEmployees()) {
            logger.info(trainer.toString());
        }
    }  

    public void displayAllTrainees() {

         for(TraineeDto trainee : traineeDtoService.getAllEmployees()) {
            logger.info(trainee.toString()); 
         }
    }

    public void removeTrainerById() throws ElementNotFoundException {
        logger.info("Enter the Trainer Id you want to remome");
        String trainerIdToRemove = scan.nextLine();
        if (trainerDtoService.getEmployeeById(trainerIdToRemove) == null) {
            throw new ElementNotFoundException("It doesn't have any Data");
        } else {
            trainerDtoService.removeEmployeeById(trainerIdToRemove);
        }
    }

    public void removeTraineeById() throws ElementNotFoundException {
        logger.info("Enter the Trainee Id you want to remome");
        String traineeIdToRemove = scan.nextLine();

        if (traineeDtoService.getEmployeeById(traineeIdToRemove) == null) {
            throw new ElementNotFoundException("It doesn't have any Data");
        } else {
            traineeDtoService.removeEmployeeById(traineeIdToRemove);
        }
    }

    public String updateTrainerById(String employeeId, long mobileNumber) {
        return trainerDtoService.updateEmployeeById(employeeId, mobileNumber);
    }

    public String updateTraineeById(String employeeId, long mobileNumber) {
        return traineeDtoService.updateEmployeeById(employeeId, mobileNumber);
    }
    
    public void updateAssociate(int userInput) {
        if (userInput == 1) {

            logger.info("Enter trainer Id");
            String trainerId = scan.nextLine();
           
            logger.info("Enter Trainee Ids after comma to associate");
            String[] traineeIds = scan.nextLine().split(",");
            List<TraineeDto> trainees = new ArrayList<>();
            for (String traineeId : traineeIds) {
                TraineeDto trainee = traineeDtoService.getEmployeeById(traineeId);
                trainees.add(trainee);
            }
            
            trainerDtoService.associateEmployeeById(trainerId, trainees);
        } else {
           
            logger.info("Enter trainee Id");
            String traineeId = scan.nextLine();
            
            logger.info("Enter Trainer Ids after comma to associate");
            String[] trainerIds = scan.nextLine().split(",");
            List<TrainerDto> trainers = new ArrayList<>();
            for (String trainerId : trainerIds) {
                TrainerDto trainer = trainerDtoService.getEmployeeById(trainerId);
                trainers.add(trainer);
            }
            traineeDtoService.associateEmployeeById(traineeId, trainers);
        }
    }
}
