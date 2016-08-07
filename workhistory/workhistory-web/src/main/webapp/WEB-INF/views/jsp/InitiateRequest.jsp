<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style>
		.wrapper {
			width: 80%;
			margin: 0 auto;
		}
		
		.table td {
			text-align: center;
			background: #fff;
		}
		
		body {
			background: #ececec;
		}
		
	</style>
</head>
<body>
	<div class="wrapper">
	<h2>Initiate Request</h2>

	<c:if test="${not empty lists}">
		<form name="requestInitatorForm" method="post">
			<table class="table table-bordered table-condensed">
            <thead>
                <tr>
                    <th>Request</th>
                    <th>Previous Employer</th>
                    <th>Emp Id</th>
                    <th>Candidate Name</th>
                    <th>Joining Date</th>
                    <th>Reliving date</th>
                    <th>Designation</th>
                    <th>CTC</th>
                </tr>
            </thead>
           <c:forEach var="listValue" items="${lists}">
            <tbody>
                 <tr>
                    <td><input type="checkbox" name="requestQueueIds" value="${listValue.id}"></td>
                    <td> ${listValue.approverCompany.regCompanyName}</td>
                    <td> ${listValue.employeeId} </td>
                    <td> ${listValue.user.firstName} ${listValue.user.lastName} </td>
                    <td> ${listValue.joiningDate}  </td>
                    <td> ${listValue.relievingDate} </td>
                    <td> ${listValue.designation} </td>
                    <td> ${listValue.salary} </td>
                </tr>
            </tbody>
            </c:forEach>
         </table>
		<%-- <ul>
			<c:forEach var="listValue" items="${lists}">
				<li><input type="checkbox" name="requestQueueIds" value="${listValue.id}">${listValue.id},${listValue.approverCompany.regCompanyName},${listValue.employeeId},
				${listValue.user.firstName} ${listValue.user.lastName}, ${listValue.joiningDate},${listValue.relievingDate},${listValue.designation}</li>
			</c:forEach>
		</ul> --%>
	   <input type="submit" value="Submit" class="btn btn-primary" onclick="submitrequestInitatorForm()">
       <input type="reset" class="btn btn-primary" value="Clear">
	</c:if>
     <c:if test="${empty lists}">
     	No records Found
     </c:if>
	</form>
	
</div>
</body>
<script>
function submitrequestInitatorForm() {
   	document.forms[0].action = "${pageContext.request.contextPath}/submitrequestInitator";
    document.forms[0].submit();
} 
</script>
<%@ include file="logout.jsp" %>
</html>