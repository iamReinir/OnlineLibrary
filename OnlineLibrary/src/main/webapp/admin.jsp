<%-- 
    Document   : admin.jsp
    Created on : Aug 20, 2023, 1:08:45 AM
    Author     : Raiku
--%>

<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Page</title>
        <style>
            body {
                width: 100%;
                font-family: Arial, sans-serif;
                display:flex;
                align-items:center;
                justify-content: space-between;
                flex-direction:column;
                margin: 0;
                padding: 0;
                background-color: #f7f7f7;
            }

            h1 {
                margin-bottom: 0;
                text-align: center;
            }

            #content {
                margin-right: 1rem;
                display: flex;
                justify-content: space-between;
            }

            .form-css {
                background-color: white;
                padding: 2rem;
                border-radius: 5px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                width: 250px;
            }

            table {
                width: 100%;
                margin-right: 1rem;
                border-collapse: collapse;
                background-color: white;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            th, td {
                border: 1px solid #e0e0e0;
                padding: 0.5rem;
                text-align: center;
            }

            th {
                background-color: #f0f0f0;
            }

            tr:nth-child(even) {
                background-color: #f7f7f7;
            }

            select, input[type="text"], input[type="password"] {
                width: 100%;
                padding: 0.5rem;
                margin-bottom: 1rem;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 1rem;
            }

            input[type="submit"] {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 0.5rem 0.5rem;
                border-radius: 4px;
                cursor: pointer;
                font-size: 1rem;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <a href="./logout">Logout</a>
        <h1>Welcome, Admin!</h1>
        <div id="content">
            <div>
                <div>
                    <h3>Add User</h3>
                    <form class="form-css" action="addUser" method="post">
                        <div>
                            <label for="username">Username:</label>
                            <input type="text" id="username" name="username" required><br>
                        </div>
                        <div>
                            <label for="password">Password:</label>
                            <input type="password" id="password" name="password" required><br>
                        </div>
                        <div><label for="mail">Email:</label>
                            <input type="text" id="mail" name="mail" required><br></div>
                        <div><label for="phone">Phone:</label>
                            <input type="text" id="phone" name="phone" required><br></div>

                        <select id="role" name="role">
                            <option value="reader" selected="">reader</option>
                            <option value="librarian">librarian</option>
                            <option value="admin">admin</option>
                        </select>
                        <br>
                        <input type="submit" value="Add User">
                    </form>

                    <h3>Mark User as inactive</h3>
                    <form class="form-css" action="removeUser" method="post">
                        <label for="userId">User ID:</label>
                        <input type="text" id="userId" name="userId" required><br>
                        <input type="submit" value="Remove User">
                    </form>
                </div>
            </div>

            <div>

                <h3>List User</h3>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Telephone Number</th>
                            <th>Role</th>
                            <th>Register Date</th>
                            <th>Last Modified At</th>
                            <th>Is delete?</th>
                        </tr>
                    </thead>
                    <tbody id="table-body">
                        <% ArrayList<User> list = (ArrayList<User>) request.getSession().getAttribute("listUser");
                        if(list != null) for (User u : list) {%>
                        <tr>
                            <td><%=u.getId()%></td>
                            <td><%=u.getUsername()%></td>
                            <td><%=u.getEmail()%></td>
                            <td><%=u.getTelephone_number()%></td>
                            <td><%=u.getRole()%></td>
                            <td><%=u.getRegister_date()%></td>
                            <td><%=u.getLast_modified_at()%></td>
                            <td><%=u.getIs_delete()%></td>       
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
