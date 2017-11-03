<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Welcome User</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	var ctx = "${pageContext.request.contextPath}"
</script>
<script src="${pageContext.request.contextPath}/resources/javascript/getAllBooks.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/getUserActivities.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/updateActivity.js"></script>
</head>

<body>
	<h2>Logged in! as ${user.firstName}</h2>
	<a id="bookListLink" href="#">My Reading List</a>
	<a id="activityFormLink" href="#">My Report</a>
	<a href="../logout">Logout</a>

	<div id="bookContainer">
		<ul id="bookList"></ul>
	</div>
	<div id="reportContainer">
		<h1>Activity Form</h1>
		<form id="activityForm" action="/reading-monitor/getActivities"
			method="get">
			<table>
				<tr>
					<td>Start Date :<input type="date" name="startDate"
						id="startDate" /></td>
					<td>Start Date :<input type="date" name="endDate" id="endDate" /></td>
					<td><input type="submit" value="View Activities" /></td>
					<td></td>
				</tr>
			</table>
		</form>
		<div id="activityResult">
		</div>
	</div>
</body>


</html>