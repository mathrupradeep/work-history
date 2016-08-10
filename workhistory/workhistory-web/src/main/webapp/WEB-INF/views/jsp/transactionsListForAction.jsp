<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<title>Transactions by Status</title>
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
<body>
<div class="wrapper">
	<h3><strong>Pending Transactions</strong></h3>

    <form name="requestInitatorForm" method="post">
    	<c:if test="${not empty lists}">
		
		<table class="table table-bordered table-condensed">
            <thead>
                <tr>
                    <th>Transaction</th>
                    <th>Employee Id</th>
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
				<td><input type="checkbox" name="transactionIds" value="${listValue.id}">${listValue.id}<br>
				<input type="hidden" name="requestQueueIds" value="${listValue.requestQueue.id}"></td>
				<td>${listValue.requestQueue.employeeId}</td>
				<td>${listValue.requestQueue.user.firstName} ${listValue.requestQueue.user.lastName}</td>
				<td>${listValue.requestQueue.joiningDate}</td>
				<td>${listValue.requestQueue.relievingDate}</td>
				<td>${listValue.requestQueue.designation}</td>
				<td>${listValue.requestQueue.salary}</td>
			</tr>	
			</tbody>	
			</c:forEach>
		</table>
	   <input type="submit" value="Approve" onclick="submitApprovedTransaction()" class="btn btn-primary">
	   <input type="submit" value="Reject" onclick="submitRejectedTransaction()" class="btn btn-primary">
	</c:if>
     <c:if test="${empty lists}">
        <h4>No records Found</h4>	
     </c:if>
	</form>
</div>
</body>
<script>
function submitApprovedTransaction() {
   	document.forms[0].action = "${pageContext.request.contextPath}/submitApprovedTransaction";
    document.forms[0].submit();
    } 
    
function submitRejectedTransaction() {
   	document.forms[0].action = "${pageContext.request.contextPath}/submitRejectedTransaction";
    document.forms[0].submit();
    } 
</script>
<%@ include file="logout.jsp" %>
<%@ include file="dashboardLink.jsp" %>
</html>