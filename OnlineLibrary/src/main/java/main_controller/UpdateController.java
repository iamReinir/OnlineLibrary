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
import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Giga P34
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/update"})
public class UpdateController extends HttpServlet {

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
            request.getRequestDispatcher("./update.jsp").forward(request, response);
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
        boolean result = true;
        String book_id = request.getParameter("book_id");
        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        String author = request.getParameter("author");
        String year = request.getParameter("year_of_pub");
        String summary = request.getParameter("summary");
        boolean delete = request.getParameter("delete") != null;
        Entity book = EntityFactory.getEntitySet("book").getEntity(book_id);
        result = result && book.setAttribute("title", title);
        result = result && book.setAttribute("isbn", isbn);
        result = result && book.setAttribute("author", author);
        result = result && book.setAttribute("summary", summary);
        result = result && book.setAttribute("year_of_pub", year);
        result = result && book.delete(delete);
        try ( PrintWriter out = response.getWriter()) {
            out.print("<script>");
            if (result == true) {
                out.print("alert('Update success!');");
            } else {
                out.print("alert('Update failed! Contact the admin for support!');");
            }
            out.print("window.location.href = './index'l </script>");
        }
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
