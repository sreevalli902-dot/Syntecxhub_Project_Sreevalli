import java.util.*;

class Item {
    String name;
    double price;
    int stock;

    Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

public class InventoryBilling {
    static ArrayList<Item> items = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        items.add(new Item("Pen", 10, 50));
        items.add(new Item("Notebook", 40, 30));

        int choice;

        do {
            System.out.println("\n===== INVENTORY MENU =====");
            System.out.println("1. View Items");
            System.out.println("2. Add Item");
            System.out.println("3. Generate Bill");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewItems();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    generateBill();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
            }
        } while (choice != 0);
    }

    static void viewItems() {
        for (Item i : items) {
            System.out.println(i.name + " - ₹" + i.price + " (Stock: " + i.stock + ")");
        }
    }

    static void addItem() {
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        System.out.print("Enter stock: ");
        int stock = sc.nextInt();

        items.add(new Item(name, price, stock));
        System.out.println("Item added!");
    }

    static void generateBill() {
        double total = 0;

        sc.nextLine();
        System.out.print("Enter item name: ");
        String name = sc.nextLine();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        for (Item i : items) {
            if (i.name.equalsIgnoreCase(name) && i.stock >= qty) {
                total = i.price * qty;
                i.stock -= qty;
                System.out.println("Total Bill: ₹" + total);
                return;
            }
        }
        System.out.println("Item not available or insufficient stock!");
    }
}