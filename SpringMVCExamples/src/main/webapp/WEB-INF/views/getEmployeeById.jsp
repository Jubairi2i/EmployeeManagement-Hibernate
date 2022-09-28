<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <h1>Employee</h1>
        <form:form action="getEmployeeById" >
            <table align="center">
                  <tr>
                  <td>${employee.employeeId}</td>
                  <td>${employee.employeeName}</td>
                  <td>${employee.employeeMobileNumber}</td>
                  </tr>
            </table>
        </form:form>