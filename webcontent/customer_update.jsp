
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer Details</title>
</head>
<body>
<h1>Edit Customer Details</h1>
<form action="customer_list.jsp" method="post">
    <button type="submit">Go Home</button>
</form>
<br>
<form action="cusUpdate" method="post">
<label for="tbid">Id:</label>
<input type="text" name="tbid" id="tbid" value=<%=request.getParameter("id") %>>
<br>
<label for="tbname">Name:</label>
<input type="text" name="tbname" id="tbname" value=<%=request.getParameter("name")%>>
<br>
<label for="tbemail">Email :</label>
<input type="email" name="tbemail" id="tbemail" value=<%=request.getParameter("email")%>>
<br>
<label for="tbtel">Mobile :</label>
<input type="tel" name="tbtel" id="tbtel" value=<%=request.getParameter("mobile")%>>
<br>
<input type="submit" value="update" name="sent">
</form>
</body>
</html>