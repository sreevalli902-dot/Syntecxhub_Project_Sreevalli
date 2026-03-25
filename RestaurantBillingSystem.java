import java.util.*;

class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class RestaurantBillingSystem {

    static List<MenuItem> menu = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Default Menu
        menu.add(new MenuItem("Burger", 120));
        menu.add(new MenuItem("Pizza", 250));
        menu.add(new MenuItem("Pasta", 180));
        menu.add(new MenuItem("Coffee", 80));

        Map<String, Integer> order = new LinkedHashMap<>();

        int choice;

        do {
            System.out.println("\n===== RESTAURANT MENU =====");
            displayMenu();

            System.out.println("\n1. Add Item to Order");
            System.out.println("2. Remove Item from Order");
            System.out.println("3. View Order");
            System.out.println("4. Generate Bill");
            System.out.println("5. Add New Menu Item");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addItem(order);
                    break;
                case 2:
                    removeItem(order);
                    break;
                case 3:
                    viewOrder(order);
                    break;
                case 4:
                    generateBill(order);
                    break;
                case 5:
                    addMenuItem();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    static void displayMenu() {
        int i = 1;
        for (MenuItem item : menu) {
            System.out.println(i++ + ". " + item.name + " - ₹" + item.price);
        }
    }

    static void addItem(Map<String, Integer> order) {
        displayMenu();
        System.out.print("Select item number: ");
        int index = sc.nextInt() - 1;

        if (index < 0 || index >= menu.size()) {
            System.out.println("Invalid item!");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        String itemName = menu.get(index).name;
        order.put(itemName, order.getOrDefault(itemName, 0) + qty);

        System.out.println("Item added!");
    }

    static void removeItem(Map<String, Integer> order) {
        System.out.print("Enter item name to remove: ");
        String name = sc.nextLine();

        if (order.containsKey(name)) {
            order.remove(name);
            System.out.println("Item removed!");
        } else {
            System.out.println("Item not found in order!");
        }
    }

    static void viewOrder(Map<String, Integer> order) {
        if (order.isEmpty()) {
            System.out.println("Order is empty!");
            return;
        }

        System.out.println("\n--- Current Order ---");
        for (String item : order.keySet()) {
            System.out.println(item + " x " + order.get(item));
        }
    }

    static void generateBill(Map<String, Integer> order) {
        if (order.isEmpty()) {
            System.out.println("No items to bill!");
            return;
        }

        double total = 0;

        System.out.println("\n===== BILL =====");

        for (String item : order.keySet()) {
            int qty = order.get(item);
            double price = getPrice(item);
            double cost = price * qty;

            System.out.println(item + " x " + qty + " = ₹" + cost);
            total += cost;
        }

        double gst = total * 0.05; // 5% GST
        double finalAmount = total + gst;

        System.out.println("----------------------");
        System.out.println("Total: ₹" + total);
        System.out.println("GST (5%): ₹" + gst);
        System.out.println("Final Amount: ₹" + finalAmount);
    }

    static double getPrice(String name) {
        for (MenuItem item : menu) {
            if (item.name.equalsIgnoreCase(name)) {
                return item.price;
            }
        }
        return 0;
    }

    static void addMenuItem() {
        System.out.print("Enter new item name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        menu.add(new MenuItem(name, price));
        System.out.println("New item added!");
    }
}
