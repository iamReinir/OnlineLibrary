package main_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Nguyen Xuan Trung
 */
@WebServlet(name = "ReviewController", urlPatterns = {"/review"})
public class ReviewController extends HttpServlet {

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

    }

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
        try {
            //PrintWriter out = response.getWriter();
            request.setCharacterEncoding("UTF-8");
            String review = request.getParameter("review");
            String user_id = (String) request.getSession().getAttribute("user_id");
            if (user_id == null || user_id.isEmpty()) {
                response.sendRedirect("./login");
                return;
            }
            String book_id = request.getParameter("book_id");
            String rating = request.getParameter("rating");
            Entity newReview = EntityFactory.createEntity("review");
            newReview.setAttribute("user_id", user_id);
            newReview.setAttribute("book_id", book_id);
            newReview.setAttribute("user_review", review);
            newReview.setAttribute("rating", rating);
            EntityFactory.getEntitySet("review").add(newReview);
            response.sendRedirect("./book?book_id=" + book_id);
        } catch (Exception ex) {
            request.getRequestDispatcher("notfound.html").forward(request, response);
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
