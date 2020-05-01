<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Orders</title>
</head>
<h1>List of Orders</h1>

 <c:forEach items="${orders}" 
                	 var="order">
 
 <!-- Heading include order ID -->
 <h3>${order.oId}</h3>
 
	<table>

  	<tr>
  		<!-- Table headers -->
   		<th>Quantity</th>
   		<th>Order-Date</th>
   		<th>Customer-ID</th>
   		<th>Customer-Name</th>
   		<th>Product-ID</th>
   		<th>Description</th>
  	</tr>
  
     <tr> 
      	<!-- Table information gotten from order, customer and product classes
      	using joins -->
        <td>${order.qty}</td>
        <td>${order.orderDate}</td>
        <td>${order.cust.number}</td>
        <td>${order.cust.customername}</td>
        <td>${order.prod.number}</td>
        <td>${order.prod.productname}</td>
      </tr>
   
	</table>
</c:forEach>
<br></br>

	<tr>
		<!-- Links -->
		<td><a href="/index.html">Home</a></td>
		<td><a href="/addOrder.html">Add Order</a></td>
		<td><a href="/getProducts.html">List Products</a></td>
		<td><a href="/getOrders.html">List Orders</a></td>
		<td><a href="/logout">Logout</a></td>	
	</tr>
</body>
</html>