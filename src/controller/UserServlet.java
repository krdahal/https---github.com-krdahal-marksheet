package controller;

import domain.User;
import service.UserService;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by  on 12/12/2016.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String page = request.getParameter("page");

        page = BaseController.checkSession(request, response, page);

        RequestDispatcher rd;
        String message = "";

        if(page.equalsIgnoreCase("home")){

            message ="HOME!!!";
            request.setAttribute("message",message);
            rd=request.getRequestDispatcher("user/home.jsp");
            rd.forward(request, response);

        }
        if (page.equalsIgnoreCase("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new UserService().getUser(username, password);

            if (user!=null) {

                HttpSession session = request.getSession(false);
                session.setAttribute("user", user);


                message = "Login Success!!";
                request.setAttribute("message",message);
                rd = request.getRequestDispatcher("user/home.jsp");
                rd.forward(request, response);
            }else{
                message = "Invalid Login. Please check username or password!";
                request.setAttribute("message",message);
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }


        }
        if (page.equalsIgnoreCase("logout")) {

            HttpSession session = request.getSession(false);
            session.removeAttribute("user");
            session.invalidate();

            message = "Successfully Logged out!!";
            request.setAttribute("message",message);
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("userList")) {
            List<User> userList =new  UserService().getUserList();
            request.setAttribute("userList",userList);

            rd = request.getRequestDispatcher("user/userList.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("userForm")) {

            rd = request.getRequestDispatcher("user/userForm.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("addUser")) {

            User newUser =new User();
            newUser.setName(request.getParameter("username")) ;
            newUser.setPassword(request.getParameter("password"));
            newUser.setRole(request.getParameter("role"));
            UserService userService=new UserService();
            userService.addUser(newUser);

            List<User> userList=new UserService().getUserList();
            request.setAttribute("userList",userList);
            rd = request.getRequestDispatcher("user/userList.jsp");
            rd.forward(request, response);

        }

        if (page.equalsIgnoreCase("userDelete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new UserService().delete(id);
            List<User> userList=new UserService().getUserList();
            request.setAttribute("userList",userList);
            rd = request.getRequestDispatcher("user/userList.jsp");
            rd.forward(request, response);


        }
        if (page.equalsIgnoreCase("userEdit")) {
           int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("check");
           User user= new UserService().findUser(id);
            request.setAttribute("user",user);
            rd = request.getRequestDispatcher("user/userEdit.jsp");
            rd.forward(request, response);

        }

        if (page.equalsIgnoreCase("userUpdate")) {
            int id = Integer.parseInt(request.getParameter("id"));

            User user= new User();
            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));

            new UserService().updateUser( id ,user);


            List<User> userList=new UserService().getUserList();
            request.setAttribute("userList",userList);
            rd = request.getRequestDispatcher("user/userList.jsp");
            rd.forward(request, response);

        }

        if(page.equalsIgnoreCase("subject")){
            rd=request.getRequestDispatcher("subject/subjectList.jsp");
            rd.forward(request,response);
        }



    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
