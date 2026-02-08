<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editstudent</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
Student s = (Student) request.getAttribute("student");
%>

<h2>Edit Student</h2>

<form action="UpdateStudentServlet" method="post">
    <input type="hidden" name="id" value="<%=s.getId()%>">

    <input type="text" name="name" value="<%=s.getName()%>" required>
    <input type="email" name="email" value="<%=s.getEmail()%>" required>
    <input type="text" name="course" value="<%=s.getCourse()%>" required>
    <input type="text" name="phone" value="<%=s.getPhone()%>" required>

    <input type="submit" value="Update Student">
</form>

</body>
</html>