<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<form:form modelAttribute="employees" action="getAllEmployees" method="get" >
<table border="2" width="70%" cellpadding="2">
<tr><th>Employee_Id</th><th>Employee_Name</th><th>Mobile_Number</th><th>Date_Of_Join</th></tr>
   <c:forEach var="employees" items="${employees}">
   <tr>
   <td>${employees.employeeId}</td>
   <td>${employees.employeeName}</td>
   <td>${employees.employeeMobileNumber}</td>
   <td>${employees.employeeDateOfJoin}</td>
   </tr>
   </c:forEach>
   </table>
   </form:form>
   <br/>
   <a href="index.jsp">Home</a>
