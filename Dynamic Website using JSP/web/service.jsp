<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java_packages.service, java_packages.serviceDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Services</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .section {
            margin-bottom: 40px;
        }

        .service-container {
            margin-bottom: 20px;
            padding: 20px;
            border: 1px solid #e0e0e0;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease-in-out;
        }

        .service-container:hover {
            transform: translateY(-5px);
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
        }
        
        h2{
            margin: 20px;
        }
    </style>
</head>
<body>
<header class="bg-light py-4">
    <div class="container text-center">
        <h1>Welcome to Mani InfoTech</h1>
    </div>
</header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="home">Home</a></li>
                <li class="nav-item"><a class="nav-link navbar-brand" href="#">Services</a></li>
                <li class="nav-item"><a class="nav-link" href="contact.jsp">Contact Us</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container section">
    <h2>Our Services</h2>
    <div class="row">
        <% serviceDAO serviceDAO = new serviceDAO();
           List<service> services = serviceDAO.getAllServices();
           for (service service : services) { %>
        <div class="col-md-4">
            <div class="service-container">
                <!--<h3>Service ID: <%= service.getId() %></h3>-->
                <h4><%= service.getName() %></h4>
                <p><%= service.getDescription() %></p>
            </div>
        </div>
        <% } %>
    </div>
</div>
<footer class="bg-light py-4">
    <div class="container text-center">
        <p>&copy; 2024 Mani InfoTech. All rights reserved.</p>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
