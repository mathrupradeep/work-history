<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Transaction History</h2>
	<form name="requestInitatorForm" method="post">
    <input type="submit" value="All Transactions" onclick="openAllTransactions()">
    <input type="submit" value="Approved Transactions" onclick="getAllApprovedTransactions()">
    <input type="submit" value="Rejected Transactions" onclick="getAllRejectedTransactions()">
	<c:if test="${not empty lists}">		
		<ul>
			<c:forEach var="listValue" items="${lists}">
				Transaction ID: ${listValue.id}<br>
				Candidate Name : ${listValue.requestQueue.user.firstName} ${listValue.requestQueue.user.lastName}<br>
				Transaction status : ${listValue.status}<br>
			</c:forEach>
		</ul>
	</c:if>
     <c:if test="${empty lists}">
     <br>
     <br>
     	No records Found
     </c:if>
	</form>
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
</script>
</html>