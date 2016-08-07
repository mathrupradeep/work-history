<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Initiate Request</h2>

	<c:if test="${not empty lists}">
		<form name="requestInitatorForm" method="post">
		<ul>
			<c:forEach var="listValue" items="${lists}">
				<input type="checkbox" name="requestQueueIds" value="${listValue.id}">${listValue.id}<br>
			</c:forEach>
		</ul>
	   <input type="submit" value="Submit" onclick="submitrequestInitatorForm()">
       <input type="reset" value="Clear">
	</c:if>
     <c:if test="${empty lists}">
     	No records Found
     </c:if>
	</form>
</body>
<script>
function submitrequestInitatorForm() {
   	document.forms[0].action = "${pageContext.request.contextPath}/submitrequestInitator";
    document.forms[0].submit();
} 
</script>
<%@ include file="logout.jsp" %>
</html>