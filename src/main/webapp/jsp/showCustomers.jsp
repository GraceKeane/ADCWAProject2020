<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<body>
<h1>List of Customers</h1>
<table>
  <tr>
   <th>Name</th>
   <th>Stock-name</th>
  </tr>
  <tr>
    <c:forEach items="${customers}" 
                	 var="customer">
      <tr> 
        <td>${customer.number}</td>
        <td>${customer.customername}</td>
      </tr>
    </c:forEach>
  </tr>
</table>
</body>
</html>