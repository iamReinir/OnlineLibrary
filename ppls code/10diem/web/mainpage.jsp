<%-- 
    Document   : mainpage
    Created on : 08/08/2023, 2:52:22 PM
    Author     : Nguyen Xuan Trung
--%>

<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8" 
    import="model_interface.*, java.util.function.Predicate" %>
 <% 
            String searchString = (String) request.getParameter("query");                        
            Entity[] books = null;
            
            //function : search book based on title and author
            Predicate<Entity> title_n_author_search = (b)->{
                boolean title_match = b.getAttribute("title")
                                        .toLowerCase()
                                        .contains(searchString.toLowerCase());
                boolean author_match = b.getAttribute("author")
                                        .toLowerCase()
                                        .contains(searchString.toLowerCase());
                return title_match || author_match;
            };
            
            if (searchString != null) {
                books = EntityFactory.getEntitySet("book")
                            .searchResult(title_n_author_search);
            } else {
                books = EntityFactory.getEntitySet("book").all();
            }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Library</title>
    </head>        
    <body>     
       
        <%@ include file="WEB-INF/jspf/header.jspf" %>
        <form id="bookSearchBar">
            <input type="text" 
                   name="query" 
                   placeholder="Search for a book..."                    
                   value="<%=searchString!=null?searchString:""%>"                   
                   class="searchBar"/>
        </form>
        <nav id="booksNav">            
        </nav>
        <section id="books">
            <% if(books == null || books.length == 0){ %>
                <h3>No book to show....</h3>
            <% }
            for (int i = 0; i < books.length; ++i) {
                String bookid = books[i].getAttribute("id");
            %>            
                <article id="bookid_<%=bookid%>"
                        class="clickable"
                        style="cursor: pointer;" 
                        onclick="window.location.href = 'book.jsp?book_id=<%=bookid%>'">
                    <img src="http://lgimages.s3.amazonaws.com/nc-sm.gif" 
                            alt="cover"/>
                    <summary class="book_desc">
                        <h3><%=books[i].getAttribute("title")%></h3>                   
                        <%=books[i].getAttribute("summary")%> <br/>
                        <%=books[i].getAttribute("year_of_pub")%>                         
                    </summary>
                </article>                
            <%}%>            
        </section>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <script <script src="js/defaultStyle.js"></script>        
    </body>
</html>
