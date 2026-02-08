<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddStudent</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<form action="AddStudentServlet" method="post">
Name: <input type="text" name="name"><br>
Email: <input type="email" name="email"><br>
Course: <input type="text" name="course"><br>
Phone: <input type="text" name="phone"><br>
<input type="submit" value="Add Student">
</form>
</body>
</html>