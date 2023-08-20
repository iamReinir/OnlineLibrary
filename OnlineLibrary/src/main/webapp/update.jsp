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
        <style>
            html{
                font-size: 30px;
                padding:2rem;                
            }      
            
            input{
                font-size: 1rem;
                margin: 0.2rem;
                width:fit-content;
            }            
            textarea{
                width: 30rem;
                height: 10rem;
            }
            select, input[type="text"], input[type="password"] {
                width: 100%;
                padding: 0.5rem;
                margin-bottom: 1rem;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 1rem;
            }

            input[type="submit"] {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 0.5rem 0.5rem;
                border-radius: 4px;
                cursor: pointer;
                font-size: 1rem;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }
            form,h1,h2{
                margin:2rem;
            }
            
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <h1><%=book.getAttribute("title")%></h1>
          <h2>id=<%=book.getAttribute("id")%></h2>
        <form action="./update" method="POST">
            
            <input id="book_id" type="hidden" name="book_id" value="<%=book_id%>"/>
            
            <label for="title">Title : </label>
            <input id="title" type="text" name="title" 
                   value="<%=book.getAttribute("title")%>"/>
            
            <br/><label for="isbn">ISBN : </label>
            <input id="isbn" type="text" name="isbn" 
                   value="<%=book.getAttribute("isbn")%>"/>
            
            <br/><label for="author">Author :</label>
            <input id="author" type="text" name="author" 
                   value="<%=book.getAttribute("author")%>"/>
            
            <br/><label for="year_of_pub">Year :</label>
            <input id="year_of_pub" type="number" min="1000" step="1" name="year_of_pub" 
                   value="<%=book.getAttribute("year_of_pub").split("-")[0]%>"/>
            
            <br/><label for='download_link'>Download link:</label>
            <input id="download_link" type='text' name="download_link"
                   value="<%=book.getAttribute("download_link")%>"/>
            
            <br/><label for="summary">Summary : </label><br/>
            <textarea 
                    id="summary"
                    style="resize:none;"
                    name="summary"><%=book.getAttribute("summary")%></textarea>
            <br/><input type="checkbox" name="delete" value="true" id="delete"
                        <%=book.isDeleted()?"checked" :""%>>
            <label for="delete">Mark as delete</label><br/>
            <input type="submit" value="Update"/>            
        </form>
            <script src="js/defaultStyle.js"></script>
    </body>
</html>
