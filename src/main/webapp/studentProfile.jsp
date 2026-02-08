<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*,util.DBConnection" %>
    <%
int id = (int) session.getAttribute("studentId");
Connection con = DBConnection.getConnection();
PreparedStatement ps = con.prepareStatement(
    "SELECT * FROM students WHERE id=?"
);
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
rs.next();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student View Profile</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h2>My Profile</h2>
<table>
    <tr> <td>Name: </td><td><%= rs.getString("name") %></td></tr>
   <tr> <td>Email: </td><td><%= rs.getString("email") %></td></tr>
   <tr><td> Course: </td><td><%= rs.getString("course") %></td></tr>
    <tr><td>Phone: </td><td><%= rs.getString("phone") %></td></tr></table>
</div>

</body>
</html>