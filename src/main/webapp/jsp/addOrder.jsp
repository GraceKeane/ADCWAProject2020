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
<form:form modelAttribute="order">
  <table>
  	<tr>
  		<td>Customer name</td>
  			<td><form:select path="cust.customername" items="${orderList}"></form:select></td>
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