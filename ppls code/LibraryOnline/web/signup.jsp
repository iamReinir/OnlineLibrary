<%-- 
    Document   : signup
    Created on : Aug 17, 2023, 10:17:06 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Online</title>
    <link rel="stylesheet" href="css/signup.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body >
    <div class="wrapper">
        <form class="signup" action="signup" method="post">
            <p class="heading">Sign up</p>
            <div class="email">
                <label for="username">Email address:</label>
                <input type="email" placeholder="Type your email" id="email" name="email" required=""> 
            </div>
            <div class="username">
                <label for="username">Username:</label>
                <input type="text" placeholder="Type your username" id="username" name="username" required=""> 
            </div>
            <div class="password">
                <label for="password">Password:</label>
                <input type="password" placeholder="*****************" id="password" name="password" required=""> 
            </div>
            <div class="repeat-password">
                <label for="repeat_password">Repeat Password: </label>
                <input type="password" placeholder="*****************" id="repeat_password" name="repeat_password" required=""> 
            </div>
            <h3 class="error_mess">${exist}</h3>
            <h3 class="error_mess">${error}</h3>
            <button type="submit" class="btn-signup"> SIGN UP</button>
            <a href="login" class="login">Log in</a>
        </form>
        
    </div>
</body>
</html>