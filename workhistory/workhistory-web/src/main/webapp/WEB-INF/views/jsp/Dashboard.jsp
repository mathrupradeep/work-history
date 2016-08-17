<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style>
	.wrapper {
		margin: 40px auto;
	}
</style>
<title>Dashboard</title>
</head>
<body style="background: #ececec" class="wrapper">
	<div>
	   <c:if test="${not empty msg}">
          <label>${msg}</label>
	  </c:if>
	</div>
	
	<c:if test="${not empty firstName}">
		<div><h3>Welcome ${firstName}!</h3></div>
	</c:if>
	<br>
    <div>
	    <form class="form-horizontal">
	    	<div class="form-group col-md-12">
	        <input type="submit" class="btn btn-primary" value="Add Candidate" onclick="addCandidate()">
	        <input type="submit" class="btn btn-primary" value="Request Queue(${queueSize})" onclick="requestQueue()">
	        <input type="submit" class="btn btn-primary" value="Transaction History" onclick="openAllTransactions()">
	        <input type="submit" class="btn btn-primary"  value="Pending Approval(${transactionListSize})" onclick="verificationQueue()">
	        </div>
	    </form>
    </div>
</body>

<script>
    function addCandidate() {
        document.forms[0].action = "${pageContext.request.contextPath}/addCandidate";
        document.forms[0].submit();
    }
    
    function requestQueue() {
        document.forms[0].action = "${pageContext.request.contextPath}/initiateRequest";
        document.forms[0].submit();
    }
    
    function openAllTransactions() {
        document.forms[0].action = "${pageContext.request.contextPath}/listTransactions";
        document.forms[0].submit();
    }
    
    function verificationQueue() {
        document.forms[0].action = "${pageContext.request.contextPath}/listTransactionsForAction";
        document.forms[0].submit();
    }
</script>
<%@ include file="logout.jsp" %>
</html>