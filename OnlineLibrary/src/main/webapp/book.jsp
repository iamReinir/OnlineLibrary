<%-- 
    Document   : book
    Created on : 09/08/2023, 2:45:34 PM
    Author     : Nguyen Xuan Trung
--%>

<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8" 
    import="model_interface.*, java.util.function.Predicate"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <% Entity book = EntityFactory
                            .getEntitySet("books")
                            .getEntity(request.getParameter("book_id")); 
        Predicate<Entity> searchForBook = (review)->{
            return review.getAttribute("book_id").equals(book.getAttribute("id"));            
        };
        Entity[] reviews = EntityFactory.getEntitySet("reviews")
                .searchResult(searchForBook);
        %>
             
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <section id="book">
            
            <img src="http://lgimages.s3.amazonaws.com/nc-sm.gif"
                 alt="cover"/>
            <p>
                <%=book.getAttribute("summary")%>
            </p>
            <button>Borrow</button>
        </section>
        <section id="reviews">
            <% for(int i = 0; i < reviews.length;++i){ %>
            <div class="review">
                <img src="http://lgimages.s3.amazonaws.com/nc-sm.gif"
                     alt="avatar"/>
                <span class="rating">
                    <%= reviews[i].getAttribute("rating") %>
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
