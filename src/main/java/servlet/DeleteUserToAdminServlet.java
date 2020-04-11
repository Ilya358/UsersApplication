package servlet;

import lombok.SneakyThrows;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminDelete")
public class DeleteUserToAdminServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        userService.deleteUser(id);
        resp.sendRedirect("/untitled2_war_exploded/adminAll");
    }
}
