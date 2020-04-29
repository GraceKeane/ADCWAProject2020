<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Order</title>
</head>
<body>
<form:form modelAttribute="orders">
  <table>
      <tr>
  		<td>Customer name</td>
  			<td><form:select path="cust.customername" items="${list1}"></form:select></td>
  		</td>
  	</tr>
  	
  	<tr>
  		<td>Product name</td>
  			<td><form:select path="prod.productname" items="${list2}"></form:select></td>
  		</td>
  	</tr>
  	
  	<tr>
  		<td> Quantity </td>
  		<td><form:input path="qty"></form:input></td>
  		<td><form:errors path="qty"></form:errors></td>
  		
  	</tr>
  	
  	
  	<tr>
  		<td colspan="2">
  			<input type="submit" value="Order"/>
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