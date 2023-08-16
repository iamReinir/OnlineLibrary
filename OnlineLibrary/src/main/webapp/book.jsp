<%-- 
    Document   : book
    Created on : 09/08/2023, 2:45:34 PM
    Author     : Nguyen Xuan Trung
--%>

<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8" 
    import="model_interface.*, java.util.function.Predicate"%>
<%    
    String user_id = (String) session.getAttribute("user_id");
    String book_id = (String) request.getParameter("book_id");
    
    //This page need a book to display           
    if (book_id == null) {
        request.getRequestDispatcher("./notfound.html").forward(request, response);
    } 
    Entity book = EntityFactory
            .getEntitySet("books")
            .getEntity(book_id);    
    if(book == null)
        request.getRequestDispatcher("./notfound.html").forward(request, response);
    
    // Functions to get the book's reviews 
    // and check whether current user is borrowing this book
    Predicate<Entity> searchForBook = (review)->{
            return review.getAttribute("book_id").equals(book.getAttribute("id"));
    };
    Predicate<Entity> user_is_borrowing_this = (borrowing) ->{
        boolean same_user = borrowing.getAttribute("borrower_id").equals(user_id);
        boolean same_book = borrowing.getAttribute("borrowed_book").equals(book_id);
        return same_user && same_book;
    };
    Entity[] reviews = EntityFactory.getEntitySet("review")
            .searchResult(searchForBook);
    boolean isBorrowing = EntityFactory.getEntitySet("borrowing")
            .searchResult(user_is_borrowing_this).length > 0;
%>
<!DOCTYPE html>
<html>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=book.getAttribute("title")%></title>
    </head>
    <body>                             
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <section id="book">
            <h2><%=book.getAttribute("title")%><h2>
                <img src="http://lgimages.s3.amazonaws.com/nc-sm.gif"
                     alt="cover"/>
                <h3>Summary</h3>
                <p>
                    <%=book.getAttribute("summary")%>
                </p>
                <h3>Author</h3>
                <p>
                    <%=book.getAttribute("author")%>
                </p>
                <h3>Year</h3>
                <p><%=book.getAttribute("year_of_pub")%></p>                        
                <form id="buttonForm">
                    <% if (role != null && isBorrowing) { %>                    
                        <input type="submit" name="renewal" value="Renew borrowing time"/>
                    <% } else if(role != null && !isBorrowing) { %>
                        <input type="submit" name="borrow" value="Borrow this book"/>
                    <% } %>
                </form>
        </section>
        <section id="reviews">    
            <% if(role != null) { %>
            <a class="clickable"
                onclick="document.getElementById('review_form')
                            .style.display = 'block'">
                Leave a review</a>
            <form id="review_form" style="display:none;">
                <textarea 
                    name="review" 
                    placeholder="type your review..."
                    value=""></textarea>
            </form>                
            <% }
            for (int i = 0; i < reviews.length; ++i) {%>
                <div class="review">
                    <img src="http://lgimages.s3.amazonaws.com/nc-sm.gif"
                            alt="avatar"
                            class="avatar"/>
                    <span class="rating">
                        <%= reviews[i].getAttribute("rating")%>
                    </span>
                    <p> 
                        <%=reviews[i].getAttribute("user_review")%> 
                    </p>                
                </div>
            <%}%>
        </section>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <script <script src="js/defaultStyle.js"></script>        
    </body>
</html>
