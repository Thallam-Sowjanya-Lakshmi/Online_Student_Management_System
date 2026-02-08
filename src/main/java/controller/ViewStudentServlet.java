package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import dao.StudentDAO;
import model.Student;

public class ViewStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        StudentDAO dao = new StudentDAO();
        List<Student> list = dao.getAllStudents();

        req.setAttribute("students", list);
        RequestDispatcher rd = req.getRequestDispatcher("viewStudents.jsp");
        rd.forward(req, res);
    }
}
