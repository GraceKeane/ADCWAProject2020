<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product</title>
</head>
<h1>Add a product</h1>
<body>
<form:form modelAttribute="product">
	<table>
  		<tr>
  			<td> Product name: </td>
  			<!-- Taking in a name using the productname variable in the product class -->
  			<td><form:input path="productname"></form:input></td>
  			<!-- Checking for errors, if no data input -> throws an error -->
  			<td><form:errors path="productname"></form:errors></td>
  		
  		</tr>
  		
  		<tr>
  			<td> Stock number: </td>
  			<!-- Taking in a name using the stocknumber variable in the product class -->
  			<td><form:input path="stocknumber"/></td>
  			<!-- Checking for errors, if no data input -> throws an error -->
  			<td><form:errors path="stocknumber"></form:errors></td>
  		</tr>
  	
  		<tr>
  			<td colspan="2">
  			<!-- Submit button -->
  			<input type="submit" value="Add"/>
  		</td>
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