package ua.omenyuk.spring.servlet;

import ua.omenyuk.spring.dao.PersonList;
import ua.omenyuk.spring.models.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    //no-argument constructor
    public LoginServlet() {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PersonList personList = PersonList.getPersonList();

        PrintWriter out = response.getWriter();

        //get parameters from request object.
        String userName = request.getParameter("login").trim();
        String password = request.getParameter("password").trim();

        String loginTemp = "";
        String passwordTemp = "";
        for (Person p : personList.getPeople()) {
            if (userName.equals(p.getLogin()) && password.equals(p.getPassword())) {
                loginTemp = p.getLogin();
                passwordTemp = p.getPassword();
            }
        }

        //check for null and empty values.

        if (userName.equals("") || password.equals("")) {
            out.print("Error password");
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/index.html");
            requestDispatcher.include(request, response);
        }

        else if (userName.equals(loginTemp) && password.equals(passwordTemp)) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("login", userName);
            httpSession.setAttribute("password", password);
            out.println("""
                    You have successfully logged in.
                    Now you can see the list of people
                    """);
            out.println("""
                    <a href='/LessonMVC_war_exploded/people/'>
                    List of people</a>
                    """);
            out.println("""
                    <a href='/LessonMVC_war_exploded/'>
                    Log Out</a>
                    """);
            out.close();
        }

        else {
            out.print("Please enter correct your password or login");
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/index.html");
            requestDispatcher.include(request, response);
        }
    }
}