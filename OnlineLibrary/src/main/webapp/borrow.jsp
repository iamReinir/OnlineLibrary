<%-- 
    Document   : borrow
    Created on : 20/08/2023, 7:11:20 AM
    Author     : Giga P34
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="model_interface.*, java.util.function.Predicate" %>

<%
    String book_id = request.getParameter("book_id");
    //This page need a book to display           
    if (book_id == null) {
        request.getRequestDispatcher("./notfound.html").forward(request, response);
    } 
    Entity book = EntityFactory
            .getEntitySet("book")
            .getEntity(book_id);    
    if(book == null)
        request.getRequestDispatcher("./notfound.html").forward(request, response);    
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrow Book</title>
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
            <p><%=book.getAttribute("year_of_pub")%></p> 

            <% String download = book.getAttribute("download_link");
            System.out.println("download:" + download);
            if( download != null && !download.isEmpty()) { %>
                <h3><a href ='<%=download%>'>Download</a></h3>
            <% } if(role != null && role.equals("librarian")) { %>
                <h3>Is delete ? <%=book.isDeleted()?"yes":"no"%></h3>
            <% } %>
        </section>  
        <section id="borrowForm">
            <form id="userToLend" action="./borrow" method="POST">
                <input type="hidden" name="book_id" value="<%=book_id%>" /> 
                <label for="username">Username to lend</label>
                <input id="username" type="text" name="username" /> 
                <label for="returnDate">Return date</label>
                <input id="returnDate" type="date" name="return_date" />
                <input id="submit" type="submit"/>
            </form>
        </section>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <script src="js/defaultStyle.js"></script>
    </body>
</html>
