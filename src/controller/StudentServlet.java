package controller;

import domain.Student;
import domain.User;
import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by User on 12/18/2016.
 */
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
       page = BaseController.checkSession(request, response, page);

        RequestDispatcher rd ;
        String message = "";




        if(page.equalsIgnoreCase("studentList")){

            List<Student> studentList= new StudentService().getStudentList();
            request.setAttribute("studentList",studentList);
            rd=request.getRequestDispatcher("student/studentList.jsp");
            rd.forward(request, response);

        }

        if(page.equalsIgnoreCase("studentForm")){

            rd=request.getRequestDispatcher("student/studentForm.jsp");
            rd.forward(request, response);

        }

        if(page.equalsIgnoreCase("studentAdd")){


            Student student=new Student();
            student.setRollNumber(Integer.parseInt(request.getParameter("rollNumber")));
            student.setAge(Integer.parseInt(request.getParameter("age")));
            student.setName(request.getParameter("name"));
            student.setAddress(request.getParameter("address"));


            new StudentService().studentAdd(student);

            List<Student> studentList=new StudentService().getStudentList();
            request.setAttribute("studentList",studentList);
            rd=request.getRequestDispatcher("student/studentList.jsp");
            rd.forward(request, response);

        }


        if(page.equalsIgnoreCase("studentEdit")){

            Student student= new StudentService().getStudent( Integer.parseInt(request.getParameter("id")));
            request.setAttribute("student",student);
            rd=request.getRequestDispatcher("student/studentEdit.jsp");
            rd.forward(request, response);

        }


        if(page.equalsIgnoreCase("studentUpdate")){

            Student student= new Student();

            student.setRollNumber(Integer.parseInt(request.getParameter("rollNumber")));
            student.setAge(Integer.parseInt(request.getParameter("age")));
            student.setName(request.getParameter("name"));
            student.setAddress(request.getParameter("address"));

            new StudentService().updateStudent( Integer.parseInt(request.getParameter("id")),student);


            List<Student> studentList=new StudentService().getStudentList();
            request.setAttribute("studentList",studentList);
            rd=request.getRequestDispatcher("student/studentList.jsp");
            rd.forward(request, response);

        }


        if(page.equalsIgnoreCase("studentDelete")){

            new StudentService().deleteStudent( Integer.parseInt(request.getParameter("id")));

            List<Student> studentList=new StudentService().getStudentList();
            request.setAttribute("studentList",studentList);
            rd=request.getRequestDispatcher("student/studentList.jsp");
            rd.forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
