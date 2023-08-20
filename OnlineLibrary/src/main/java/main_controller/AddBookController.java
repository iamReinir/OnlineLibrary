package main_controller;

import DAO.MethodBook;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nguyen Thuy - edit Nguyen Xuan Trung
 */
@WebServlet(name = "AddBookController", urlPatterns = {"/add"})
public class AddBookController extends HttpServlet {
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
        response.sendRedirect("./addbook.html");
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
        try ( PrintWriter out = response.getWriter()) {
            String role = (String) request.getSession().getAttribute("role");
            if (role == null || role.equals("reader")) {
                response.sendRedirect("./logout");
            }
            request.setCharacterEncoding("UTF-8");
            String title = request.getParameter("title");
            String isbn = request.getParameter("isbn");
            String author = request.getParameter("author");
            String year = request.getParameter("year_of_pub");
            String summary = request.getParameter("summary");
            String download_link = request.getParameter("download_link");
            out.print("<script>");
            if (MethodBook.Addbook(isbn, title, author, year, summary, download_link)) {
                out.print("alert('Add successfully!');");
                out.print("window.location.href = './index';");
            } else
                out.print("alert('Add failed! Contact your administrator for support!');");

            out.print("</script>");
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
    }
}
