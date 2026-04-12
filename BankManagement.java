import java.util.*;

class Account {
    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
}

public class BankManagement {
    static HashMap<Integer, Account> accounts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: viewBalance(); break;
            }
        } while (choice != 0);
    }

    static void createAccount() {
        System.out.print("Enter Account No: ");
        int acc = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        accounts.put(acc, new Account(acc, name, 0));
        System.out.println("Account created!");
    }

    static void deposit() {
        System.out.print("Enter Account No: ");
        int acc = sc.nextInt();

        if (accounts.containsKey(acc)) {
            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();
            accounts.get(acc).balance += amt;
            System.out.println("Deposited!");
        } else {
            System.out.println("Account not found!");
        }
    }

    static void withdraw() {
        System.out.print("Enter Account No: ");
        int acc = sc.nextInt();

        if (accounts.containsKey(acc)) {
            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();

            if (amt > accounts.get(acc).balance) {
                System.out.println("Insufficient balance!");
            } else {
                accounts.get(acc).balance -= amt;
                System.out.println("Withdrawn!");
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    static void viewBalance() {
        System.out.print("Enter Account No: ");
        int acc = sc.nextInt();

        if (accounts.containsKey(acc)) {
            System.out.println("Balance: ₹" + accounts.get(acc).balance);
        } else {
            System.out.println("Account not found!");
        }
    }
}