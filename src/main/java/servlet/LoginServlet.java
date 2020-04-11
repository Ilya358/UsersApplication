package servlet;

import lombok.SneakyThrows;
import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();

    @SneakyThrows
    @Override
    public void init() {
        userService.creatAdmin();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if(userService.validateUser(name, password)) {
            User user = userService.getUserByNameAndPassword(name, password);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/untitled2_war_exploded/adminAll");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
