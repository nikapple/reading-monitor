<%@page import="java.util.stream.Collectors"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.readingmonitor.dto.Book,java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Reading List</title>
</head>
<body>
	<h1>My Reading List</h1>
	<table>
		<c:forEach items="${topicList}" var="topic">
			<tr>
				<td><c:out value="${topic.id}" /></td>
				<td><c:out value="${topic.name}" /></td>
				<td>
					<table>
						<tr>
							<td>Book ID</td>
							<td>Name</td>
							<td>Author</td>
						</tr>
						<c:forEach items="${topic.bookList}" var="book">
							<tr>
								<td><c:out value="${book.id}" /></td>
								<td><c:out value="${book.name}" /></td>
								<td><c:out value="${book.author}" /></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>