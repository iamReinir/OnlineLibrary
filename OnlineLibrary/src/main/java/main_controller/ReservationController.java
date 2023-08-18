/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package main_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Predicate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Giga P34
 */
@WebServlet(name = "ReservationController", urlPatterns = {"/reservation"})
public class ReservationController extends HttpServlet {

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
        try {
            PrintWriter out = response.getWriter();
            //It takes form data, so the value is the button's text
            String reservation = request.getParameter("reservation");
            String renewal = request.getParameter("renewal");
            String update = request.getParameter("update");
            String book_id = request.getParameter("book_id");
            String user_id = (String) request.getSession().getAttribute("user_id");
            String user_role = (String) request.getSession().getAttribute("role");
            Predicate<Entity> user_is_borrowing_this = (borrowing) -> {
                boolean same_user = borrowing.getAttribute("borrower_id").equals(user_id);
                boolean same_book = borrowing.getAttribute("borrowed_book").equals(book_id);
                return same_user && same_book;
            };
            if (user_role == null) {
                response.sendRedirect("./login");
            }
            if (update != null && user_role.equals("librarian")) {
                response.sendRedirect("./update?book_id=" + book_id);
            }
            boolean result = false;
            if (reservation != null) {
                System.out.println("Reservation");
                Entity newReser = EntityFactory.createEntity("reservation");
                newReser.setAttribute("user_id", user_id);
                newReser.setAttribute("book_id", book_id);
                result = EntityFactory.getEntitySet("reservation").add(newReser);
            }
            if (renewal != null) {
                System.out.println("Renewal");
                Entity borrow = EntityFactory.getEntitySet("borrowing")
                        .searchResult(user_is_borrowing_this)[0];
                Entity newRenewal = EntityFactory.createEntity("renewal");
                newRenewal.setAttribute("borrow_id", borrow.getAttribute("id"));
                result = EntityFactory.getEntitySet("renewal").add(newRenewal);
            }
            if (result == true)
            out.print("<script>"
                    + "alert('Your request is recorded and pending!');"
                    + "window.location.href='./book.jsp?book_id="
                    + book_id + "'"
                        + ";</script>");
            else
                out.print("<script>"
                        + "alert('Something wrong with your request! "
                        + "Please contact your librarian for support!');"
                        + "window.location.href='./book.jsp?book_id="
                        + book_id + "'"
                        + ";</script>");
        } catch (Exception ex) {
            request.getRequestDispatcher("notfound.html").forward(request, response);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
