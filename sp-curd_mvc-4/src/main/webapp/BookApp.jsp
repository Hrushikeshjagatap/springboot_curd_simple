<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insert">
Book ID <input type="text" name="bid"><br><br>
Book Name  <input type="text" name="bname"><br><br>
Author  <input type="text" name="bauthor"><br><br>
Category <input type="text" name="bcategory"><br><br>
Price <input type="text" name="bprice"><br><br>
<input type="submit" value="Insert"><br><br>
</form>
<br>
<a href="update">Update Book</a>
<br>
<a href="delete">Delete Book</a><br>
<a href="select">Select Book</a><br>
<a href="showall">Show all Book</a>

</body>
</html>