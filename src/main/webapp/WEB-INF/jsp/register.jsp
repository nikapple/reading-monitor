<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="resources/javascript/processRegistration.js"></script>
</head>

<body>
	<h2>Register</h2>
	<form:form id="regForm" modelAttribute="user"
		action="/reading-monitor/register" method="post">
		<table>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" name="username" id="username" />
				</td>
				<td><form:errors path="username"></form:errors>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
				<td><form:errors path="password"></form:errors>
			</tr>
			<tr>
				<td><form:label path="firstName">FirstName</form:label></td>
				<td><form:input path="firstName" name="firstName"
						id="firstName" /></td>
				<td><form:errors path="firstName"></form:errors>
			</tr>
			<tr>
				<td><form:label path="lastName">LastName</form:label></td>
				<td><form:input path="lastName" name="lastName" id="lastName" />
				</td>
				<td><form:errors path="lastName"></form:errors>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
				<td><form:errors path="email"></form:errors>
			</tr>
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input path="phone" name="phone" id="phone" /></td>
				<td><form:errors path="phone"></form:errors>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="register" name="register">Register</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="/reading-monitor/login">Home</a></td>
			</tr>
		</table>
	</form:form>
	<!-- Result Container  -->
	<div id="resultContainer" style="display: none;">
		<hr />
		<h4 style="color: green;">JSON Response From Server</h4>
		<pre style="color: green;">
    <code></code>
   </pre>
	</div>
</body>

</html>