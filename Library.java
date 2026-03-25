import java.util.*;

class Library {
    static ArrayList<String> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. View Books");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    viewBooks();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void addBook() {
        System.out.print("Enter book name: ");
        String book = sc.nextLine();
        books.add(book);
        System.out.println("Book added!");
    }

    static void removeBook() {
        System.out.print("Enter book name to remove: ");
        String book = sc.nextLine();

        if (books.remove(book)) {
            System.out.println("Book removed!");
        } else {
            System.out.println("Book not found!");
        }
    }

    static void searchBook() {
        System.out.print("Enter book name to search: ");
        String book = sc.nextLine();

        if (books.contains(book)) {
            System.out.println("Book is available!");
        } else {
            System.out.println("Book not found!");
        }
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
        } else {
            System.out.println("Books:");
            for (String b : books) {
                System.out.println("- " + b);
            }
        }
    }
}
