package login.controller;
import models.User;
import userDAO.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {
    UserDAO userDAO;
    @Override
    public void init(){
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        HttpSession session = request.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
            userDAO.removeUser(username);
            session.invalidate();
        }
        response.sendRedirect("Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        HttpSession session = request.getSession(false);
        if(!userDAO.addUser(name,session)) {
            request.setAttribute("error", "Username already taken");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("MainChat.jsp").forward(request, response);
        }
    }

}