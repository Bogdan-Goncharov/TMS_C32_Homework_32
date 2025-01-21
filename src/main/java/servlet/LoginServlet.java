package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;



import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Map<String, String> users = RegisterServlet.users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username != null && password != null && users.containsKey(username) && users.get(username).equals(password)) {
            String role = "USER"; // Определяем роль на основе имени пользователя
            if ("admin".equals(username)) {
                role = "ADMIN";
            }
            HttpSession session = req.getSession();
            session.setAttribute("user", new User(username, password, role));
            resp.getWriter().write("Login successful! Welcome, " + username + "!");
            resp.sendRedirect("/home");
        } else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("Invalid username or password.");
        }
    }
}
