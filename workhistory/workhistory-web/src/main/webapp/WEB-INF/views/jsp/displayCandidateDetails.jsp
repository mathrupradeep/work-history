<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Display Candidate Details</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
    .wrapper {
        margin: 20px auto;
    }
    	body {
			background: #ececec;
		}
	.table td {
			text-align: center;
			background: #fff;
		}
</style>
</head>
<body>

<div class="container">
    <div class="wrapper">
        <div> 
            <label class="col-md-7"> Thanks for your time! <br> Here are the details entered by you: </label> <br>
        </div>
        <form name="authForm" ng-controller="authCtrl" method="post" id="loginForm" class="form-horizontal">
        <div>
             <table class="table table-bordered table-condensed"">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>DOB</th>
                        <th>Previous Employer</th>
                        <th>Employee Id</th>
                        <th>Joining date</th>
                        <th>Relieving date</th>
                        <th>Designation</th>
                        <th>CTC</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> ${dispCandDetails.firstName}</td>
                        <td> ${dispCandDetails.lastName}</td>
                        <td> ${dispCandDetails.birthDate} </td>
                        <td> ${dispCandEmpDetails.approverCompany.regCompanyName} </td>
                        <td> ${dispCandEmpDetails.employeeId}  </td>
                        <td> ${dispCandEmpDetails.joiningDate} </td>
                        <td> ${dispCandEmpDetails.relievingDate} </td>
                        <td> ${dispCandEmpDetails.designation} </td>
                        <td> ${dispCandEmpDetails.salary} </td>
                    </tr>
                </tbody>
             </table>
        </div>
        </form>     
    </div>
</div>
</body>
<%@ include file="logout.jsp" %>
</html>