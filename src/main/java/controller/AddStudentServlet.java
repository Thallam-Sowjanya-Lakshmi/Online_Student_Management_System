package controller;
import java.io.*;
import model.Student;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class AddStudentServlet extends HttpServlet {
protected void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
Student s = new Student();
s.setName(req.getParameter("name"));
s.setEmail(req.getParameter("email"));
s.setCourse(req.getParameter("course"));
s.setPhone(req.getParameter("phone"));
StudentDAO.save(s);
res.sendRedirect("viewStudents.jsp");
}
}
