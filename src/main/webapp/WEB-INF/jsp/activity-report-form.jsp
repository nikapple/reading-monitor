<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Activity Report Form</title>
</head>
<body>
	<h1>Activity Report Form</h1>
	<a href="../logout">Logout</a>
	<form id="activityForm" action="/reading-monitor/getActivities"
		method="get">
		<table>
			<tr>
			<td>Start Date :<input type="date" name="startDate" id="startDate" /></td>
			<td>Start Date :<input type="date" name="endDate" id="endDate" /></td>
			<td><input type="submit" value="View Activities"/></td>
			<td></td>
			</tr>
		</table>
	</form>
</body>
</html>