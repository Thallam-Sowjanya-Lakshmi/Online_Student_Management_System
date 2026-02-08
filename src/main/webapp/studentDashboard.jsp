<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
if (session.getAttribute("studentId") == null) {
    response.sendRedirect("studentLogin.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Dashboard</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="dashboard">
    <h2>Welcome, <%= session.getAttribute("studentName") %></h2>

    <a href="studentProfile.jsp">View Profile</a><br>
    <a href="logout.jsp">Logout</a>
</div>

</body>
</html>