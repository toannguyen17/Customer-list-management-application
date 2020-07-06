<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Edit customer</title>
</head>
<body>
<center>
<h1>Edit customer</h1>
<form method="post">
	<input type="hidden" name="id" value='${requestScope["customer"].id}'>
<table border="1">
	<tbody>
		<tr>
			<td>
				Name
			</td>
			<td>
				<input type="text" name="name" value='${requestScope["customer"].name}'>
			</td>
		</tr>
		<tr>
			<td>
				Email
			</td>
			<td>
				<input type="text" name="email" value='${requestScope["customer"].email}'>
			</td>
		</tr>
		<tr>
			<td>
				Address
			</td>
			<td>
				<input type="text" name="address" value='${requestScope["customer"].address}'>
			</td>
		</tr>
	</tbody>
</table>
	<br />
	<br />
	<input type="submit" value="Save">
</form>
	<br />
	<br />
	<a href="/">Back to list</a>
</center>
</body>
</html>
