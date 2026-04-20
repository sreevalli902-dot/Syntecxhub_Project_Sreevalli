import java.sql.*;
import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        PreparedStatement ps = con.prepareStatement("INSERT INTO payroll VALUES (?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, salary);
        ps.executeUpdate();

        System.out.println("Employee Added!");

        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM payroll");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " ₹" + rs.getDouble(3));
        }

        con.close();
    }
}