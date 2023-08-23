package main_controller;

import DAO.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model_interface.*;

/**
 *
 * @author Nguyen Xuan Trung
 */
@WebServlet(name = "BorrowController", urlPatterns = {"/borrow"})
public class BorrowController extends HttpServlet {

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
            //PrintWriter out = response.getWriter();     
            String role = (String) request.getSession().getAttribute("role");
            int book_id = Integer.parseInt(request.getParameter("book_id").toString());
            if (!role.equals("librarian")) {
                throw new Exception("Not a librarian");
            }
            request.setAttribute("this_book", BookDAO.getBookByID(book_id));
            request.getRequestDispatcher("borrow.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.getRequestDispatcher("notfound.html").forward(request, response);
        }
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
        try {
            PrintWriter out = response.getWriter();
            out.print("<script>");
            String username = request.getParameter("username");
            String book_id = request.getParameter("book_id");
            //Using the ISO yyyy-mm-dd format
            String return_date = request.getParameter("return_date");
            Entity[] rltSet = EntityFactory.getEntitySet("user").searchResult(u -> {
                return u.getAttribute("username").equalsIgnoreCase(username);
            });
            if (rltSet.length < 1) {
                out.print("alert('No user named " + username + " is found. Please retry.');");
                out.print("window.location.href = './borrow?book_id=" + book_id + "';");
                out.print("</script>");
                return;
            }
            Entity bor = EntityFactory.createEntity("borrowing");
            bor.setAttribute("borrower_id", rltSet[0].getAttribute("id"));
            bor.setAttribute("borrowed_book", book_id);
            bor.setAttribute("return_date", return_date);
            if (!EntityFactory.getEntitySet("borrowing").add(bor)) {
                out.print("alert('Error adding a borrowing. Contact your admin for support!');");
            } else {
                out.print("alert('Success!');");
                out.print("window.location.href = './book?book_id=" + book_id + "';");
            }
            out.print("</script>");

        } catch (Exception ex) {
            System.out.println("Error in BorrowController Post");
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
