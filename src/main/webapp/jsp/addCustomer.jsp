<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<h1>Add a customer</h1>
<body>
<form:form modelAttribute="customer">
 	<table>
  
  		<tr>
  			<td> Customer name: </td>
  			<!-- Taking in a name using the customername variable in the customer class -->
  			<td><form:input path="customername"></form:input></td>
  			<!-- Checking for errors, if no data input -> throws an error -->
  			<td><form:errors path="customername"></form:errors></td>
  		</tr>
  
  		<tr>
  			<td colspan="2">
  		  		<!-- Submit button -->
  				<input type="submit" value="Add"/>
  			</td>
  		</tr> 		
	</table>
</form:form>

<br></br>
	<tr>
	  	<!-- Links -->
		<td><a href="/index.html">Home</a></td>
		<td><a href="/getProducts.html">List Products</a></td>
		<td><a href="/getOrders.html">List Orders</a></td>
	</tr> 
	  
	</body>
</html>