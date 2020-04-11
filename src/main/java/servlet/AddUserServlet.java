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

@WebServlet("/adminAdd")
public class AddUserServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("addUser.jsp");
        requestDispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("role");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String surname = req.getParameter("surname");
        User user = new User(role, name, password, surname);
        userService.addUser(user);
        resp.sendRedirect("/untitled2_war_exploded/adminAll");
    }
}
