package java_packages;

import java.util.ArrayList;
import java.util.List;

// Import the service class from the service package
//import java_packages.service;


public class serviceDAO {

    public List<service> getAllServices() {
        List<service> services = new ArrayList<>();
        services.add(new service(1, "Web Development", "Creating responsive and user-friendly websites. Our team utilizes the latest technologies such as HTML5, CSS3, and JavaScript frameworks to deliver cutting-edge web solutions tailored to meet your business needs."));
        services.add(new service(2, "App Development", "Developing custom mobile applications for iOS and Android. From concept to deployment, we focus on delivering apps that provide a seamless user experience, high performance, and scalability."));
        services.add(new service(3, "Network Security", "Ensuring the security of network infrastructure. We offer comprehensive solutions including firewalls, intrusion detection systems, and regular security audits to safeguard your network against cyber threats."));
        services.add(new service(4, "Cloud Computing Solutions", "Empowering businesses with scalable and reliable cloud solutions. Our expertise in cloud platforms like AWS, Azure, and Google Cloud enables us to optimize your cloud infrastructure for performance and cost-efficiency."));
        services.add(new service(5, "Data Analytics", "Unlocking insights from your data to drive informed business decisions. Our data analytics services encompass data collection, cleansing, analysis, and visualization, helping you gain valuable insights into your operations."));
        services.add(new service(6, "IT Consulting", "Providing strategic guidance and technical expertise to help businesses align their IT strategies with their organizational goals. Our consultants work closely with clients to develop custom IT solutions that drive innovation and growth."));
        services.add(new service(7, "Software Development", "Delivering custom software solutions tailored to your unique business requirements. Whether you need a standalone application or integration with existing systems, our team ensures high-quality software development with a focus on usability and scalability."));
        services.add(new service(8, "Digital Marketing", "Boosting your online presence and driving growth through targeted digital marketing strategies. From SEO and SEM to social media marketing and content creation, we help you reach your target audience and achieve your marketing objectives."));
        services.add(new service(9, "UI/UX Design", "Creating engaging and intuitive user interfaces that enhance the user experience and drive customer satisfaction. Our design team combines creativity with usability principles to deliver visually stunning designs that resonate with your audience."));
        return services;
    }
}
