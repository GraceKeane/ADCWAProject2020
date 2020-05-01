<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<body>
<h1>List of Customers</h1>
<table>
<tr>
    <c:forEach items="${customers}" var="customer">
    	<th> 
    		<!-- Heading include customer ID and name -->
       		<h2>${customer.number} ${customer.customername}</h2>
       		<b>${customer.customername}'s Orders</b>
       	</th>
       
       <tr> 
       		<!-- Table headings -->
 	    	<th><b>Order-ID</b></th>
   			<th><b>Quantity</b></th>
   			<th><b>Product-ID</b></th>
   			<th><b>Description</b></th>	
   		</tr>
   	   			
   		<c:forEach items="${customer.orders}" var="order">
   		<tr>
   			<!-- Displaying oId, qty, ID and product description.
   			ID and name are linked to the product class while
   			oId and qty are linked to the original class order -->
       		<td>${order.oId}</td>
        	<td>${order.qty}</td>
        	<td>${order.prod.number}</td>
        	<td>${order.prod.productname}</td>
      	</tr>
       	</c:forEach>
     </c:forEach>
</table>
<br></br>
	<tr>
		<!-- Links -->
		<td><a href="/index.html">Home</a></td>
		<td><a href="/addCustomer.html">Add Customer</a></td>
		<td><a href="/getProducts.html">List Products</a></td>
		<td><a href="/getOrders.html">List Orders</a></td>
		<td><a href="/logout">Logout</a></td>	
	</tr>
</body>
</html>