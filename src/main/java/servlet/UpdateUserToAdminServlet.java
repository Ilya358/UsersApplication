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

@WebServlet("/adminUpdate")
public class UpdateUserToAdminServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        User user = userService.getUserById(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateUserToAdmin.jsp");
        req.setAttribute("user", user);
        requestDispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String role = req.getParameter("role");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String surname = req.getParameter("surname");
        User user = new User(id, role, name, password, surname);
        userService.updateUser(user);
        resp.sendRedirect("/untitled2_war_exploded/adminAll");
    }
}
