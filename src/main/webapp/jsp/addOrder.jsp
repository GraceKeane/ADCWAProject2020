<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Order</title>
</head>
<h1>Add an order</h1>
<body>
<form:form modelAttribute="order">
  	<table>
      	<tr>
  			<td>Customer name</td>
  			<!-- Displaying list1 which holds the customer name data in the database,
  			 taking in data using cust-->
  			<td><form:select path="cust" items="${list1}"></form:select></td>
  		</tr>
  	
  		<tr>
  			<td>Product name</td>
  			<!-- Displaying list2 which holds the product description data in the database,
  			taking in data using prod-->
  			<td><form:select path="prod" items="${list2}"></form:select></td>
  		</tr>
  	
  		<tr>
  			<td> Quantity </td>
  			<!-- Taking in a qty using the qty variable in the order class -->
  			<td><form:input path="qty"></form:input></td>
  			<!-- Checking for errors, if no data input -> throws an error -->
  			<td><form:errors path="qty"></form:errors></td>
  		</tr>
  	
  		<tr>
  			<td colspan="2">
  			<!-- Submit button -->
  			<input type="submit" value="Order"/>
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