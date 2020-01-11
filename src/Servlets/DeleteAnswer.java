package Servlets;


import Repositories.UserRep;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteAnswer")
public class DeleteAnswer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRep userRep = new UserRep();
        userRep.deleteAnswer(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("index.jsp");
        userRep = null;
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
    }
}
