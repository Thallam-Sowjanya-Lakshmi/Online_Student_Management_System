package controller;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import dao.StudentDAO;

public class DeleteStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        StudentDAO dao = new StudentDAO();
        dao.deleteStudent(id);

        res.sendRedirect("ViewStudentServlet");
    }
}

