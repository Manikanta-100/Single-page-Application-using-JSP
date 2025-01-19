
import java.sql.*;
import java.util.Scanner;

public class prac {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    public static Connection conn = null;
    public static Statement stmt = null;
    public static Scanner s = new Scanner(System.in);

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            createEmployeeTable();

            while (true) {
                System.out.println("1. Add Employee");
                System.out.println("2. View Employee Details");
                System.out.println("3. View All Employees");
                System.out.println("4. Update Employee");
                System.out.println("5. Delete Employee");
                System.out.println("6. Generate Pay Slip");
                System.out.println("7. Employees with salary above 10 LPA");
                System.out.println("8. Exit");

                System.out.print("Enter your choice: ");
                int choice = s.nextInt();

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployeeDetails();
                        break;
                    case 3:
                        viewEmployees();
                        break;
                    case 4:
                        updateDetails();
                        break;
                    case 5:
                        deleteEmployee();
                        break;
                    case 6:
                        generatePaySlip();
                        break;
                    case 7:
                        salaryGT10();
                        break;
                    case 8:
                        conn.close();
                        stmt.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createEmployeeTable() throws SQLException {

        String query = "CREATE TABLE IF NOT EXISTS Employee("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "department VARCHAR(255),"
                + "designation VARCHAR(255),"
                + "salary DOUBLE,"
                + "hire_date DATE)";
        stmt.executeUpdate(query);
    }

    public static void addEmployee() throws SQLException {
        System.out.print("Enter employee name: ");
        String name = s.next();
        System.out.print("Enter department: ");
        String department = s.next();
        System.out.print("Enter designation: ");
        String designation = s.next();
        System.out.print("Enter salary: ");
        double salary = s.nextDouble();
        System.out.print("Enter hire date (YYYY-MM-DD): ");
        String hireDate = s.next();

        String query = "INSERT INTO Employee values(?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.setString(3, designation);
            pstmt.setDouble(4, salary);
            pstmt.setDate(5, Date.valueOf(hireDate));
            pstmt.executeUpdate();
            System.out.println("Employee added successfully...!");
        }
    }

    private static void viewEmployeeDetails() throws SQLException {
        System.out.print("Enter the Employeee ID:");
        int id = s.nextInt();

        String query = "SELECT * FROM Employee WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Designation: " + rs.getString("designation"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("Hire Date: " + rs.getDate("hire_date"));
                System.out.println("----------------------");
            }
        }
    }

    private static void viewEmployees() throws SQLException {
        String query = "SELECT * FROM Employee";
        
        ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Designation: " + rs.getString("designation"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("Hire Date: " + rs.getDate("hire_date"));
                System.out.println("----------------------");
            }
    }

    private static void updateDetails() throws SQLException {
        String query = "SELECT * FROM Employee WHERE id=?";
        
    }

    private static void deleteEmployee() throws SQLException {

    }

    private static void generatePaySlip() throws SQLException {

    }

    private static void salaryGT10() throws SQLException {

    }
}
