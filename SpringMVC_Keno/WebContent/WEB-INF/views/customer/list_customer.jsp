<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
</head>
<body>
	<h3>Customer List</h3>
	<input type="button" class="blue-button" 
						 value="Add New" 
						 onclick="window.location.href='${pageContext.request.contextPath}/prepareCreateCustomer'"/>
	<c:if test="${!empty customerList}">
		<table class="tg">
			<tr>
				<th width="80">Id</th>
				<th width="120">First Name</th>
				<th width="120">Last Name</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${customerList}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td><a href="<c:url value='/prepareUpdateCustomer/${customer.id}' />">Edit</a></td>
					<td><a href="<c:url value='/deleteCustomer/${customer.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
