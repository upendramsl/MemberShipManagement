<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer Details</title>
</head>
<body>
<h1> Add Customer Details</h1>
<form action="customer_list.jsp" method="post">
    <button type="submit">Go Home</button>
</form>
<br>
<form action="cusReg" method="post">
<label for="tbname">Name:</label>
<input type="text" name="tbname" id="tbname">
<br>
<label for="tbemail">Email :</label>
<input type="email" name="tbemail" id="tbemail">
<br>
<label for="tbtel">Mobile :</label>
<input type="tel" name="tbtel" id="tbtel">
<br>
<input type="submit" value="submit" name="sent">
</form>
</body>
</html>