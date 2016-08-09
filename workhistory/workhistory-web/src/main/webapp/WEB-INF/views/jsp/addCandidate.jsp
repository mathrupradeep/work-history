<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Add New Candidate</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
	.wrapper {
		margin: 40px auto;
	}
	body {
			background: #ececec;
		}
</style>
</head>
<body>

<div class="container wrapper">

	<div>
		<c:if test="${not empty msg}">
			 ${msg}
		</c:if>
	</div>

	<form name="addCandidateForm" id="candidateForm" method="post" ng-controller="authCtrl" class="form-horizontal">
	   <div class="row">
       	<div class="form-group col-md-12">
       	
          <label class="col-md-2 control-label">Email ID</label>
          	<div class="col-md-7">
           		<input type="email" name="mailId" class="form-control" ng-model="email" placeholder="Email" required />
           	</div>
           </div>
         </div>
         <div class="row">
       	<div class="form-group col-md-12">
          <label class="col-md-2 control-label">Phone number</label>
          	<div class="col-md-7">
           		<input type="number" name="phoneNumber" class="form-control" ng-model="phoneNumber" placeholder="Phone number" required />
           	</div>
           </div>
         </div>
         <div class="form-group col-md-12">
         	<input type="submit" class="btn btn-primary" value="Add Candidate" onclick="callSubmit()">
         	<input type="reset" class="btn btn-primary" value="Clear">
         </div>
		</form>
		
		<%@ include file="logout.jsp" %>
	</div>
</body>

<script>
	function callSubmit() {
		document.forms[0].action = "${pageContext.request.contextPath}/submitCandidateBasicInfo";
		document.forms[0].submit();
	}
</script>
<%@ include file="logout.jsp" %>
<%@ include file="dashboardLink.jsp" %>
</html>