<%-- 
    Document   : book
    Created on : 09/08/2023, 2:45:34 PM
    Author     : Nguyen Xuan Trung
--%>

<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8" 
    import="model_interface.*, java.util.function.Predicate"%>
<%@include file="WEB-INF/jspf/libraries.jspf" %>
<%    
    String user_id = (String) session.getAttribute("user_id");
    String book_id = (String) request.getParameter("book_id");
    
    //This page need a book to display           
    if (book_id == null) {
        request.getRequestDispatcher("./notfound.html").forward(request, response);
    } 
    Entity book = EntityFactory
            .getEntitySet("book")
            .getEntity(book_id);    
    if(book == null)
        request.getRequestDispatcher("./notfound.html").forward(request, response);
    
    // Functions to get the book's reviews 
    // and check whether current user is borrowing this book
    Predicate<Entity> searchForBook = (review)->{
            return review.getAttribute("book_id").equals(book_id);
    };
    Predicate<Entity> user_is_borrowing_this = (borrowing) ->{
        boolean same_user = borrowing.getAttribute("borrower_id").equals(user_id);
        boolean same_book = borrowing.getAttribute("borrowed_book").equals(book_id);
        return same_user && same_book;
    };    
    Predicate<Entity> user_has_reserve_this = (reserve) -> {
        boolean same_user = reserve.getAttribute("user_id").equals(user_id);
        boolean same_book = reserve.getAttribute("book_id").equals(book_id);
        return same_user && same_book;
    }; 
    
    // Get data
    Entity[] reviews = EntityFactory.getEntitySet("review")
            .searchResult(searchForBook);
    boolean isBorrowing = EntityFactory.getEntitySet("borrowing")
             .searchResult(user_is_borrowing_this).length > 0;
    boolean currently_request_for_reservation = EntityFactory.getEntitySet("reservation")
            .searchResult(user_has_reserve_this).length > 0;
    boolean show_reserve_button = !currently_request_for_reservation 
            && !isBorrowing;            
    boolean show_renewal_button = isBorrowing;
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
                <p><%=book.getAttribute("summary")%></p>
                <h3>Author</h3>
                <p><%=book.getAttribute("author")%></p>
                <h3>Year</h3>
                <p><%=book.getAttribute("year_of_pub").split("-")[0]%></p>                        
                <form id="buttonForm" action="./reservation">
                    <input type="hidden" name="book_id" value="<%=book_id%>">
                    <% if (role!= null && show_renewal_button) { %>                    
                        <input type="submit" name="renewal" value="Renew borrowing time"/>
                    <% } else if(role!= null && show_reserve_button) { %>
                        <input type="submit" name="reservation" value="Make reservation"/>
                    <% } else if(currently_request_for_reservation) {%>
                    <p> Request for reservation is pending...</p>
                    <%} else if(false) {%>
                    <p> Request for renewal is pending...</p>
                    <%} if(role != null && role.equals("librarian")) {%>
                        <input type="submit" name="update" value="Update this book"/>
                    <% } %>
                </form>
        </section>
        <section id="reviews">    
            <h2>Reviews and ratings:</h2>
            <% if(role != null) { %>
            <p><a class="clickable"
                onclick="document.getElementById('review_form')
                            .style.display = 'block'">
                    Leave a review</a></p>          
            <form id="review_form" method="POST" action="./review" style="display:none;" >                
                <input type="hidden" name="book_id" value="<%=book_id%> "/>
                <div id="rating_form">
                    <input class="star star-5" id="star-5" type="radio" name="rating" value="5" required/>   
                    <label for="star-5" class="fa fa-star"></label>
                    <input class="star star-4" id="star-4" type="radio" name="rating" value="4" required/>
                    <label for="star-4" class="fa fa-star"></label>
                    <input class="star star-3" id="star-3" type="radio" name="rating" value="3" required/>
                    <label for="star-3" class="fa fa-star"></label>
                    <input class="star star-2" id="star-2" type="radio" name="rating" value="2" required/>
                    <label for="star-2" class="fa fa-star"></label>
                    <input class="star star-1" id="star-1" type="radio" name="rating" value="1" required/>    
                    <label for="star-1" class="fa fa-star"></label>
                </div>
                <textarea 
                    style="resize:none;"
                    name="review" 
                    placeholder="type your review..."
                    value=""></textarea>
                <input type="submit" value="Submit"/>
            </form>                
            <% } else { %>              
            <p> Login to leave a review! </p>
            <% }            
            for (int i = 0; i < reviews.length; ++i) {
                String userid = reviews[i].getAttribute("user_id");
            %>
                <div class="review">
                    <div class="avatarContainer">
                        <img src="http://lgimages.s3.amazonaws.com/nc-sm.gif"
                                alt="avatar"
                                class="avatar"/>
                    </div>
                    <div class="contentContainer">
                        <h3> <%= 
                            EntityFactory.getEntitySet("user")
                                .searchResult(user->{
                                    return user.getAttribute("id").equals(userid);
                                })[0].getAttribute("username") 
                        %> </h3>
                        <span class="rating">
                            Rating: <%= reviews[i].getAttribute("rating")%> / 5
                        </span>
                        <p> 
                            <%=reviews[i].getAttribute("user_review")%> 
                        </p>                
                    </div>
                </div>
            <%}%>
        </section>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <script <script src="js/defaultStyle.js"></script>        
    </body>
</html>
