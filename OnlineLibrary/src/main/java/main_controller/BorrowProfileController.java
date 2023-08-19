/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package main_controller;

import DAO.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.Book;
import DAO.Borrowing;
import DAO.BorrowingDAO;
import DAO.User;
import model_interface.*;

/**
 *
 * @author Giga P34
 */
@WebServlet(name = "BorrowProfileController", urlPatterns = {"/profile/borrow"})
public class BorrowProfileController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

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
        String user_id = (String) request.getSession().getAttribute("user_id");
        String username = (String) request.getSession().getAttribute("username");
        String role = (String) request.getSession().getAttribute("role");
        User u = new User(
                Integer.parseInt(user_id),
                username,
                EntityFactory.getEntitySet("user").getEntity(user_id).getAttribute("password"),
                EntityFactory.getEntitySet("user").getEntity(user_id).getAttribute("email"),
                role
        );
        BorrowingDAO br = new BorrowingDAO();
        List<Borrowing> lb = br.getAllBorrowingBookByBorrowerID(u.getId());
        BookDAO bd = new BookDAO();
        List<Book> listBook = new ArrayList<>();
        for (Borrowing borrowing : lb) {
            listBook.add(bd.getBookByID(Integer.parseInt(borrowing.getBorrower_book())));
        }
        int page = 1;
        String pageStr = request.getParameter("page");
        try {
            if (pageStr != null) {
                page = Integer.parseInt(pageStr);
            }
        } catch (NumberFormatException e) {
            System.out.println("Loi ");
        }
        final int PAGE_SIZE = 3;
        Object showlist = listBook.subList((page - 1) * PAGE_SIZE,
                page * PAGE_SIZE >= listBook.size() ? listBook.size() : page * PAGE_SIZE);
        request.setAttribute("listBook", showlist);
        request.getRequestDispatcher("../borrowprofile.jsp").forward(request, response);
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
