<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
</head>
<body>
<h1>List of Orders</h1>
<table>
  <tr>
  	<th>Order-ID</th>
   	<th>Quantity</th>
   	<th>Order-Date</th>
   	<th>Customer-ID</th>
   	<th>Customer-Name</th>
   	<th>Product-ID</th>
   	<th>Description</th>
  
  </tr>
  <tr>
    <c:forEach items="${orders}" 
                	 var="order">
      <tr> 
      	<td>${order.oId}</td>
        <td>${order.qty}</td>
        <td>${order.orderDate}</td>
        <td>${order.cust.number}</td>
        <td>${order.cust.customername}</td>
        <th>${order.prod.number}</th>
        <th>${order.prod.productname}</th>
      </tr>
    </c:forEach>
  </tr>
</table>

<tr>
	<td><a href="/index.html">Home</a></td>
	<td><a href="/addOrder.html">Add Order</a></td>
	<td><a href="/getProducts.html">List Products</a></td>
	<td><a href="/getOrders.html">List Orders</a></td>
	<td><a href="/logout.html.html">Logout</a></td>
</tr>
</body>
</html>