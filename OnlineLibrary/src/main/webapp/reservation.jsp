<%-- 
    Document   : reservation
    Created on : 21/08/2023, 5:40:52 AM
    Author     : Nguyen Thuy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin đặt trước</title>
    <style>
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
    </style>
</head>
<body>
    <%@include file="WEB-INF/jspf/header.jspf" %>
    <h1>Thông tin đặt trước</h1>
    <table>
        <tr>
            <th>ID sách</th>
            <th>Tên sách</th>           
            <th>Người đặt trước</th>
            <th>user ID</th>
        </tr>
        <c:forEach var="reservation" items="${reservations}">            
            <tr>
                <td>${reservation.book_id}</td>
                <td>${reservation.bookName}</td>
                <td>${reservation.userName}</td>
                <td>${reservation.user_id}</td>
            </tr>
        </c:forEach>
    </table>
    <script src="js/defaultStyle.js"></script>
</body>
</html>