
package filters;

import Repositories.UserRep;
import models.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/Login")
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // объект для репозитория - через него проверим или добавим юзера.
        UserRep userRep = new UserRep();
        // юзер который есть в active directory
        User userLdap = null;
        // юзер который мы используем при соблюдении того что он есть в бд и что он есть в active directory
        User user = null;
        //попытаемся
        try {
            // вытягиваем юзера из ad
            userLdap = userRep.checkUserByGroupAndStatus(request.getParameter("email"),request.getParameter("password"));
        }//попали сюда если не получилосьб словили ошибку
         catch (Exception e) {
            //вывели ошибочку на экранчик
            e.printStackTrace();
        }
        //*1* если он там зареган
        if (userLdap != null) {
            // вытащи его из бд
            User userBd = userRep.checkUser(request.getParameter("email"), request.getParameter("password"));
            // *2* Если он есть в бд
            if (userBd != null) {
                // то мы используем дальше юзера из бд
                user = userBd;
            // *2* А если его нет в бд
            } else {
                //добавляем туда с параметрами которые опредилили у юзера из ldap
                userRep.addUser(userLdap.getEmail(), userLdap.getPassword(), userLdap.getGroup());
                //и снова поверяем его в БД и уже точно его оттула берём
                user = userRep.checkUser(request.getParameter("email"), request.getParameter("password"));
            }
        //*1* А если не зареган
        } else {
            // вы не зарегистрированны в ad
            response.sendRedirect("login.jsp?error=1");
        }
        // *3* если http запрос POST
        if (request.getMethod().equalsIgnoreCase("post")) {
            // Если user существует
            if (user != null) {
                //пускай на endpoint
                super.doFilter(request, response, chain);
              //А если нет
            } else {
                // кидай его на страницу с ошибкой
                response.sendRedirect("login.jsp?error=1");
            }
        // *3* если http запрос не POST
        } else {
            // запроси сессию по юзеру
            User sessionUser = (User) request.getSession().getAttribute("user");
            // ЕСЛИ сессия существует
            if (sessionUser != null) {
                // пускай мальца
                super.doFilter(request, response, chain);
            } else {
                // кидай его на страницу с ошибкой
                response.sendRedirect("login.jsp?error=1");
            }
            super.doFilter(request, response, chain);
        }
    }

    @Override
    public void destroy() {

    }
}
