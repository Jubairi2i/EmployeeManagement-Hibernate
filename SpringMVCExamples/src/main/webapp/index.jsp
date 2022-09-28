<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
     <h3>!WELCOME TO EMPLOYEE MANAGEMENT PORTAL!</h3><br>

     <form action = "EmployeeForm">
          <tr>

               <td>
                 <label for="employeeRoll">Employee Roll to Add :</label>
                               <select name="employeeRoll">
                                 <option value="Trainer">Trainer</option>
                                 <option value="Trainee">Trainee</option>
                               </select>

               </td>
                 <button>VIEW</button>
          </tr>
          </form><br><br>

     <form action = "GetAllEmployeesForm">
     <tr>

          <td>
            <label for="employeeRoll">Employee Roll to VIEW :</label>
                          <select name="employeeRoll">
                            <option value="Trainer">Trainer</option>
                            <option value="Trainee">Trainee</option>
                          </select>

          </td>
            <button>VIEW</button>
     </tr>
     </form><br><br>
     <form action = "GetEmployeeById">
     <tr>
         <td>
            <label for="employeeRoll">Employee Roll to VIEW :</label>
                  <select name="employeeRoll">
                   <option value="Trainer">Trainer</option>
                   <option value="Trainee">Trainee</option>
                  </select><br>
         </td>
     </tr>
     <tr>
         <td>
           Enter Employee Id :
         </td>
         <td>
            <input type="text" name="employeeId" placeholder="Enter an Id to view"><br>
         </td>
         <button>Find</button><br><br>
     </tr>
     </form>
     <form action = "UpdateMobileNumberById">
          <tr>
              <td>
                 <label for="employeeRoll">Employee Roll to Update :</label>
                       <select name="employeeRoll">
                        <option value="Trainer">Trainer</option>
                        <option value="Trainee">Trainee</option>
                       </select><br><br>
              </td>
          </tr>
          <tr>
              <td>
                Enter Employee Id :
              </td>
              <td>
                 <input type="text" name="employeeId" placeholder="Enter an Id to view"><br><br>
              </td>

          </tr>
          <tr>
              <td>
                Enter Employee Mobile Number :
              </td>
              <td>
                 <input type="text" name="mobileNumber" placeholder="Enter Mobile Number"><br>
              </td>
              <button>Find</button><br><br>
          </tr>
          </form>
          <form action = "DeleteEmployeeById">
               <tr>
                   <td>
                               <label for="employeeRoll">Employee Roll to Delete :</label>
                                     <select name="employeeRoll">
                                      <option value="Trainer">Trainer</option>
                                      <option value="Trainee">Trainee</option>
                                     </select><br>
                            </td><br>
               </tr>
               <tr>
                   <td>
                     Enter Employee Id :
                   </td>
                   <td>
                      <input type="text" name="employeeId" placeholder="Enter an Id to view"><br>
                   </td>
                   <button>Find</button>
               </tr>
               </form>

               <form action = "AssociateEmployee">

                <tr>
                  <td>
                    <label for="employeeRoll">Employee Roll to Associate :</label>
                         <select name="rollToAssociate">
                           <option value="associateTraineesToTrainer">Associate Trainees To Trainer</option>
                           <option value="associateTrainersToTrainee">Associate Trainers To Trainee</option>
                         </select><br>
                  </td><br>
                </tr>
                <tr>
                    <td>
                      Enter Employee Id :
                    </td>
                    <td>
                       <input type="text" name="employeeId" placeholder="Enter an Id to Associate"><br>
                    </td>
                </tr>
                <tr>
                 <td>
                  Enter Employee Id :
                </td>
                <td>
                 <input type="text" name="listOfEmployeeIds" placeholder="Enter an Ids after comma(,)"><br>
                </td>
                        <button>Find</button>
                </tr>
               </form><br><br>

</body>
</html>