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
            int curpage = 1;
            int maxpage = 0;
            int book_per_page = 5;
            try{
                curpage = Integer.parseInt((String)request.getParameter("page"));
            } catch(Exception ex) {
                curpage = 1;
            }
            if(curpage < 1)request.getRequestDispatcher("./notfound.html");
            
            //function : search book based on title and author
            Predicate<Entity> title_n_author_search = (b)->{                
                boolean title_match = b.getAttribute("title")
                                        .toLowerCase()
                                        .contains(searchString.toLowerCase());
                boolean author_match = b.getAttribute("author")
                                        .toLowerCase()
                                        .contains(searchString.toLowerCase());
                boolean isbn_match = b.getAttribute("isbn").equals(searchString);
                return title_match || author_match || isbn_match;
            };
            
            if (searchString != null) {
                books = EntityFactory.getEntitySet("book")
                            .searchResult(title_n_author_search);
            } else {
                books = EntityFactory.getEntitySet("book").all();
            }
           maxpage = (int) Math.floor(books.length / book_per_page) + 1;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Library</title>
    </head>        
    <body>     
       
        <%@ include file="WEB-INF/jspf/header.jspf" %>
        <form id="bookSearchBar" action="./index">
            <input type="text" 
                   name="query" 
                   placeholder="Search for a book..."                    
                   value="<%=searchString!=null?searchString:""%>"                   
                   class="searchBar"/>        
        </form>
        <nav id="page">
            <a href ="./index?query=<%=searchString!=null?searchString:""%>&page=<%=curpage-1%>"
            <% if(curpage == 1) { %> class='inactive' <% } %>            
            > Previous </a>                     
            <span><%=curpage%></span>
            <a href ="./index?query=<%=searchString!=null?searchString:""%>&page=<%=curpage+1%>"
            <% if(curpage >= maxpage) { %> class='inactive' <% } %>            
            > Next </a> 
        </nav>
        <section id="books">            
            <% int bookCount = 0;
            for (int i = book_per_page * (curpage-1); i < books.length; ++i) {
                if(books[i].isDeleted() && (role == null || role.equals("reader")))
                    continue;
                if(bookCount >= book_per_page) break;                
                String bookid = books[i].getAttribute("id");    
                ++ bookCount;
            %>            
                <article id="bookid_<%=bookid%>"
                        class="clickable"
                        style="cursor: pointer;" 
                        onclick="window.location.href = 'book.jsp?book_id=<%=bookid%>'">
                    <img src="http://lgimages.s3.amazonaws.com/nc-sm.gif" 
                            alt="cover"/>
                    <summary class="book_desc">
                        <h3><%=books[i].getAttribute("title")%> 
                            - <%=books[i].getAttribute("year_of_pub").split("-")[0]%></h3>                   
                        <%=books[i].getAttribute("summary")%> <br/>                                                 
                    </summary>
                </article>                
            <%}%>         
            <% if(bookCount == 0){ %>
                <h3>No book to show....</h3>
            <% } %>
        </section>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <script <script src="js/defaultStyle.js"></script>        
    </body>
</html>
