<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>display Candidate Details</title>
</head>
<body>

	<br> Below is the data from objects
	<br> First Name :  ${dispCandDetails.firstName} <br>
	Last Name :  ${dispCandDetails.lastName} <br>
	DOB     : {existingCandDetails.birthDate} <br>
    Previous employer : ${dispCandEmpDetails.approverCompany.regCompanyName}<br>
	EMP ID :  ${dispCandEmpDetails.employeeId} <br>
	Joining Date :  ${dispCandEmpDetails.joiningDate} <br>
	Relieving Date :  ${dispCandEmpDetails.relievingDate} <br>
	Designation :  ${dispCandEmpDetails.designation} <br>
	CTC  : {dispCandEmpDetails.salary} <br>

</body>
</html>