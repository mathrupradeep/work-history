<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Initiate Request</h2>

	<c:if test="${not empty lists}">
		<form name="requestInitatorForm" method="post">
		<ul>
			<c:forEach var="listValue" items="${lists}">
				Transaction ID: ${listValue.id}<br>
				Candidate Name : ${listValue.requestQueue.user.firstName} ${listValue.requestQueue.user.lastName}<br>
				Transaction status : ${listValue.status}<br>
			</c:forEach>
		</ul>
	</c:if>
     <c:if test="${empty lists}">
     	No records Found
     </c:if>
	</form>
</body>
</html>