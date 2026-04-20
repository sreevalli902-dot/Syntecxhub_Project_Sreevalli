import java.sql.*;
import java.util.Scanner;

public class HospitalDB {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        PreparedStatement ps = con.prepareStatement("INSERT INTO patients VALUES (?,?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.executeUpdate();

        System.out.println("Patient Added!");

        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM patients");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }

        con.close();
    }
}