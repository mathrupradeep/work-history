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
$(document).ready(function () {
    $("#imagePic").mouseenter(function () {
        $("#infoElement").show();
    });
    $("#imagePic").mouseleave(function () {
        $("#infoElement").hide();
    });
});

  $(function() {
    $( "#DOBSelector" ).datepicker();
    $( "#joiningDate" ).datepicker();
    $( "#relievingDate" ).datepicker();
    $( "#joiningDate1" ).datepicker();
    $( "#relievingDate1" ).datepicker();
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

<p>
	First Name &nbsp;<input type="text" name="firstName"> <br>
	Last Name  &nbsp; <input type="text" name="lastName"> <br>
	DOB  &nbsp;  <input type="text" id="DOBSelector" name="DOB"> <br>
	Email ID &nbsp; <input type="text" name="mailId"> <div id ="imagePic" > Put an image I here <div id="infoElement" >  if the email id is incorrect, contact HR1 </div> </div>
    Primary Phone Number &nbsp; <input type="text" name="primaryPhoneNumber"> <div id ="imagePic" > Put an image I here <div id="infoElement" >  if the number is incorrect, contact HR1 </div> </div> 
	Select the most recent previous employer &nbsp <input type="text" name="mostRecentEmployer" >  //drop down box  <br><br><br> 
    
   <INPUT type="button" value="Add Row" onclick="addRow('compDetails')" />  
    <INPUT type="button" value="Delete Row" onclick="deleteRow('compDetails')" /> 
   <table id="compDetails">
    <tr>
        <td>    EMP ID  &nbsp; <input type="text" name="employeeId"> <br> </td>
	    <td>    Joining Date  &nbsp; <input type="text" id="joiningDate" name="joiningDate"> <br> </td>
	    <td>    Relieving Date &nbsp; <input type="text" id="relievingDate" name="relievingDate"> <br> </td>
	    <td>    Upload Relieving letter in PDF format &nbsp; <input type="file" id="relievingLetterPDF"  name="relievingLetterPDF" > </br> </td>
   </tr>
   </table>
   <br>
   <br>
   <input type="submit" value="Submit" onclick="submitCandidateDetails()">
   <input type="reset" value="Clear">
</p>
</form>
</body>

<script>
function addRow(compDetails) {
	 
    var table = document.getElementById(compDetails);
    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    var empIdCell = row.insertCell(0);
    empIdCell.innerHTML = empIdCell.innerHTML +' EMP ID <input type="text" name="empId[]"/> ';
    
    var joiningDateCell = row.insertCell(1);
    joiningDateCell.innerHTML = joiningDateCell.innerHTML +' Joining Date <input type="text" id="joiningDate1" name="joiningDate[]"/> ';

    var relievingDateCell = row.insertCell(2);
    relievingDateCell.innerHTML = relievingDateCell.innerHTML +' Relieving Date <input type="text" id="relievingDate1" name="relievingDate[]"/> ';
    
    var relievingLetterCell = row.insertCell(3);
    relievingLetterCell.innerHTML = relievingLetterCell.innerHTML +' Upload Relieving letter in PDF format <input type="file" name="relievingLetterPDF[]"/> ';
    
    /*  var cell3 = row.insertCell(4);
    cell3.innerHTML = cell3.innerHTML +' <input type="text" size="20" name="values[]"/> <INPUT type="button"  class="btn_medium" value="Remove" onclick="this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);" /><br><small><font color="gray">Enter Title</font></small>'; */
 }

 function deleteRow(compDetails) {
    try {
   	      var table = document.getElementById(compDetails);
   	      var rowCount = table.rows.length;
    	  table.deleteRow(--rowCount);
    }
    catch(e) {
        alert(e);
    }
}

function submitCandidateDetails() {
       	document.forms[0].action = "${pageContext.request.contextPath}/submitCandidateDetails";
        document.forms[0].submit();
}   

</script>
</html>     