import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class EmployeeManagement {
    static HashMap<Integer, Employee> employees = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== EMPLOYEE MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewEmployees(); break;
                case 3: updateEmployee(); break;
                case 4: deleteEmployee(); break;
                case 0: System.out.println("Thank you!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees.put(id, new Employee(id, name, salary));
        System.out.println("Employee added!");
    }

    static void viewEmployees() {
        for (Employee e : employees.values()) {
            System.out.println("ID: " + e.id + ", Name: " + e.name + ", Salary: ₹" + e.salary);
        }
    }

    static void updateEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        if (employees.containsKey(id)) {
            sc.nextLine();
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new salary: ");
            double salary = sc.nextDouble();

            employees.put(id, new Employee(id, name, salary));
            System.out.println("Updated!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    static void deleteEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        employees.remove(id);
        System.out.println("Deleted!");
    }
}