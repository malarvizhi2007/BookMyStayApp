/**
 * ==========================================================
 * MAIN CLASS - UseCase5BookingRequestQueue
 * ==========================================================
 * Demonstrates FIFO booking request handling.
 * @version 5.0
 */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking Request Queue");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Add booking requests
        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Subha", "Double"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Process requests
        while (bookingQueue.hasPendingRequests()) {

            Reservation request = bookingQueue.getNextRequest();

            System.out.println(
                    "Processing booking for Guest: "
                            + request.getGuestName()
                            + ", Room Type: "
                            + request.getRoomType()
            );
        }
    }
}