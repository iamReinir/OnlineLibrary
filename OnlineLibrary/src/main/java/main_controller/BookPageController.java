/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package main_controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.Book;
import DAO.BorrowingDAO;
import DAO.ReservationDAO;
import DAO.Review;
import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Giga P34
 */
@WebServlet(name = "BookPageController", urlPatterns = {"/book"})
public class BookPageController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String user_id = (String) session.getAttribute("user_id");
            String user_role = (String) session.getAttribute("role");
            String book_id = (String) request.getParameter("book_id");

            //This page need a book to display
            if (book_id == null) {
                request.getRequestDispatcher("./notfound.html").forward(request, response);
            }
            Entity book = EntityFactory
                    .getEntitySet("book")
                    .getEntity(book_id);
            if (book == null) {
                request.getRequestDispatcher("./notfound.html").forward(request, response);
            }
            Book newb = new Book(book);
            String notif = "This book is available";
            String user_option = null;
            String librarian_option = "Lend this book";
            String librarian_option_type = "borrow";
            String option_type = null;

            if (BorrowingDAO.isBorrowing(book_id, user_id)) {
                notif = "You are borrowing this book";
                user_option = "Extend borrowing time";
                option_type = "renewal";
            } else if (!BorrowingDAO.isAvailable(book_id)) {
                notif = "This book is currently borrowed";
                user_option = "Reservate this book";
                option_type = "reservation";

                librarian_option = "Reader has return this book";
                librarian_option_type = "return";
            }
            if (ReservationDAO.curentlyReserving(book_id, user_id)) {
                notif = "Reservation request is pending...";
                user_option = "Cancel request";
                option_type = "reservationCancel";
            }
            else if (ReservationDAO.requestAccept(book_id, user_id)) {
                notif = "Reservation request is accepted. Your book is available at the library";
                user_option = "Cancel request";
                option_type = "reservationCancel";
            }

            if (user_role == null) {
                request.setAttribute("isGuest", true);
            } else if (user_role.equals("reader")) {
                request.setAttribute("isReader", true);
            } else if (user_role.equals("librarian")) {
                request.setAttribute("isLibrarian", true);
            }
            request.setAttribute("notif", notif);
            request.setAttribute("user_option", user_option);
            request.setAttribute("option_type", option_type);
            request.setAttribute("librarian_option", librarian_option);
            request.setAttribute("librarian_option_type", librarian_option_type);
            request.setAttribute("this_book", newb);
            request.setAttribute("review_list", Review.allReviewOfBook(newb.getId(), true));
            request.getRequestDispatcher("book.jsp").include(request, response);
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
