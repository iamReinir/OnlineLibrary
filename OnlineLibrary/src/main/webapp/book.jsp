<%-- 
    Document   : book
    Created on : 09/08/2023, 2:45:34 PM
    Author     : Nguyen Xuan Trung
--%>

<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8" %>
<%@include file="WEB-INF/jspf/libraries.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${this_book.title}</title>
    </head>
    <body>                             
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <section>
            <%@include file="WEB-INF/jspf/bookview.jspf" %>
            <form id="buttonForm" action="./request">
                    <p id="notif">${notif}</p>
                    <input type="hidden" name="book_id" value="${this_book.id}">
                    <c:if test="${isReader && user_option != null}">
                    <input type="submit" name="${option_type}" value="${user_option}"/>                                         
                    </c:if>

                    <c:if test="${isLibrarian}">
                    <input type="submit" name="update" value="Update this book"/>                                                             
                    <input type="submit" name="${librarian_option_type}" value="${librarian_option}"/>                                                                    
                    </c:if>                    
            </form>
        </section>                       
        <%@include file="WEB-INF/jspf/commentSection.jspf" %>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <script <script src="js/defaultStyle.js"></script>        
    </body>
</html>
