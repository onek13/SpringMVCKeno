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
	<form:form method="post" modelAttribute="customer"
		action="/SpringMVC_Keno/createCustomer">
		<table>
			<tr>
				<th colspan="2">Customer Details</th>
			</tr>
			<tr>
				<form:hidden path="id" />
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:input path="firstName" size="30" maxlength="30"></form:input>
					<form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name:</form:label></td>
				<td><form:input path="lastName" size="30" maxlength="30"></form:input>
					<form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="idType">Id Type:</form:label></td>
				<td><form:input path="idType" size="30" maxlength="30"></form:input>
					<form:errors path="idType" /></td>
			</tr>
			<tr>
				<td><form:label path="idNumber">Id Number:</form:label></td>
				<td><form:input path="idNumber" size="30" maxlength="30"></form:input>
					<form:errors path="idNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="contactNumber">Contact Number:</form:label></td>
				<td><form:input path="contactNumber" size="30" maxlength="30"></form:input>
					<form:errors path="contactNumber" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" class="blue-button" value="Save"/>
					<input type="button" class="blue-button" value="Cancel" onclick="window.location.href='${pageContext.request.contextPath}/getCustomerList'"/>
					
				</td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>
