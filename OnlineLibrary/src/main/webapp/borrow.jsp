<%-- 
    Document   : borrow
    Created on : 20/08/2023, 7:11:20 AM
    Author     : Giga P34
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="model_interface.*, java.util.function.Predicate" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrow Book</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>        
        <section id="borrowForm">
            <form id="userToLend" action="./borrow" method="POST">
                <input type="hidden" name="book_id" value="${this_book.id}" /> 
                <label for="username">Username to lend</label>
                <input id="username" type="text" name="username" /> 
                <label for="returnDate">Return date</label>
                <input id="returnDate" type="date" name="return_date" />
                <input id="submit" type="submit"/>
            </form>
        </section>
                <%@include file="WEB-INF/jspf/bookview.jspf" %>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <script src="js/defaultStyle.js"></script>
    </body>
</html>
