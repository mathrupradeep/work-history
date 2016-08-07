<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.logoutLblPos{
   position: absolute;
   right:10px;
   top:15px;
}
</style>
</head>
<body>
  <label class="logoutLblPos">
   <input type="submit" value="Logout" class="btn btn-primary" onclick="logout()">
  </label>
</body>
<script>
function logout(){
	document.forms[0].action = "${pageContext.request.contextPath}/logout";
	document.forms[0].submit();
}

</script>
</html>