package com.i2i.Controller;

import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;
import com.i2i.service.IEmployeeService;
import com.i2i.service.impl.EmployeeServiceImpl;
import com.i2i.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class EmployeeController<T extends Employee> {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/EmployeeForm")
    public String showEmployeeForm(Model model, @RequestParam String employeeRoll) {
        if (employeeRoll.equalsIgnoreCase("trainer")) {
            model.addAttribute("employee", new Trainer());
            return "addTrainer";
        } else {
            model.addAttribute("employee", new Trainee());
            return "addTrainee";
        }
    }

    /*@PostMapping(value = "/addTrainer")
    public String addEmployee(@ModelAttribute("employee") T employee) {
        if (employee instanceof Trainer) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.addEmployee(employee);
        }
        return "home";
    }*/

    @PostMapping(value = "/addTrainer")
    public String addTrainer(@ModelAttribute("employee") Trainer trainer) {
        trainer.setEmployeeId(EmployeeUtil.getGeneratedId());
        employeeService.addEmployee(trainer);
        return "home";
    }

    @PostMapping(value = "/addTrainee")
    public String addTrainer(@ModelAttribute("employee") Trainee trainee) {
        trainee.setEmployeeId(EmployeeUtil.getGeneratedId());
        employeeService.addEmployee(trainee);
        return "home";
    }

    @RequestMapping("/GetAllEmployeesForm")
    public String showAllEmployeesForm(Model model, @RequestParam String employeeRoll) {
        if (employeeRoll.equalsIgnoreCase("trainer")) {
            List<Trainer> trainers = employeeService.getAllTrainers();
            model.addAttribute("employees", trainers);
        } else {
            List<Trainee> trainees = employeeService.getAllTrainees();
            model.addAttribute("employees", trainees);
        }
        return "getAllEmployees";
    }

    @RequestMapping(value = "/GetEmployeeById")
    public String showEmployeeById(Model model,@RequestParam("employeeRoll") String employeeRoll, @RequestParam("employeeId") String employeeId) {
        if (employeeRoll.equalsIgnoreCase("trainer")) {
            model.addAttribute("employee", employeeService.getTrainerById(employeeId));
        } else  {
            model.addAttribute("employee", employeeService.getTraineeById(employeeId));
        }
        return "getEmployeeById";
    }

   @RequestMapping(value = "/UpdateMobileNumberById")
   public String updateEmployeeById(Model model,@RequestParam("employeeRoll") String employeeRoll, @RequestParam("employeeId") String employeeId, @RequestParam("mobileNumber") long mobileNumber){
       if (employeeRoll.equalsIgnoreCase("trainer")) {
           Trainer trainer = employeeService.getTrainerById(employeeId);
           trainer.setEmployeeMobileNumber(mobileNumber);
           employeeService.updateEmployee(trainer);
       } else {
           Trainee trainee = employeeService.getTraineeById(employeeId);
           trainee.setEmployeeMobileNumber(mobileNumber);
           employeeService.updateEmployee(trainee);
       }
       return "home";
   }

   @RequestMapping(value = "/DeleteEmployeeById")
    public String deleteEmployeeById(@RequestParam("employeeRoll") String employeeRoll, @RequestParam("employeeId") String employeeId) {
        if (employeeRoll.equalsIgnoreCase("trainer")) {
            Trainer trainer = employeeService.getTrainerById(employeeId);
            trainer.setActivity(true);
            employeeService.updateEmployee(trainer);
        } else {
            Trainee trainee = employeeService.getTraineeById(employeeId);
            trainee.setActivity(true);
            employeeService.updateEmployee(trainee);
        }
       return "home";
   }

   @RequestMapping(value = "/AssociateEmployee")
   public String associateEmployee(@RequestParam("employeeId") String employeeId, @RequestParam("rollToAssociate") String rollToAssociate, @RequestParam("listOfEmployeeIds") String listOfEmployeeIds) {
        if (rollToAssociate.equalsIgnoreCase("associateTraineesToTrainer")){
            Trainer trainer = employeeService.getTrainerById(employeeId);
            String[] employeeIds = listOfEmployeeIds.split("[,]",0);
            Set<Trainee> trainees = new HashSet<>();
            for (String employee : employeeIds) {
                Trainee trainee = employeeService.getTraineeById(employee);
                trainees.add(trainee);
            }
            trainer.setTrainees(trainees);
            employeeService.updateEmployee(trainer);
        } else {
            Trainee trainee = employeeService.getTraineeById(employeeId);
            String[] employeeIds = listOfEmployeeIds.split("[,]", 0);
            Set<Trainer> trainers = new HashSet<>();
            for (String employee : employeeIds) {
                Trainer trainer = employeeService.getTrainerById(employee);
                trainers.add(trainer);
            }
            trainee.setTrainers(trainers);
            employeeService.updateEmployee(trainee);
        }
        return "home";
   }

   @ExceptionHandler(value = NoResultException.class)
    public String exceptionHandler(Model model){
        model.addAttribute("error", "The Id you have entered incorrect Id");
        return "error";
   }

}
