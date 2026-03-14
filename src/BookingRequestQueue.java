import java.util.LinkedList;
import java.util.Queue;

/**
 * ==========================================================
 * CLASS - BookingRequestQueue
 * ==========================================================
 * Manages booking requests using FIFO ordering.
 * @version 5.0
 */

public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    // Get next request
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    // Check if queue has requests
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}