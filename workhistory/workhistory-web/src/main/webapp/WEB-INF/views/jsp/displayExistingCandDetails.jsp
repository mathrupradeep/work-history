<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Display existing  Candidate Details</title>
</head>
<body>
<br> Thanks for coming back! Here are the details entered by you.
    <div>
         <table>
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>DOB</th>
                    <th>Prev Employeer</th>
                    <th>Employee Id</th>
                    <th>Joining date</th>
                    <th>Reliving date</th>
                    <th>Designation</th>
                    <th>CTC</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> ${existingCandDetails.firstName}</td>
                    <td> ${existingCandDetails.lastName}</td>
                    <td> ${existingCandDetails.birthDate} </td>
                    <td> ${existingCandEmpDetails.approverCompany.regCompanyName} </td>
                    <td> ${existingCandEmpDetails.employeeId}  </td>
                    <td>  ${existingCandEmpDetails.joiningDate} </td>
                     <td> ${existingCandEmpDetails.relievingDate} </td>
                      <td>${existingCandEmpDetails.designation} </td>
                       <td> ${existingCandEmpDetails.salary} </td>
                </tr>
            </tbody>
         </table>
    </div>
</body>
<%@ include file="logout.jsp" %>
</html>