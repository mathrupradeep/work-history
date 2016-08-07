<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<div><h3 class="col-md-2 control-label">Welcome ${firstName}!</h3></div>
    <form class="form-horizontal">
    	<div class="form-group col-md-12">
        <input type="submit" class="btn btn-primary" value="Add Candidate" onclick="addCandidate()">
        <input type="submit" class="btn btn-primary" value="Request Queue" onclick="requestQueue()">
        <input type="submit" class="btn btn-primary" value="Transaction History" onclick="openAllTransactions()">
        <input type="submit" class="btn btn-primary"  value="Pending Approval" onclick="verificationQueue()">
        </div>
    </form>
</body>

<script>
    function addCandidate() {
        document.forms[0].action = "${pageContext.request.contextPath}/addCandidate";
        document.forms[0].submit();
    }
    
    //action path needs to be set 
    function requestQueue() {
        document.forms[0].action = "${pageContext.request.contextPath}/initiateRequest";
        document.forms[0].submit();
    }
    
    //action path needs to be set
    function openAllTransactions() {
        document.forms[0].action = "${pageContext.request.contextPath}/listTransactions";
        document.forms[0].submit();
    }
    
    //action path needs to be set
    function verificationQueue() {
        document.forms[0].action = "${pageContext.request.contextPath}/listTransactionsForAction";
        document.forms[0].submit();
    }
</script>
<%@ include file="logout.jsp" %>
</html>