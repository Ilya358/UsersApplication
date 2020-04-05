package servlet;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all")
public class AllUserServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> listUser = userService.getAllUser();
        req.setAttribute("listUser", listUser);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AllUsers.jsp");
        requestDispatcher.forward(req, resp);
    }
}
