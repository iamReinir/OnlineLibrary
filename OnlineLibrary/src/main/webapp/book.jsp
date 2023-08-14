<%-- 
    Document   : book
    Created on : 09/08/2023, 2:45:34 PM
    Author     : Giga P34
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <h1>Book view of <%=request.getParameter("book_id")%></h1>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <script <script src="js/defaultStyle.js"></script>        
    </body>
</html>
