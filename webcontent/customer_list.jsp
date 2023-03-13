<%@page import="com.techpalle.Dao.CustomerDao"%>
<%@page import="com.techpalle.model.*"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
<table>
<tr>
<th>
<h1>Welcome To Admin Page</h1></th>
<th>
<form action="customer_list.jsp" method="post">
    <button type="submit">Go Home</button>
</form>
</th>
</tr>
</table>
<form action="reg" method="post">
<input type="submit" value="Add Customer">
</form>
<br>
<%
ArrayList<Customer> c=CustomerDao.showAll();

%>
<table style="background-color:grey; color:white" border="1">
<tr>
<th>Id</th><th>Name</th><th>Email</th><th>Mobile</th><th>Action</th>
</tr>

<%
for(Customer cc:c)
{

%>
<tr>
<td><%=cc.getId() %></td><td><%=cc.getName() %></td><td><%=cc.getEmail() %></td><td><%=cc.getMobile() %></td>
<td><form action="update" method="post">
<input type="hidden" value=<%=cc.getId() %> name="id">
<input type="hidden" value=<%=cc.getName() %> name="name">
<input type="hidden" value=<%=cc.getEmail() %> name="email">
<input type="hidden" value=<%=cc.getMobile()%> name="mobile">

<input type="submit" value="Edit">
</form>

<form action="delete" method="post">
<input type="hidden" value=<%=cc.getId() %> name="id">
<input type="submit" value="Delete">
</form></td>
</tr>

<%
}
%>
</table>


</body>
</html>