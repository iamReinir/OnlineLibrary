<%-- 
    Document   : update
    Created on : 18/08/2023, 3:37:39 PM
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
        
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Book</title>
    </head>
    <body>
        <h1> Updating <%=book.getAttribute("title")%>, id=<%=book.getAttribute("id")%></h1>
        <form action="./update" method="POST">            
            <input id="book_id" type="hidden" name="book_id" value="<%=book_id%>"/>
            <label for="title">Title : </label>
            <input id="title" type="text" name="title" 
                   value="<%=book.getAttribute("title")%>"/>
            <br/><label for="isbn">ISBN : </label>
            <input id="isbn" type="text" name="isbn" 
                   value="<%=book.getAttribute("isbn")%>"/>
            <br/><label for="author">author :</label>
            <input id="author" type="text" name="author" 
                   value="<%=book.getAttribute("author")%>"/>
            <br/><label for="year_of_pub">Year :</label>
            <input id="year_of_pub" type="number" start="1000" step="1" name="year_of_pub" 
                   value="<%=book.getAttribute("year_of_pub").split("-")[0]%>"/>
            <br/><label for="summary">Summary : </label>
            <textarea 
                    id="summary"
                    style="resize:none;"
                    name="summary"><%=book.getAttribute("summary")%></textarea>
            <br/><input type="checkbox" name="delete" value="true" id="delete">
            <label for="delete">Mark as delete</label><br/>
            <input type="submit" value="submit"/>            
        </form>
    </body>
</html>
