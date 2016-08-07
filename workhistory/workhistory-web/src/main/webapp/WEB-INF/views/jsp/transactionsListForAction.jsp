<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Pending Transactions</h2>

	<c:if test="${not empty lists}">
		<form name="requestInitatorForm" method="post">
		<ul>
			<c:forEach var="listValue" items="${lists}">
				<input type="checkbox" name="transactionIds" value="${listValue.id}">${listValue.id}<br>
				<input type="hidden" name="requestQueueIds" value="${listValue.requestQueue.id}">
			</c:forEach>
		</ul>
	   <input type="submit" value="Approve" onclick="submitApprovedTransaction()">
	   <input type="submit" value="Reject" onclick="submitRejectedTransaction()">
	</c:if>
     <c:if test="${empty lists}">
     	No records Found
     </c:if>
	</form>
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
</html>