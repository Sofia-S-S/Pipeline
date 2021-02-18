<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body>
	<h1>Employee Home Page</h1>
	<h2> Welcome <%=request.getAttribute("name")%>
	</h2>
	
<div id="divForId"> Your login is: ${param.login} <!-- retrieving parameter from forwarding request -->
and  Your id is:

	<%=request.getAttribute("employeeId")%> <!-- retrieving parameter that we retrieved from response and passed in forwarded request -->
	
	
	</div>
</body>
</html>