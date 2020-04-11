package servlet;

import lombok.SneakyThrows;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin", "/adminAdd", "/adminAll", "/adminDelete", "/adminUpdate"})
public class WebFilterServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user = (User) request.getSession().getAttribute("user");
        request.getSession().setAttribute("user", user);
        if(user != null){
            if (user.getRole().equals("admin")) {
                filterChain.doFilter(request, response);
            } else {
                response.sendRedirect("/untitled2_war_exploded/user");
            }
        } else {
            response.sendRedirect("/untitled2_war_exploded/login");
        }
    }

    @Override
    public void destroy() {

    }
}
