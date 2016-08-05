<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard for HR</title>
</head>
<body>
    <form>
        <input type="submit" value="Add Candidate" onclick="addCandidate()">
        <input type="submit" value="Request Queue" onclick="requestQueue()">
        <input type="submit" value="Report" onclick="openAllTransactions()">
        <input type="submit" value="Pending Approval" onclick="verificationQueue()">
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