<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>display existing  Candidate Details</title>
</head>
<body>

    
    <br> Below is the data from objects
    <br> First Name :  ${existingCandDetails.firstName} <br>
    Last Name :  ${existingCandDetails.lastName} <br>
    DOB     : {existingCandDetails.birthDate} <br>
    Previous employer : ${existingCandEmpDetails.approverCompany.regCompanyName}<br>
    EMP ID :  ${existingCandEmpDetails.employeeId} <br>
    Joining Date :  ${existingCandEmpDetails.joiningDate} <br>
    Relieving Date :  ${existingCandEmpDetails.relievingDate} <br>
    Designation :  ${existingCandEmpDetails.designation} <br>
    CTC  : {existingCandEmpDetails.salary} <br>


</body>
</html>