<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="get" action=" ">
</br>
<h3>
	First Name &nbsp;<input type="text" name="firstname"> <br>
	Last Name  &nbsp; <input type="text" name="lastname"> <br>
	DOB  &nbsp; <input type="calendar" name="dob"> <br>
	Primary Phone Number &nbsp; <input type="text" name="primaryphonenumber">  // "i"  if the number is incorrect, contact HR1  <br> 
	Select the most recent previous employer &nbsp <input type="text" name="mrpemployer" >  //drop down box  <br> 
    EMP ID  &nbsp; <input type="text" name="empid"> <br>
	Joining Date  &nbsp; <input type="calendar" name="joiningdate"> <br>
	Relieving Date &nbsp; <input type="calendar" name="relievingdate"> <br>
	Upload Relieving letter in pdf format &nbsp; <input type="" name="rletterpdf" >  // file upload option  </br>
   </br>
   <input type="submit" value="Submit" onclick=prompt("info once submited cant be edited")>
   <input type="reset" value="Clear">
</h3>


</body>
</html>