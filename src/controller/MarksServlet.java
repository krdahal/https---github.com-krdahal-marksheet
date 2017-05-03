package controller;

import domain.Student;
import domain.Subject;
import domain.User;
import service.StudentService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/21/2016.
 */
public class MarksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        RequestDispatcher rd = null;
        if (page.equalsIgnoreCase("marks")) {

            List<Integer> fullMarks = new ArrayList<Integer>();
            fullMarks.add(25);
            fullMarks.add(50);
            fullMarks.add(100);

            List<Integer> passMarks = new ArrayList<Integer>();
            passMarks.add(10);
            passMarks.add(20);
            passMarks.add(40);

            List<Integer> classList = new ArrayList<Integer>();
            classList.add(1);
            classList.add(2);
            classList.add(3);
            classList.add(4);
            classList.add(5);

            List<Student> studentList = new StudentService().getStudentList();
            List<User> users = new UserService().getUserList();

            request.setAttribute("fullMarks", fullMarks);
            request.setAttribute("passMarks", passMarks);
            request.setAttribute("studentList", studentList);
            request.setAttribute("classList", classList);
            request.setAttribute("subjectList", users);

            rd = request.getRequestDispatcher("marks/addmarks.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
