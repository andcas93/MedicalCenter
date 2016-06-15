<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<h2 style="color: orange">Login to Medical Center</h2>
	<c:if test="${'fail' eq param.auth}">
		<div style="color: red"> Login Failed!!!<br />
		</div>
	</c:if>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type='text' name='username' /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password'></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>