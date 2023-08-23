package main_controller;

import DAO.ReservationDAO;
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
 * @author Nguyen Xuan Trung
 */
@WebServlet(name = "ReservationAddController", urlPatterns = {"/addReservation"})
public class ReservationAddController extends HttpServlet {

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

            out.print("<script>");
            String user_id = (String) request.getSession().getAttribute("user_id");
            String book_id = request.getParameter("book_id");
            boolean isCancel = request.getParameter("reservationCancel") != null;

            if (isCancel) {
                if (ReservationDAO.cancel(book_id, user_id)) {
                    out.print("alert('Your reservation is canceled!');");
                } else {
                    out.print("alert('Cannot cancel your request!"
                            + " Please contact your admin for support.');");
                }
                out.print("window.location.href = './book?book_id=" + book_id + "';");
                out.print("</script>");
                return;
            }
            if (ReservationDAO.curentlyReserving(user_id, book_id)) {
                out.print("alert('You already has a reservation on this book!');");
                out.print("window.location.href = './book?book_id=" + book_id + "';");
                out.print("</script>");
                return;
            } else if (ReservationDAO.add(book_id, user_id)) {
                out.print("alert('Your reservation is recorded and pending!');");
            } else {
                out.print("alert('Cannot save your request!"
                        + " Please contact your admin for support.');");
            }
            out.print("window.location.href = './book?book_id=" + book_id + "';");
            out.print("</script>");
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
