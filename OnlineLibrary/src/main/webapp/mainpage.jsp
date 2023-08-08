<%-- 
    Document   : mainpage
    Created on : 08/08/2023, 2:52:22 PM
    Author     : Nguyen Xuan Trung
--%>

<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8" 
    import="model_interface.*, java.util.function.Predicate" %>
<%@include file="WEB-INF/jspf/libraries.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Library</title>
        <link href="css/header.css" rel="stylesheet">
        
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header.jspf" %>
        <form>
            <input type="text" name="query" placeholder="Search for a book..."/>
        </form>                    
        <section id="books">
        <%
        Entity[] books = EntityFactory.getEntitySet("book").all();                            
        for(int i = 0; i<books.length;++i) { %>            
        <div id="book">
            <img 
                src="https://www.claws.in/static/book-cover-placeholder-e1563706855534.jpg" 
                alt="cover"/>
            <div id="book_desc">
                <h3><%=books[i].getAttribute("title")%></h3>
                <p>
                    <%=books[i].getAttribute("author") 
                            + " " + books[i].getAttribute("year") %>
                </p>
            </div>
        </div>                
        <%} %>
        </section>
        <script <script src="js/mainpage.js"></script>
    </body>
</html>
