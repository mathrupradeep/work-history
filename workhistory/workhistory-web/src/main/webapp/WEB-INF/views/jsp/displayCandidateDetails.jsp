<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>display Candidate Details</title>
<link rel="stylesheet"
    href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
</head>
<body>

	<div>
		<c:if test="${not empty msg}">
             ${msg}
        </c:if>
	</div>
	 
	 <br>
	 Below is the data from objects
	 <br>
	 
	 ${dispCandDetails.employeeId}
	 ${dispCandDetails.salary}
	 
	 
</body>
</html>