<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
<form:form modelAttribute="customer">
  <table>
  	<tr>
  		<td> Customer name: </td>
  		<td><form:input path="customername"></form:input></td>
  		<td><form:errors path="customername"></form:errors></td>
  		
  	</tr>
  
  	<tr>
  		<td colspan="2">
  			<input type="submit" value="Add"/>
  		</td>
  	</tr> 		
</table>
</form:form>

<tr>
	<td><a href="/index.html">Home</a></td>
	<td><a href="/getProducts.html">List Products</a></td>
	<td><a href="/getOrders.html">List Orders</a></td>
</tr> 
	  
</body>
</html>