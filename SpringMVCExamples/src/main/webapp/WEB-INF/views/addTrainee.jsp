<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<body>
   <form:form modelAttribute="employee" action="addTrainee" method="post" >

       <table align="center">

          <tr>
               <td>
                   <form:label path="employeeName">Employee Name</form:label>
               </td>
               <td>
                   <form:input path="employeeName" name="employeeName" id="employeeName" />
               </td>
           </tr>

           <tr>
               <td>
                   <form:label path="employeeMobileNumber">Employee Mobile Number</form:label>
               </td>
               <td>
                   <form:input  path="employeeMobileNumber" name="employeeMobileNumber" id="employeeMobileNumber" />
               </td>
           </tr>

           <tr>
               <td>
                   <form:label path="employeeDateOfBirth">Employee Date Of Birth</form:label>
               </td>
               <td>

                   <form:input type="date" path="employeeDateOfBirth" name="employeeDateOfBirth" id="employeeDateOfBirth" />

               </td>
           </tr>

           <tr>
               <td>
                   <form:label path="employeeDateOfJoin">Employee Date Of Join</form:label>
               </td>
               <td>
                   <form:input type="date" path="employeeDateOfJoin" name="employeeDateOfJoin" id="employeeDateOfJoin" />
               </td>
           </tr>

           <tr>
               <td>
                   <form:button id="SAVE" name="SAVE">SAVE</form:button>
               </td>
           </tr>
           <tr></tr>
       </table>
   </form:form>


</body>
</html>