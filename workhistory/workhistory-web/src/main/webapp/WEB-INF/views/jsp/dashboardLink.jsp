<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout </title>
<style>
.dashboardLblPos{
   position: absolute;
   right:90px;
   top:15px;
}
</style>
</head>
<body>
  <label class="dashboardLblPos">
   <input type="submit" value="Dashboard" class="btn btn-primary" onclick="dashboard()">
  </label>
</body>
<script>
function dashboard(){
	document.forms[0].action = "${pageContext.request.contextPath}/Dashboard";
	document.forms[0].submit();
}

</script>
</html>