package main_controller;

import DAO.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Predicate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model_interface.Entity;
import model_interface.EntityFactory;

/**
 *
 * @author Nguyen Xuan Trung
 */
@WebServlet(name = "MainPageController", urlPatterns = {"/mainpage"})
public class MainPageController extends HttpServlet {
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
            HttpSession session = request.getSession();
            String searchString = (String) request.getParameter("query");
            Entity[] books = null;
            int curpage = 1;
            int maxpage = 0;
            int book_per_page = 5;
            try {
                curpage = Integer.parseInt((String) request.getParameter("page"));
            } catch (Exception ex) {
                curpage = 1;
            }
            if (curpage < 1) {
                request.getRequestDispatcher("./notfound.html");
            }

            //function : search book based on title and author
            Predicate<Entity> title_n_author_search = (b) -> {
                boolean title_match = b.getAttribute("title")
                        .toLowerCase()
                        .contains(searchString.toLowerCase());
                boolean author_match = b.getAttribute("author")
                        .toLowerCase()
                        .contains(searchString.toLowerCase());
                boolean isbn_match = b.getAttribute("isbn").equals(searchString);
                boolean allow_to_view = !b.isDeleted();
                return (title_match || author_match || isbn_match) && allow_to_view;
            };

            if (searchString != null) {
                books = EntityFactory.getEntitySet("book")
                        .searchResult(title_n_author_search);
            } else {
                books = EntityFactory.getEntitySet("book").searchResult(b -> {
                    return !b.isDeleted();
                });
            }
            maxpage = (int) Math.ceil(books.length / (double) book_per_page);

            ArrayList<Book> booklist = new ArrayList();
            int start_book = book_per_page * (curpage - 1);
            int end_book = start_book + book_per_page - 1;
            if (end_book >= books.length) {
                end_book = books.length - 1;
            }
            for (int i = start_book; i <= end_book && i < books.length; ++i) {
                Entity x = books[i];
                Book newb = new Book(x);
                booklist.add(newb);
            }
            request.setAttribute("list_of_book", booklist);
            request.setAttribute("curpage", curpage);
            request.setAttribute("maxpage", maxpage);
            request.getRequestDispatcher("./booklist.jsp").forward(request, response);
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
