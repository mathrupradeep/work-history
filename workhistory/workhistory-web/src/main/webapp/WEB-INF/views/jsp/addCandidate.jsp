<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>jQuery UI Button - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(document).ready(function(){
	$.ajax({
		   type: "POST",
		   dataType: "json",
		   contentType: "application/json; charset=utf-8",
		   url: "workhistory-web/submitLoginDetails",
		   data: '{ foo: \'' + bar + '\', zoo: \'' + calibri + '\'}',
		   success: function(msg){
		       alert('wow'+msg);
		   },
		});
    });
  </script>
</head>
<body>

	<form name="candidateForm" id="candidateForm" method="post">
		</br>
		<h3>
			add candidate jsp E-Mail ID &nbsp;<input type="text" name="mailId">
			<br> Phone Number &nbsp; <input type="text" name="phoneNumber">
			<br> </br> <input type="submit" id="addCandidate"
				value="Add Candidate"> <input type="reset" value="Clear">
		</h3>
	</form>
</body>
</html>