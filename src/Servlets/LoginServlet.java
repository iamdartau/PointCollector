package Servlets;

import Repositories.UserRep;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserRep userRep = new UserRep();
        User user = userRep.checkUser(email,password);
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        req.getRequestDispatcher("index.jsp").forward(req,resp);;
    }
}
