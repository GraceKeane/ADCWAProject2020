<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<h1>List of Products</h1>
<table>
	<tr>
		<!-- Table headings -->
   		<th>Name</th>
   		<th>Product-name</th>
   		<th>Stock-number</th>
  	</tr>
  
  	<tr>
    <c:forEach items="${products}" 
                 var="product">
     <tr> 
     	<!-- Table information gotten from product database -->
     	<td>${product.number}</td>
        <td>${product.productname}</td>
        <td>${product.stocknumber}</td>
      </tr>
    </c:forEach>
  </tr>
</table>
<br></br>
	<tr>
		<!-- Links -->
		<td><a href="/index.html">Home</a></td>
		<td><a href="/addProduct.html">Add Product</a></td>
		<td><a href="/getProducts.html">List Products</a></td>
		<td><a href="/getOrders.html">List Orders</a></td>	
		<td><a href="/logout">Logout</a></td>	
		
	</tr>
</body>
</html>