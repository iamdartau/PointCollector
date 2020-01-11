
package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter("/Calculations")
public class CalculationsFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String LatLon = request.getParameter("LatLon");
        String req_num = request.getParameter("req_num");
        String phone_number = request.getParameter("phone_numb");
        Pattern pattern = Pattern.compile("^[-+\\s]*?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)[,\\s]*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$");
        Pattern paternReq = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(LatLon);
        Matcher matcherReq = paternReq.matcher(req_num);

        if (!matcher.matches() || req_num.equals("") || phone_number.equals("")||!matcherReq.matches()) {
            response.sendRedirect("index.jsp?error=1");
        }
        else {
            super.doFilter(request, response, chain);
        }
    }

    @Override
    public void destroy() {

    }
}
