<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Add New Candidate</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
</head>
<body>

	<form name="addCandidateForm" id="candidateForm" method="post">
		</br>
		<h3>
			E-Mail ID &nbsp;<input type="text" name="mailId"> <br>
			Phone Number &nbsp; </br>
			<input type="text" name="phoneNumber"> <input
				type="submit" value="Add Candidate" onclick="callSubmit()">
				<input type="reset" value="Clear">
		</h3>
	</form>
</body>
<script>
	function callSubmit() {
		document.forms[0].action = "${pageContext.request.contextPath}/submitCandidateBasicInfo";
		document.forms[0].submit();
	}

	
</script>
</html>