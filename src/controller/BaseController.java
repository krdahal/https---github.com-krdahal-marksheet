package controller;

import domain.User;
import domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ashish on 12/20/2016.
 */
public class BaseController {
    public static String checkSession(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {

        if (page == null) {
            page = "test";
        }

        RequestDispatcher rd = null;
        System.out.println("----------page====="+page);
        if (!page.equalsIgnoreCase("login") && !page.equalsIgnoreCase("logout")) {
            HttpSession session = request.getSession(false);
            User user = (User)session.getAttribute("user");
            if (user == null) {
                page = "test";
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        }
        return page;
    }
}
