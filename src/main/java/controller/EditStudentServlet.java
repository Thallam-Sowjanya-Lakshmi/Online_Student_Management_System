package controller;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import dao.StudentDAO;
import model.Student;

public class EditStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        StudentDAO dao = new StudentDAO();
        Student s = dao.getStudentById(id);

        req.setAttribute("student", s);
        RequestDispatcher rd = req.getRequestDispatcher("editStudent.jsp");
        rd.forward(req, res);
    }
}
																				
