<%-- 
    Document   : login.jsp
    Created on : Aug 15, 2023, 12:38:18 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Online</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    </head>
    <body >
    <div class="wrapper">
        <form class="login" action="login" method="post">
            <p class="heading">Login</p>
            <div class="username">
                <label for="username">Username:</label>
                <input type="text" placeholder="Type your username" id="username" name="username" required=""> 
            </div>
            <div class="password">
                <label for="password">Password:</label>
                <input type="password" placeholder="*****************" id="password" name="password" required=""> 
            </div>
            <div class="remember">
                <input type="checkbox" id="remember" name="remember" > 
                <label for="remember" >Remember Me</label>
            </div>
            <h3 class="error_mess">${error}</h3>
            <button type="submit" class="btn-login"> LOGIN</button>
            <p class="signup">Don't have an account? <a href="signup">Sign up</a></p>
        </form>
    </div>
    </body>
</html>
