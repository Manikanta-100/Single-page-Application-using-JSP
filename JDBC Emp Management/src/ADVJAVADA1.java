import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ADVJAVADA1{
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USERNAME = "root";
    private static final String PASSWORD = ""; 
    public static Connection conn = null;
    public static  Statement stmt =null;
    public static Scanner s = new Scanner(System.in);
    
    public static void main(String args[])
    {
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
                stmt = conn.createStatement();
                System.out.println("hello world");
                //Initial Creation of Employement Table 
               createEmployeeTable();
                
               //Displaying options for Users to Select
                while(true){
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
                    
                    switch(choice){
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
                
        }
        catch (ClassNotFoundException | SQLException e) 
        {
            e.printStackTrace();
            }
    }
    
    //Method for Table Creation
    public static void createEmployeeTable() throws SQLException{
        String query = "CREATE TABLE IF NOT EXISTS Employee (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "department VARCHAR(255)," +
                "designation VARCHAR(255)," +
                "salary DOUBLE," +
                "hire_date DATE)";
        stmt.executeUpdate(query);
    }
    
    //Method for Adding New Employee to the Table
    public static void addEmployee() throws SQLException{
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

        String insertSQL = "INSERT INTO Employee (name, department, designation, salary, hire_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.setString(3, designation);
            pstmt.setDouble(4, salary);
            pstmt.setDate(5, Date.valueOf(hireDate));
            pstmt.executeUpdate();
            System.out.println("Employee added successfully...!");
        }
    }
    
    //Method for Displaying Details of the Employee
    public static void viewEmployeeDetails() throws SQLException
    {
        System.out.print("Enter the Employeee ID:");
        int id = s.nextInt();
        
        String query = "SELECT * FROM Employee WHERE id=?";
        try(PreparedStatement pstmt = conn.prepareStatement(query))
        {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) 
            {
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
    
    //Method for Displaying all Employees
    public static void viewEmployees() throws SQLException
    {
        String query = "SELECT * FROM Employee";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) 
        {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Department: " + rs.getString("department"));
            System.out.println("Designation: " + rs.getString("designation"));
            System.out.println("Salary: " + rs.getDouble("salary"));
            System.out.println("Hire Date: " + rs.getDate("hire_date"));
            System.out.println("----------------------");
        }       
    }
    
    //Method for Updting Details of the Employee
    public static void updateDetails() throws SQLException 
    {
        System.out.print("Enter employee ID to update: ");
        int employeeId = s.nextInt();

        String query = "SELECT * FROM Employee WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) 
        {
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) 
            {
                System.out.print("Enter new salary: ");
                double newSalary = s.nextDouble();

                String updatequery = "UPDATE Employee SET salary = ? WHERE id = ?";
                try (PreparedStatement updatePstmt = conn.prepareStatement(updatequery)) 
                {
                    updatePstmt.setDouble(1, newSalary);
                    updatePstmt.setInt(2, employeeId);
                    updatePstmt.executeUpdate();
                    System.out.println("Employee updated successfully!");
                }
            } 
            else 
            {
                System.out.println("Employee with ID " + employeeId + " not found.");
            }
        }
    }
    
    //Method for Deleting Details of the Employee
    public static void deleteEmployee() throws SQLException {
        System.out.print("Enter employee ID to delete: ");
        int employeeId = s.nextInt();

        String query = "DELETE FROM Employee WHERE id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee deleted successfully!");
            } 
            else {
                System.out.println("Employee with ID " + employeeId + " not found.");
            }
        }
    }
    
    //Method for Generating payslips of the Employee
    public static void generatePaySlip()throws SQLException {
        System.out.print("Enter employee ID for pay slip: ");
        int employeeId = s.nextInt();

        String query = "SELECT * FROM Employee WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                double salary = rs.getDouble("salary");

                // Sample logic for net salary calculation (assuming 10% deduction for simplicity)
                double deductions = salary * 0.1;
                double allowances = 1000.0; // Sample allowance
                double netSalary = salary - deductions + allowances;
                
                System.out.println("Pay Slip for Employee ID " + employeeId);
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Designation: " + rs.getString("designation"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("Deductions: " + deductions);
                System.out.println("Allowances: " + allowances);
                System.out.println("Net Salary: " + netSalary);
                System.out.println("------------------------------");
            } else {
                System.out.println("Employee with ID " + employeeId + " not found.");
            }
        }
    }
    
    //Method for Displaying Details of the Employee whose salary greater than 10LPA
    public static void salaryGT10()throws SQLException 
    {
        String query = "SELECT * FROM Employee WHERE salary > 1000000";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) 
        {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Salary: " + rs.getDouble("salary"));
            System.out.println("----------------------");
        }
    }

}