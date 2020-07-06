<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Customers</title>
</head>
<body>
<center>
<h1>${requestScope["customers"].size()} customer(s) in list.</h1>

<table border="1">
	<tbody>
	<c:forEach var="c" items="${requestScope.customers}">
		<tr>
			<td>
				<c:out value="${c.id}"/>
			</td>
			<td>
				<a href="/customers/${c.id}">${c.name}</a>
			</td>
			<td>
				<c:out value="${c.email}"/>
			</td>
			<td>
				<c:out value="${c.address}"/>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</center>
</body>
</html>
