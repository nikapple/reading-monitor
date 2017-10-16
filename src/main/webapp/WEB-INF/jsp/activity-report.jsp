<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Activity Report</title>
</head>
<body>
	<h1>Activity Report</h1>
	<a href="userHome/${sessionScope.user.username}">Home</a>
	<table>
		<tr>
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Author</th>
			<th>Topic</th>
			<th>Reading Date</th>
		</tr>
		<c:forEach items="${activityList}" var="activity">
			<tr>
				<td>${activity.book.id}</td>
				<td>${activity.book.name}</td>
				<td>${activity.book.author}</td>
				<td>${activity.book.topic.name}</td>
				<td>${activity.readingDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>