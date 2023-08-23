

<%-- 
    Document   : login.jsp
    Created on : Aug 15, 2023, 12:38:18 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Library Online</title>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
    />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    
    <style>
            * {
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }

    .wrapper {
        background-image: linear-gradient(-30deg, rgba(210, 251, 243, 1), white);
        height: 100vh;
        width: 100%;
        position: relative;
        font-family: 'Poppins', sans-serif;
    }

    .profile {
        border: 1px solid #E5E5E5;
        border-radius: 25px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 1000px;
        height: 600px;
        background-color: #FFFFFF;
        display: flex-box;
    }

    .back {
        height: 30px;
        width: 140px;
        margin-left: 10px;
        text-decoration: none;
        color: rgb(0, 139, 139);
    }

    .content {
        margin-left:0;
    }

    .card { 
        margin: 0 20px;
        padding: 0;
    }

    .card img {
        width: 260px;
        height: 300px;

    }

    .paging {
        margin-top: 50px;
        display: flex;
        justify-content: center;
    }

    </style>
  </head>
    <body>
    <div class="wrapper">
      <div class="profile">
        <a class="back " href="../index"><i class="bi bi-house-door"></i> Back home</a>

        <div class="containner">
          <div class="borrow-list">
            <h5 style="margin-top: 20px; margin-left: 10px;">History List:</h5>
            <div class="content row">
                <c:forEach items="${requestScope.listBook}" var="b">
                    <div class="card col-md-4" style="width: 18rem;">
                        <img src="image/no-avatar.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${b.getTitle()}</h5>
                        </div>
                    </div>
                </c:forEach>
            </div>
          </div>
          <nav aria-label="Page navigation example" class="paging">
            <ul class="pagination">
              <li class="page-item"><a class="page-link" href="#">Previous</a></li>
              <li class="page-item"><a class="page-link" href="borrow?page=1">1</a></li>
              <li class="page-item"><a class="page-link" href="borrow?page=2">2</a></li>
              <li class="page-item"><a class="page-link" href="borrow?page=3">3</a></li>
              <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </body>
</html>
