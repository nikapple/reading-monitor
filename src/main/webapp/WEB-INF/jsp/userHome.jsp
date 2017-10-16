<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Welcome User</title>
</head>

<body>
	<h2>Logged in! as ${user.firstName}</h2>
	<a href="../allBooks">My Reading List</a>
	<a href="../activityForm">My Report</a>
	<a href="../logout">Logout</a>
</body>


</html>