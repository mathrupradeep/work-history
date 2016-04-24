<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Candidate Details</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
</head>
<body>

<form name="candidateForm" method="get">
</br>

<h3>
	First Name &nbsp;<input type="text" name="firstname"> <br>
	Last Name  &nbsp; <input type="text" name="lastname"> <br>
	DOB  &nbsp; <input type="calendar" name="dob"> <br>
	Primary Phone Number &nbsp; <input type="text" name="primaryphonenumber">  // "i"  if the number is incorrect, contact HR1  <br> 
	Select the most recent previous employer &nbsp <input type="text" name="mrpemployer" >  //drop down box  <br> 
    EMP ID  &nbsp; <input type="text" name="empid"> <br>
	Joining Date  &nbsp; <input type="text" id="datepicker" name="joiningdate"> <br>
	Relieving Date &nbsp; <input type="text" id="datepicker" name="relievingdate"> <br>
	Upload Relieving letter in pdf format &nbsp; <input type="" name="rletterpdf" >  // file upload option  </br>
   </br>
   <input type="submit" value="Submit" onclick=prompt("info once submited cant be edited")>
   <input type="reset" value="Clear">
</h3>
</form>


</body>
</html>