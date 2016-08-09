<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<title>Pending Transactions</title>
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
	<h3><strong>Transaction History</strong></h3>
	<form name="requestInitatorForm" method="post">
    <input type="submit" value="All Transactions" onclick="openAllTransactions()" class="btn btn-primary">
    <input type="submit" value="Pending Transactions" onclick="getAllPendingTransactions()" class="btn btn-primary">
    <input type="submit" value="Approved Transactions" onclick="getAllApprovedTransactions()" class="btn btn-primary">
    <input type="submit" value="Rejected Transactions" onclick="getAllRejectedTransactions()" class="btn btn-primary">
    
	<c:if test="${not empty lists}">	
		<table class="table table-bordered table-condensed">
			<thead>
                <tr>
                    <th>Transaction Id</th>
                    <th>Candidate Name</th>
                    <th>Transaction Status</th>
                    <th>Joining Date</th>
                    <th>Reliving date</th>
                    <th>Designation</th>
                    <th>CTC</th>
                </tr>
            </thead>
            
		<c:forEach var="listValue" items="${lists}">
			<tbody>
			    <tr>
			    <td>${listValue.id}</td>
				<td>${listValue.requestQueue.user.firstName} ${listValue.requestQueue.user.lastName}</td>
				<td>${listValue.status}</td>
				<td>${listValue.requestQueue.joiningDate}</td>
				<td>${listValue.requestQueue.relievingDate}</td>
				<td>${listValue.requestQueue.designation}</td>
				<td>${listValue.requestQueue.salary}</td>
			   </tr>
			</tbody>
		</c:forEach>
			
		</table>	
	</c:if>
     <c:if test="${empty lists}">
     <br>
     <br>
    	<h4>No records Found</h4>
     </c:if>
	</form>
</div>
</body>
<script>
function openAllTransactions() {
    document.forms[0].action = "${pageContext.request.contextPath}/listTransactions";
    document.forms[0].submit();
}
function getAllApprovedTransactions() {
    document.forms[0].action = "${pageContext.request.contextPath}/listAllApprovedTransactions";
    document.forms[0].submit();
}
function getAllRejectedTransactions() {
    document.forms[0].action = "${pageContext.request.contextPath}/listAllRejectedTransactions";
    document.forms[0].submit();
}
function getAllPendingTransactions() {
    document.forms[0].action = "${pageContext.request.contextPath}/listAllPendingTransactions";
    document.forms[0].submit();
}
</script>
<%@ include file="logout.jsp" %>
<%@ include file="dashboardLink.jsp" %>
</html>