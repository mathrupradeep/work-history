<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" id="loginForm">
<br>
<h3>
		<c:if test="${not empty message}">
			${message}
		</c:if>
login page 
	
	user name &nbsp;<input type="text" name="userName" > <br>
	password &nbsp;<input type="password" name="password" > <br>
   <br>
   <input type="submit" value="Login" onclick="submitLogin()">
   <input type="reset" value="Clear">
</h3>
</form>
</body>
<script>
function submitLogin(){
	document.forms[0].action = "${pageContext.request.contextPath}/submitLoginDetails";
	document.forms[0].submit();
}

</script>
<%@ include file="logout.jsp" %>
</html>