import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

public class BookMyStayApp {

    static Map<String, Integer> inventory = new HashMap<>();

    static {
        inventory.put("Single", 3);
        inventory.put("Double", 2);
        inventory.put("Suite", 1);
    }

    public static void bookRoom(String guestName, String roomType) throws InvalidBookingException {

        if (!inventory.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        int roomsAvailable = inventory.get(roomType);

        if (roomsAvailable <= 0) {
            throw new InvalidBookingException("No rooms available.");
        }

        inventory.put(roomType, roomsAvailable - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Booking Validation");

        System.out.print("Enter guest name: ");
        String guestName = sc.nextLine();

        System.out.print("Enter room type (Single/Double/Suite): ");
        String roomType = sc.nextLine();

        try {

            bookRoom(guestName, roomType);

        } catch (InvalidBookingException e) {

            System.out.println("Booking failed: " + e.getMessage());
        }

        sc.close();
    }
}