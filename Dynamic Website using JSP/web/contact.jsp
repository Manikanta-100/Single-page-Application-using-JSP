<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .section {
            margin-bottom: 40px;
        }

        .contact-section {
            margin-top: 40px;
        }

        .contact-info {
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .inquiry-form {
            padding: 20px;
            border: 1px solid #e0e0e0;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
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
                <li class="nav-item"><a class="nav-link" href="service.jsp">Services</a></li>
                <li class="nav-item"><a class="nav-link navbar-brand" href="#">Contact Us</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="contact-section">
        <h2>Contact Us</h2>
        <div class="row">
            <div class="col-md-6">
                <div class="contact-info">
                    <h3>Contact Information</h3>
                    <p>Address: 123 Main St, Ananthapur, India</p>
                    <p>Email: info@maniinfotech.com</p>
                    <p>Phone: +91 7013964713</p>
                </div>
            </div>
            <div class="col-md-6">
                <div class="inquiry-form">
                    <h3>Inquiry Form</h3>
                    <form action="submit_inquiry.jsp" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Your Name</label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Your Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="subject" class="form-label">Subject</label>
                            <input type="text" class="form-control" id="subject" name="subject" required>
                        </div>
                        <div class="mb-3">
                            <label for="message" class="form-label">Message</label>
                            <textarea class="form-control" id="message" name="message" rows="5" required></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
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
