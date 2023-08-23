<%-- 
    Document   : booklist
    Created on : 21/08/2023, 5:12:05 PM
    Author     : Nguyen Xuan Trung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book List</title>
    <link rel="stylesheet" href="css/books.css"/>
</head>
<body>
    <%@include file="WEB-INF/jspf/header.jspf" %>
    <form id="bookSearchBar" action="./index">
            <input type="text" 
                   name="query" 
                   placeholder="Search for a book..."                    
                   value="${param.query}"                   
                   class="searchBar"/>        
        </form>
    <nav id="page">
        <c:if test="${curpage > 1}">
            <a href ="./mainpage?query=${param.query}&page=${curpage-1}"> Previous </a>         
        </c:if>            
            <span>${curpage}</span>
        <c:if test="${curpage < maxpage}">
            <a href ="./mainpage?query=${param.query}&page=${curpage+1}"> Next </a>         
        </c:if>  
        </nav>
    <section id="books">
        <c:forEach var='book' items='${list_of_book}'>
            <section id="book">
                <article id="bookid_${book.id}>"
                    class="clickable"
                    style="cursor: pointer;" 
                    onclick="window.location.href = 'book?book_id=${book.id}'">
                <img src="http://lgimages.s3.amazonaws.com/nc-sm.gif" 
                        alt="cover"/>
                <summary class="book_desc">
                    <h3>${book.title} - ${book.year_of_pub}</h3>                   
                    ${book.summary} <br/>                                                 
                </summary>
                </article>
            </section>
        </c:forEach>
    </section>
    <%@include file="WEB-INF/jspf/footer.jspf" %>
    <<script src="js/defaultStyle.js"></script>
</body>
</html>
