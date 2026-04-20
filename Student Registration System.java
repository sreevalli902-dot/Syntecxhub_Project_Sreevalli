import java.sql.*;
import java.util.Scanner;

public class StudentDB {
    static final String URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        Scanner sc = new Scanner(System.in);

        System.out.println("1.Add 2.View");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES (?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();

            System.out.println("Student Added!");
        }

        if (choice == 2) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        }

        con.close();
    }
}