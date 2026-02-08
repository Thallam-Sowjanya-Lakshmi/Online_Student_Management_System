<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,dao.StudentDAO,model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewStudents</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Student List</h2>

<a href="addStudent.jsp" class="btn">➕ Add New Student</a>

<form action="SearchStudentServlet" method="get" class="search-box">
    <input type="text" name="keyword" placeholder="Search by ID or Name" required>
    <input type="submit" value="Search">
</form>

<table>
    <tr>
        <th>ID</th><th>Name</th><th>Email</th>
        <th>Course</th><th>Phone</th><th>Actions</th>
    </tr>

<%
List<Student> list = (List<Student>) request.getAttribute("students");
if(list != null){
for(Student s : list){
%>
<tr>
<td><%= s.getId() %></td>
    <td><%= s.getName() %></td>
    <td><%= s.getEmail() %></td>
    <td><%= s.getCourse() %></td>
    <td><%= s.getPhone() %></td>
    <td>
        <a href="EditStudentServlet?id=<%=s.getId()%>" class="btn-edit">Edit</a>
        <a href="DeleteStudentServlet?id=<%=s.getId()%>"
           onclick="return confirm('Are you sure?')"
           class="btn-delete">Delete</a>
    </td>
</tr>
 <%
} 
}else {
%>
<tr>
    <td colspan="5">No students found</td>
</tr>
<%
}
%>
</table>

<div style="width:90%; margin:20px auto; text-align:right;">
    <a href="addStudent.jsp" class="add-btn">+ Add One More Student</a>
</div>
</body>
</html>