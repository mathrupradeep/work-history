<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
	.wrapper {
		margin: 20px auto;
	}
</style>
</head>
<body>

<div class="container">
	<div class="wrapper">
				<form name="authForm" ng-controller="authCtrl" method="post" id="loginForm" class="form-horizontal">
<%-- 				   <div class="row">
					<div>
						<label> <c:if test="${not empty message}">
			${message}
		</c:if>
						</label>
					</div>
				</div> --%>
				<div>
					<h2 class="col-md-10">Login to Workhistory</h2>
				</div>
                   <div class="row">
                       <div class="form-group col-md-12">
                           <label class="col-md-2 control-label">Email ID</label>
                           <div class="col-md-7">
                               <input type="email" name="userName" class="form-control" ng-model="email" placeholder="Email" required />
                           </div>
                       </div>
                   </div>
                   <div class="row">
                       <div class="form-group col-md-12">
                           <label class="col-md-2 control-label">Password</label>
                           <div class="col-md-7">
                               <input type="password" name="password" class="form-control" ng-model="phonenumber" placeholder="Password" required />
                           </div>
                       </div>
                   </div>
                   <div>
                       <div class="form-actions pull-right col-md-10 col-lg-10">
                       		<input type="submit" class="btn btn-primary" value="Login" onclick="submitLogin()" />
                       		<input type="reset" class="btn btn-primary" value="Clear" />
 <!--                           <button ng-click="authenticate(email, phonenumber)" ng-disabled="authForm.$invalid" class="btn btn-primary">
                               Add Candidate
                           </button>
                           <button ng-click="clearData(email, phonenumber)" ng-disabled="authForm.$invalid" class="btn btn-primary">
                               Clear
                           </button> -->
                       </div>
                   </div>
               </form>		
	</div>
</div>
</body>
<script>
function submitLogin(){
	document.forms[0].action = "${pageContext.request.contextPath}/submitLoginDetails";
	document.forms[0].submit();
}

</script>
</html>