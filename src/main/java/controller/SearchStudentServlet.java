package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import dao.StudentDAO;
import model.Student;

public class SearchStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String keyword = req.getParameter("keyword");

        StudentDAO dao = new StudentDAO();
        List<Student> list = dao.searchStudent(keyword);

        req.setAttribute("students", list);
        RequestDispatcher rd = req.getRequestDispatcher("viewStudents.jsp");
        rd.forward(req, res);
    }
}

