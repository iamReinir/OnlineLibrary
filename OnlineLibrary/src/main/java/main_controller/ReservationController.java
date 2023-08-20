/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package main_controller;

import DAO.Reservation;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Nguyen Thuy
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
        response.setContentType("text/html;charset=UTF-8");
        // Tạo một danh sách (ArrayList) chứa thông tin người đặt trước
        ArrayList<Reservation> reservations = new ArrayList<>();
        Entity[] dbReservate = EntityFactory.getEntitySet("reservation").all();
        for (Entity e : dbReservate) {
            reservations.add(new Reservation(e.getAttribute("id"),
                    e.getAttribute("user_id"),
                    e.getAttribute("book_id"),
                    e.getAttribute("is_accept"),
                    e.getAttribute("request_date"),
                    e.getAttribute("accept_date"),
                    e.isDeleted(),
                    e.getAttribute("last_modified_at"))
            );
        }
        // Thêm các thông tin đặt trước khác vào danh sách

        // Truyền danh sách vào trang JSP
        request.setAttribute("reservations", reservations);

        // Forward yêu cầu sang trang JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/reservation.jsp");
        dispatcher.forward(request, response);
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
