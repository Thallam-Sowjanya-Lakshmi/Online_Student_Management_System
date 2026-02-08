package controller;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import dao.StudentDAO;
import model.Student;

public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Student s = new Student();
        s.setId(Integer.parseInt(req.getParameter("id")));
        s.setName(req.getParameter("name"));
        s.setEmail(req.getParameter("email"));
        s.setCourse(req.getParameter("course"));
        s.setPhone(req.getParameter("phone"));

        StudentDAO dao = new StudentDAO();
        dao.updateStudent(s);

        res.sendRedirect("ViewStudentServlet");
    }
}
