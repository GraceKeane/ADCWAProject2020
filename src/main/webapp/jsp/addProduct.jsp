<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product</title>
</head>
<body>
<form:form modelAttribute="product">
  <table>
  	<tr>
  		<td> Product name: </td>
  		<td><form:input path="productname"></form:input></td>
  	</tr>
  	<tr>
  		<td> Stock number: </td>
  		<td><form:input path="stocknumber"></form:input></td>
  	</tr>
  	<tr>
  		<td colspan="2">
  			<input type="submit" value="Add"/>
  		</td>
  	</tr>  		
</table>
</form:form>
</body>
</html>