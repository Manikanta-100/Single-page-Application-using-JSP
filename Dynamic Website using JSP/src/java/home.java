import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class home extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>IT Company</title>");
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
        out.println("<style>");
        out.println(".section {");
        out.println("  margin-bottom: 40px;");
        out.println("  margin-top: 40px;");
        out.println("}");
        out.println(".service-container {");
        out.println("  margin-bottom: 20px;");
        out.println("  padding: 20px;");
        out.println("  border: 1px solid #e0e0e0;");
        out.println("  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body style=\"background-color: #f0f0f0;\">");
        out.println("<header class=\"bg-light py-4\">");
        out.println("<div class=\"container text-center\">");
        out.println("<h1>Welcome to Mani InfoTech</h1>");
        out.println("</div>");
        out.println("</header>");
        out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">");
        out.println("<div class=\"container\">");
        out.println("<div class=\"collapse navbar-collapse\" id=\"navbarNav\">");
        out.println("<ul class=\"navbar-nav\">");
        out.println("<li class=\"nav-item\"><a class=\"nav-link navbar-brand\" href=#>Home</a></li>");
        out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=service.jsp>Services</a></li>");
        out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=contact.jsp>Contact Us</a></li>");
        out.println("</ul>");
        out.println("</div>");
        out.println("</div>");
        out.println("</nav>");

        out.println("<div class=\"container section\">");
        out.println("<div class=\"service-container\">");
        out.println("<h2>Introduction to Our Company</h2>");
        out.println("<p>Welcome to Mani InfoTech. We specialize in providing high-quality IT solutions to businesses of all sizes. With our team of experienced professionals, we offer a wide range of services to meet your technology needs.</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"container section\">");
        out.println("<h2>Our Services</h2>");
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-md-6\">");
        out.println("<div class=\"service-container\">");
        out.println("<h3>Web Development</h3>");
        out.println("<p>Our web development services include creating responsive and user-friendly websites tailored to meet your business objectives. We utilize the latest technologies and industry best practices to deliver high-quality web solutions.</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"col-md-6\">");
        out.println("<div class=\"service-container\">");
        out.println("<h3>Mobile App Development</h3>");
        out.println("<p>We specialize in developing custom mobile applications for iOS and Android platforms. From conceptualization to deployment, we ensure that your mobile app meets the highest standards of performance, usability, and security.</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"col-md-6\">");
        out.println("<div class=\"service-container\">");
        out.println("<h3>Software Development</h3>");
        out.println("<p>Our software development services cover a wide range of technologies and platforms. Whether you need a desktop application, enterprise software, or custom software solutions, we have the expertise to deliver reliable and scalable software solutions.</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"col-md-6\">");
        out.println("<div class=\"service-container\">");
        out.println("<h3>Cloud Computing Solutions</h3>");
        out.println("<p>We offer cloud computing solutions to help businesses leverage the power of the cloud. From cloud migration to infrastructure management, we assist you in harnessing the full potential of cloud technologies to drive innovation and growth.</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");

        // Add the sixth container with the "More..." link in the third row
        out.println("<div class=\"container section\">");
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-md-12\">");
        out.println("<div class=\"service-container\">");
        out.println("<h2>More...</h2>");
        out.println("<p>Click <a href=\"service.jsp\">here</a> to explore more about our services.</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");

        out.println("<div class=\"container section\">");
        out.println("<div class=\"service-container\">");
        out.println("<h2>Our Experiences and Past Projects</h2>");
        out.println("<p>With several years of experience in the IT industry, we have successfully completed numerous projects across various domains. Our expertise and past projects speak volumes about our capabilities and commitment to delivering excellence.</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("<footer class=\"bg-light py-4\">");
        out.println("<div class=\"container text-center\">");
        out.println("<p>&copy; 2024 Mani InfoTech. All rights reserved.</p>");
        out.println("</div>");
        out.println("</footer>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>");
        out.println("</body>");
        out.println("</html>");
    }
}
