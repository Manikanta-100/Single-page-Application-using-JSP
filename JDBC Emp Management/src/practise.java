import java.sql.*;
import java.util.Scanner;

public class practise {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/21mid0056";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) 
    {
        Connection conn = null;
        Statement stmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            createEmployeeTable(stmt); // Create Employee table if not exists

            while (true) {
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Generate Pay Slip");
                System.out.println("6. Employees with salary above 10 LPA");
                System.out.println("7. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addEmployee(conn, scanner);
                        break;
                    case 2:
                        viewEmployees(stmt);
                        break;
                    case 3:
                        updateEmployee(conn, scanner);
                        break;
                    case 4:
                        deleteEmployee(conn, scanner);
                        break;
                    case 5:
                        generatePaySlip(conn, scanner);
                        break;
                    case 6:
                        getEmployeesAbove10LPA(stmt);
                        break;
                    case 7:
                        System.out.println("Exiting program...");
                        conn.close();
                        stmt.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createEmployeeTable(Statement stmt) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Employee (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "department VARCHAR(255)," +
                "designation VARCHAR(255)," +
                "salary DOUBLE," +
                "hire_date DATE)";
        stmt.executeUpdate(createTableSQL);
    }

    private static void addEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter employee name: ");
        String name = scanner.next();
        System.out.print("Enter department: ");
        String department = scanner.next();
        System.out.print("Enter designation: ");
        String designation = scanner.next();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter hire date (YYYY-MM-DD): ");
        String hireDate = scanner.next();

        String insertSQL = "INSERT INTO Employee (name, department, designation, salary, hire_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.setString(3, designation);
            pstmt.setDouble(4, salary);
            pstmt.setDate(5, Date.valueOf(hireDate));
            pstmt.executeUpdate();
            System.out.println("Employee added successfully!");
        }
    }

    private static void viewEmployees(Statement stmt) throws SQLException {
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

    private static void updateEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter employee ID to update: ");
        int employeeId = scanner.nextInt();

        String selectSQL = "SELECT * FROM Employee WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.print("Enter new salary: ");
                double newSalary = scanner.nextDouble();

                String updateSQL = "UPDATE Employee SET salary = ? WHERE id = ?";
                try (PreparedStatement updatePstmt = conn.prepareStatement(updateSQL)) {
                    updatePstmt.setDouble(1, newSalary);
                    updatePstmt.setInt(2, employeeId);
                    updatePstmt.executeUpdate();
                    System.out.println("Employee updated successfully!");
                }
            } else {
                System.out.println("Employee with ID " + employeeId + " not found.");
            }
        }
    }

    private static void deleteEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter employee ID to delete: ");
        int employeeId = scanner.nextInt();

        String deleteSQL = "DELETE FROM Employee WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, employeeId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee with ID " + employeeId + " not found.");
            }
        }
    }

    private static void generatePaySlip(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter employee ID for pay slip: ");
        int employeeId = scanner.nextInt();

        String selectSQL = "SELECT * FROM Employee WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Your pay slip generation logic goes here
                // For simplicity, let's just print the details for now
                System.out.println("Pay Slip for Employee ID " + employeeId);
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Designation: " + rs.getString("designation"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("------------------------------");
            } else {
                System.out.println("Employee with ID " + employeeId + " not found.");
            }
        }
    }

    private static void getEmployeesAbove10LPA(Statement stmt) throws SQLException {
        String query = "SELECT * FROM Employee WHERE salary > 1000000";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Salary: " + rs.getDouble("salary"));
            System.out.println("----------------------");
        }
    }
}
