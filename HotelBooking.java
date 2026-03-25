import java.util.*;

class HotelBooking {
    static boolean[] rooms = new boolean[5]; // 5 rooms
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== HOTEL MENU =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    cancelRoom();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void viewRooms() {
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("Room " + (i + 1) + ": " + (rooms[i] ? "Booked" : "Available"));
        }
    }

    static void bookRoom() {
        System.out.print("Enter room number (1-5): ");
        int room = sc.nextInt() - 1;

        if (room < 0 || room >= rooms.length) {
            System.out.println("Invalid room!");
        } else if (rooms[room]) {
            System.out.println("Room already booked!");
        } else {
            rooms[room] = true;
            System.out.println("Room booked successfully!");
        }
    }

    static void cancelRoom() {
        System.out.print("Enter room number to cancel: ");
        int room = sc.nextInt() - 1;

        if (room < 0 || room >= rooms.length) {
            System.out.println("Invalid room!");
        } else if (!rooms[room]) {
            System.out.println("Room is not booked!");
        } else {
            rooms[room] = false;
            System.out.println("Booking cancelled!");
        }
    }
}
