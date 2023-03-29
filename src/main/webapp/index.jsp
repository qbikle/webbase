<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Please Enter Your Details Below" %>
</h1>
<br/>
<form action="hello-servlet" method="get">
    <label>Enter The Subject:</label>
    <input type="text" name="subject"><br>
    <label>Enter the course code:</label>
    <input type="text" name="ccode"><br>
    <label>Enter the Coordinator name:</label>
    <input type="text" name="cname"><br>
    <label>Review:</label>
    <input type="range" min="1" max="5" name="review" class="slider"><br>
    <input type="submit" value="Submit Details">
</form>
</body>
</html>