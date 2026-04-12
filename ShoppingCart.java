import java.util.*;

public class ShoppingCart {
    static HashMap<String, Double> products = new HashMap<>();
    static HashMap<String, Integer> cart = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        products.put("Laptop", 50000.0);
        products.put("Phone", 20000.0);
        products.put("Headphones", 2000.0);

        int choice;

        do {
            System.out.println("\n===== SHOPPING MENU =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: viewProducts(); break;
                case 2: addToCart(); break;
                case 3: viewCart(); break;
                case 4: checkout(); break;
            }
        } while (choice != 0);
    }

    static void viewProducts() {
        for (String p : products.keySet()) {
            System.out.println(p + " - ₹" + products.get(p));
        }
    }

    static void addToCart() {
        sc.nextLine();
        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        if (products.containsKey(name)) {
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            cart.put(name, cart.getOrDefault(name, 0) + qty);
            System.out.println("Added to cart!");
        } else {
            System.out.println("Product not found!");
        }
    }

    static void viewCart() {
        for (String item : cart.keySet()) {
            System.out.println(item + " x " + cart.get(item));
        }
    }

    static void checkout() {
        double total = 0;

        for (String item : cart.keySet()) {
            total += products.get(item) * cart.get(item);
        }

        System.out.println("Total Bill: ₹" + total);
    }
}