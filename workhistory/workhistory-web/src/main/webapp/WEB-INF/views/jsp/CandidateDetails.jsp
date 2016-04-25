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
    $( "#DOBSelector" ).datepicker();
    $( "#joiningDate" ).datepicker();
    $( "#relievingDate" ).datepicker();
  });
  </script>
</head>
<body>

<form name="candidateForm" method="post">
</br>

	<div>
		<c:if test="${not empty msg}">
			 ${msg}
		</c:if>
	</div>

<h3>
	First Name &nbsp;<input type="text" name="firstName"> <br>
	Last Name  &nbsp; <input type="text" name="lastName"> <br>
	DOB  &nbsp;  <input type="text" id="DOBSelector" name="DOB"> <br>
	Primary Phone Number &nbsp; <input type="text" name="primaryPhoneNumber">  // "i"  if the number is incorrect, contact HR1  <br> 
	Select the most recent previous employer &nbsp <input type="text" name="mostRecentEmployer" >  //drop down box  <br> 
    EMP ID  &nbsp; <input type="text" name="empId"> <br>
	Joining Date  &nbsp; <input type="text" id="joiningDate" name="joiningDate"> <br>
	Relieving Date &nbsp; <input type="text" id="relievingDate" name="relievingDate"> <br>
	Upload Relieving letter in PDF format &nbsp; <input type="file" id="relievingLetterPDF"  name="relievingLetterPDF" >  // file upload option  </br>
   </br>
   <input type="submit" value="Submit" onclick="submitCandidateDetails()">
   <input type="reset" value="Clear">
</h3>
</form>
</body>
<script>
function submitCandidateDetails() {
	document.forms[0].action = "${pageContext.request.contextPath}/submitCandidateDetails";
	document.forms[0].submit();
}
</script>
</html>