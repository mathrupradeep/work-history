<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>Candidate Details</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
    .wrapper {
        margin: 20px auto;
    }
    	body {
			background: #ececec;
		}
</style>

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

        <form name="candidateForm" method="post" id="candidateForm" class="form-horizontal">
		<div>
			<c:if test="${not empty msg}">
				 ${msg}
			</c:if>
		</div>
	    <div>
            <h2 class="col-md-10">Please Enter Your Details</h2>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label">First Name</label>
                <div class="col-md-7">
                    <input type="text" name="firstName" class="form-control" placeholder="First Name"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label">Last Name</label>
                <div class="col-md-7">
                    <input type="text" name="lastName" class="form-control" placeholder="Last Name"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label">DOB</label>
                <div class="col-md-7">
                    <input type="text" name="DOB" id="DOBSelector" class="form-control"  placeholder="Date"  />
                </div>
            </div>
        </div>
       <!-- Manju should do -->
       
       
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label">Select the previous employer</label>
                <div class="col-md-7">
                    <select class="form-control" name="previousEmployer">
                        <c:forEach var="listValue" items="${CandidateCompany}">
                            <option name="previousEmployer" value="${listValue.id}">${listValue.regCompanyName}<br>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>		

    		<!-- <INPUT type="button" value="Add Row" onclick="addRow('compDetails')" />  
    <INPUT type="button" value="Delete Row" onclick="deleteRow('compDetails')" /> 
   <table id="compDetails">
    <tr>
    -->
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label">EMP ID</label>
                <div class="col-md-7">
                    <input type="text" name="employeeId" class="form-control" placeholder="EMP ID"  />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label">Joining Date</label>
                <div class="col-md-7">
                    <input type="text" name="joiningDate" id="joiningDate" class="form-control" placeholder="Date" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label"> Relieving Date</label>
                <div class="col-md-7">
                    <input type="text" name="relievingDate" id="relievingDate" class="form-control" placeholder="Date" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label">Designation</label>
                <div class="col-md-7">
                    <input type="text" name="designation" class="form-control" placeholder="Designation"  />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-2 control-label">CTC</label>
                <div class="col-md-7">
                    <input type="text" name="CTC" class="form-control"  placeholder="CTC"  />
                </div>
            </div>
        </div>
			<!-- Upload Relieving letter in PDF format &nbsp; <input type="file" id="relievingLetterPDF"  name="relievingLetterPDF" > </br> </td> -->
			<!-- </tr>
   </table>
    -->
    
         <div>
            <div class="form-actions pull-right col-md-10 col-lg-10">
                 <input type="submit" class="btn btn-primary" value="Submit" onclick="submitCandidateDetails()" />
                 <input type="reset" class="btn btn-primary" value="Clear" />
            </div>
        </div>
    </form>
</body>

<script>

function submitCandidateDetails() {
       	document.forms[0].action = "${pageContext.request.contextPath}/submitCandidateDetails";
        document.forms[0].submit();
}   

</script>
<%@ include file="logout.jsp" %>
</html>     