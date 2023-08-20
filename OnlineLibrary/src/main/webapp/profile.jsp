<%-- 
    Document   : profile
    Created on : Aug 18, 2023, 2:15:01 PM
    Author     : Huynh Thai Duong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Library Online</title>
    <link rel="stylesheet" href="css/profile.css" />
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
  </head>
<body>
    <%@include  file="WEB-INF/jspf/header.jspf" %>
    <div class="wrapper">
        <div class="profile">
          <a class="back" href="index"><i class="bi bi-house-door"></i> Back home</a>
          <div class="content">
            <button onclick="window.location.href='profile/borrow'">Borrow list</button>
            <button onclick="window.location.href='profile/history'">Borrow History</button>
            <button onclick="window.location.href='profile/reserve'">Reserve confirm</button>
          </div>
        </div>
      </div>
    <<script src="js/defaultStyle.js"></script>
</body>
</html>
