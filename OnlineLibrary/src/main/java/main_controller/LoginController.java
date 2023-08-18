package main_controller;

import DAO.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Huynh Thai Duong
 *
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./login.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = null;
        String password = null;
        Cookie[] cookies = request.getCookies();
        cookies = (cookies == null ? new Cookie[]{} : cookies); // To remove the null check
        for (Cookie cooky : cookies) {
            if (cooky.getName().equals("username")) {
                username = cooky.getValue();
            }
            if (cooky.getName().equals("password")) {
                password = cooky.getValue();
            }
        }
        UserDAO user = UserDAO.login(username, password);
        if (user != null) {
            System.out.println("User id " + user.user_id + " logged in");
            request.getSession().setAttribute("user_id", user.user_id);
            request.getSession().setAttribute("username", user.username);
            request.getSession().setAttribute("role", user.role);
            response.sendRedirect("./index");
            return;
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  Get parameters outta POST request's load
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean remember = request.getParameter("remember") != null;

        UserDAO user = UserDAO.login(username, password);

        // Invalid login
        if (user == null) {
            request.setAttribute("error", "Username or password incorrect!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        // Remember me is checked
        if (remember == true) {
            int one_day = 60 * 60 * 24;
            Cookie usernameCookie = new Cookie("username", username);
            usernameCookie.setMaxAge(one_day);
            Cookie passwordCookie = new Cookie("password", password);
            passwordCookie.setMaxAge(one_day);
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }
        request.getSession().setAttribute("user_id", user.user_id);
        request.getSession().setAttribute("username", user.username);
        request.getSession().setAttribute("role", user.role);
        response.sendRedirect("./index");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
